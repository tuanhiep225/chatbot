package com.xmartech.chatbot.service;

import com.xmartech.chatbot.model.InformationRequestModel;

public interface InformationRequestModelService {
	public InformationRequestModel getInformationRequestModelByRef(String ref);
	
	public InformationRequestModel add(InformationRequestModel entity);
}
