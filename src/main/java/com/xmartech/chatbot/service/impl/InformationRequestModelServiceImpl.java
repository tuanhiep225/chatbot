package com.xmartech.chatbot.service.impl;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.xmartech.chatbot.model.InformationRequestModel;
import com.xmartech.chatbot.repository.InformationRequestModelRepository;
import com.xmartech.chatbot.service.InformationRequestModelService;

@Service
public class InformationRequestModelServiceImpl implements InformationRequestModelService{

	@Autowired
	private InformationRequestModelRepository repository;
	
	@Override
	public InformationRequestModel getInformationRequestModelByRef(String ref) {
		return repository.getInformationRequestModelByRef(ref);
	}

	@Override
	public InformationRequestModel add(InformationRequestModel entity) {
		return repository.add(entity);
	}

}
