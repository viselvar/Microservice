package com.capgemini.callforcode.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.callforcode.controller.HackathonConstant;
import com.capgemini.callforcode.dtos.FeedbackMasterDto;
import com.capgemini.callforcode.repositories.ICampMasterRepository;
import com.capgemini.callforcode.repositories.IFeedbackMasterRepository;
import com.cg.hackathon.ref.entity.CampDetailsEntity;
import com.cg.hackathon.ref.entity.FeedbackTableEntity;

@Service
public class FeedbackMasterServiceImpl implements IFeedbackMasterService {

	@Autowired
	IFeedbackMasterRepository feedbackMasterRepository;

	@Autowired
	ICampMasterRepository iCampMasterRepository;

	@Override
	public String getFeedbackNames(FeedbackMasterDto feedbackMasterDto) {
		String result = "";
		try {

			FeedbackTableEntity feedbackTableEntity = new FeedbackTableEntity();

			feedbackTableEntity.setFeedbackId(feedbackMasterDto.getFeedbackId());
			feedbackTableEntity.setSubmitterName(feedbackMasterDto.getSubmitterName());

			CampDetailsEntity campDetailsEntity = new CampDetailsEntity();
			long campId = iCampMasterRepository.getCampIdDetails(feedbackMasterDto.getCampName(),
					feedbackMasterDto.getAddress());
			campDetailsEntity.setCampId(campId);
			feedbackTableEntity.setCampDetailsEntity(campDetailsEntity);

			feedbackTableEntity.setContactNumber(feedbackMasterDto.getContactNumber());
			feedbackTableEntity.setEmailId(feedbackMasterDto.getEmailId());
			feedbackTableEntity.setFeedbackMessage(feedbackMasterDto.getFeedbackMessage());
			feedbackTableEntity.setCreatedBy(feedbackMasterDto.getCreatedBy());
			feedbackTableEntity.setUpdatedBy(feedbackMasterDto.getUpdatedBy());

			DateFormat dateformat = new SimpleDateFormat(HackathonConstant.DATE);
			Date date = new Date();
			dateformat.format(date);

			feedbackTableEntity.setCreatedDate(date);
			feedbackTableEntity.setUpdatedDate(date);
			feedbackTableEntity.setActiveFlag('Y');
			feedbackMasterRepository.save(feedbackTableEntity);
			result = "success";
		}

		catch (Exception e) {
			System.out.println(e);
			result = "failed";
		}
		return result;
	}

}
