package com.capgemini.callforcode.controller;
import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.callforcode.services.IContainerMasterService;
import com.capgemini.callforcode.services.IDisasterMasterService;
import com.capgemini.callforcode.services.IMedicalShopMasterService;
import com.cg.hackathon.ref.entity.ContainerMasterEntity;
import com.cg.hackathon.ref.entity.DisasterMasterEntity;
import com.cg.hackathon.ref.entity.MedicalShopMasterEntity;
import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.language_translator.v2.util.Language;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.Context;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
@RestController

public class IbmController {
	@Autowired
	IMedicalShopMasterService iMedicalShopMasterService;

	@Autowired
	IContainerMasterService iContainerMasterService;

	@Autowired
	IDisasterMasterService iDisasterMasterService;

	private String host;

    @ResponseBody
    @RequestMapping("/transcribe")
    public String transcribe(File audio) throws Exception {
    	System.out.println("Hi");
        
    	SpeechToText service = new SpeechToText();
        service.setUsernameAndPassword("e8a943e7-8d0e-4e3f-adc3-cdf6ef65d1a6", "xL4fw3g12SXg" );

/*        File audio = new File("C://Users//predixlabuser//Documents//vidhya//Focus_mp.MP3");
 * 
*/
       // File audio = new File(f);
        SpeechResults result = service.recognize(audio).execute();

        System.out.println(result);
        System.out.println("tra" + result);
        
        String text = null;
        //extract the transcript
        if( !result.getResults().isEmpty() ) {
            //load the list of transcript objects
            List<Transcript> transcripts = result.getResults();
            
            //iterate over the transcripts and select the one with final bool set
            for(Transcript transcript: transcripts){
                if(transcript.isFinal()){
                    text = transcript.getAlternatives().get(0).getTranscript();
                    break;
                }
            }
        }
        //return the transcript
        
        
        return text;
    	
    } 
    
	@RequestMapping(value = "/machineLearning")

	public StringBuffer machineLearning() throws IOException {
		StringBuffer jsonStringScoring = new StringBuffer();

		String value = "\"Norther\",27,\"Chengannur\",2705,\"Alappuzha\",\"18/05/18\",\"Flood / flash flood\"]]";
		HashMap<String, String> wml_credentials = new HashMap<String, String>() {
			{
				put("url", "https://eu-gb.ml.cloud.ibm.com");
				put("username", "2c09fb63-8107-40aa-a201-5e0df14fbe0f");
				put("password", "1f67fecc-5b85-48ec-b3b8-d69114e9bda6");
			}
		};

		String wml_auth_header = "Basic " + Base64.getEncoder()
				.encodeToString((wml_credentials.get("username") + ":" + wml_credentials.get("password"))
						.getBytes(StandardCharsets.UTF_8));
		String wml_url = wml_credentials.get("url") + "/v3/identity/token";
		HttpURLConnection tokenConnection = null;
		HttpURLConnection scoringConnection = null;
		BufferedReader tokenBuffer = null;
		BufferedReader scoringBuffer = null;
		
			// Getting WML token
			System.out.println("getting token....");
			URL tokenUrl = new URL(wml_url);
			tokenConnection = (HttpURLConnection) tokenUrl.openConnection();
			tokenConnection.setDoInput(true);
			tokenConnection.setDoOutput(true);
			tokenConnection.setRequestMethod("GET");
			tokenConnection.setRequestProperty("Authorization", wml_auth_header);
			tokenBuffer = new BufferedReader(new InputStreamReader(tokenConnection.getInputStream()));
			StringBuffer jsonString = new StringBuffer();
			String line;
			while ((line = tokenBuffer.readLine()) != null) {
				jsonString.append(line);
			}
			// Scoring request
			System.out.println("got "+jsonString.toString());
			/*URL scoringUrl = new URL(
					"https://eu-gb.ml.cloud.ibm.com/v3/wml_instances/45ef8e21-eff0-4102-990c-c9030bf39d5f/deployments/63fb6c1d-2c14-476c-b7dc-b285da5e470e/online");
			*/
			URL scoringUrl = new URL(
					"https://eu-gb.ml.cloud.ibm.com/v3/wml_instances/45ef8e21-eff0-4102-990c-c9030bf39d5f/deployments/8be360a0-a44d-44b4-8272-3a276205617f/online");
			
			String wml_token = "Bearer " + jsonString.toString().replace("\"", "").replace("}", "").split(":")[1];
			scoringConnection = (HttpURLConnection) scoringUrl.openConnection();
			scoringConnection.setDoInput(true);
			scoringConnection.setDoOutput(true);
			scoringConnection.setRequestMethod("POST");
			scoringConnection.setRequestProperty("Accept", "application/json");
			scoringConnection.setRequestProperty("Authorization", wml_token);
			scoringConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			System.out.println("set properties");
			OutputStreamWriter writer = new OutputStreamWriter(scoringConnection.getOutputStream(), "UTF-8");

			// NOTE: manually define and pass the array(s) of values to be
			// scored in the next line
			String val="[\"Norther\",27,\"Chengannur\",2705,\"Alappuzha\",\"18/05/18\",\"Flood / flash flood\"]";
			String field="[\"REGION\", \"PROV_CODE\", \"PROV_NAME\", \"DIST_CODE\",\"DIST_NAME\",\"INC_DATE\",\"INC_TYPE\"]";
	//		String payload = "{\"fields\": [\"sepal_length\", \"sepal_width\", \"petal_length\", \"petal_width\"], \"values\": [array_of_values_to_be_scored, another_array_of_values_to_be_scored]}";
			String payload = "{\"fields\":"+field+", \"values\":["+val+"]}";
System.out.println("paylod   . "+payload);
			writer.write(payload);
			writer.close();
System.out.println("grttin response");
			scoringBuffer = new BufferedReader(new InputStreamReader(scoringConnection.getInputStream()));
			String lineScoring;
			while ((lineScoring = scoringBuffer.readLine()) != null) {
				jsonStringScoring.append(lineScoring);
			}
			System.out.println(jsonStringScoring);
		/*catch (IOException e) {
			System.out.println("The URL is not valid.");
			System.out.println(e.getMessage());
		} finally {
			if (tokenConnection != null) {
				tokenConnection.disconnect();
			}*/
			if (tokenBuffer != null) {
				tokenBuffer.close();
			}
			if (scoringConnection != null) {
				scoringConnection.disconnect();
			}
			if (scoringBuffer != null) {
				scoringBuffer.close();
			}
	
		return jsonStringScoring;
	}



