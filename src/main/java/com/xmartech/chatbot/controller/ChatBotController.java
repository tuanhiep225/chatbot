/**
 * 
 */
package com.xmartech.chatbot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmartech.chatbot.model.InformationRequestModel;
import com.xmartech.chatbot.model.RequestInviteModel;
import com.xmartech.chatbot.model.ResponseChatfuel;
import com.xmartech.chatbot.model.Text;
import com.xmartech.chatbot.model.User;
import com.xmartech.chatbot.service.InformationRequestModelService;
import com.xmartech.chatbot.utils.ClientHelperUtils;

/**
 * @author tuanhiep225
 *
 */
@RestController
@RequestMapping("/api/v1/chatbot")
public class ChatBotController {
	@Autowired
	private InformationRequestModelService service;
	private Client client;
	
	public ChatBotController() throws Exception {
		client = ClientHelperUtils.createClient();
	}
	private static final Log LOGGER = LogFactory.getLog(ChatBotController.class);
	@GetMapping("/gender")
	public ResponseChatfuel getGender(@RequestParam(value="gender", required= false) String gender) {
		Map<String, String> resutl_gender= new HashMap<String, String>();
		if("male".equals(gender)) {
			resutl_gender.put("gioitinh", "anh");
			resutl_gender.put("GioiTinh", "Anh");
		} else if("female".equals(gender)) {
			resutl_gender.put("gioitinh", "chị");
			resutl_gender.put("GioiTinh", "Chị");
		}
		return ResponseChatfuel.builder().set_attributes(resutl_gender).build();
	}
	
	@RequestMapping(value="/request-invite", method= RequestMethod.POST)
	public ResponseChatfuel postObject(InformationRequestModel data) {
		
		String linkgioithieu = "https://"+data.getBot_link()+"?ref=viral"+data.getMessid();
		Map attributes = new HashMap<String, String>();
		data.setLinkgioithieu(linkgioithieu);
		attributes.put("linkgioithieu", linkgioithieu);
		LOGGER.info(data.toString());
		LOGGER.info(linkgioithieu);
		service.add(data);
		return ResponseChatfuel.builder().set_attributes(attributes).build();
	}
}