	/*

	@RequestMapping(value = "/speechTotext")
	public String speechToText() throws FileNotFoundException  {
		SpeechToText service = new SpeechToText();
		service.setUsernameAndPassword("bb28302a-d576-4dd3-aeff-cd7a27d2a6e1", "iGVgUbbJd76l");

		File audio = new File("src/main/java/sample1.wav");

		RecognizeOptions options = new RecognizeOptions.Builder()
		  .audio(audio)
		  .contentType(HttpMediaType.AUDIO_WAV)
		  .build();

		SpeechRecognitionResults transcript = service.recognize(options).execute();
		System.out.println(transcript);
		System.setProperty("http.proxyHost",host); 
		System.out.println(host);
		String result= transcript.toString();
	    return result;
	}

	@RequestMapping(value = "/textToSpeach")
	public String textToSpeech(){
		TextToSpeech service = new TextToSpeech();
		service.setUsernameAndPassword("4daa0668-cab1-4ff7-9605-0f7a39aef360", "bcENP6pjg8k0");

		Voices voices = service.listVoices().execute();
		System.out.println(voices);
		
		String result= voices.toString();
	    return result;
	}
*/
	@RequestMapping(value = "/languageTrans")
	 public String  languageTrans() {
		 LanguageTranslator service = new LanguageTranslator();
		    service.setUsernameAndPassword("1c3ee65a-29ec-4bf7-b8fa-4242b2a6e128", "FcWzmJWgJ7i3");
		    LanguageTranslator languageTranslator = new LanguageTranslator();
		    languageTranslator.setEndPoint("https://gateway.watsonplatform.net/language-translator/api");
		    TranslateOptions translateOptions = new TranslateOptions.Builder()
		        .addText("get it done")
		        .source(Language.ENGLISH)
		        .target(Language.ARABIC)
		        .build();
		    TranslationResult translationResult = service.translate(translateOptions).execute();

		    System.out.println(translationResult);
		  
String result= translationResult.toString();
		    return result;
		  }

	@RequestMapping(value = "/ChatWatson")
	 public String  ChatWatson() {
		 Conversation service = new Conversation("2018-02-16");
		 service.setUsernameAndPassword("7b30e188-de01-4200-81db-1b885449c0dd", "oQUXtVgFI6w4");
		
		Context context1 = null;

		// first message
		MessageOptions newMessageOptions1 = new MessageOptions.Builder()
		  .workspaceId("5ef934f3-5aa4-4ae3-8ffa-5269a2e80d5f")
		  .input(new InputData.Builder("First message").build())
		  .context(context1)
		  .build();

		MessageResponse response1 = service.message(newMessageOptions1).execute();

		// second message
		newMessageOptions1 = new MessageOptions.Builder()
		  .workspaceId("5ef934f3-5aa4-4ae3-8ffa-5269a2e80d5f")
		  .input(new InputData.Builder("Second message").build())
		  .context(response1.getContext()) // output context from the first message
		  .build(); 

		response1 = service.message(newMessageOptions1).execute();
		InputData input = new InputData.Builder("Help").build();
		 MessageOptions options = new MessageOptions.Builder("5ef934f3-5aa4-4ae3-8ffa-5269a2e80d5f")
		   .input(input)
		   .build();
		 MessageResponse response = service.message(options).execute();
		 System.out.println(response);
		 
		System.out.println(response1);
		return response.toString();
		  }

	@RequestMapping(value = "/getAllMedicalShops")
	 public List<MedicalShopMasterEntity> getAllMedicalShops() {
			return iMedicalShopMasterService.getAllMedicalShops();
		}

	@RequestMapping(value = "/getAllContainers")
	public List<ContainerMasterEntity> getAllContainers() {
		return iContainerMasterService.getAllContainers();
	}

	@RequestMapping(value = "/getAllDisasters")
	public List<DisasterMasterEntity> getAllDisasterMasterEntity() {
		return iDisasterMasterService.getAllDisasters();
	}
}
