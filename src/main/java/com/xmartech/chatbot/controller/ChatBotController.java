/**
 * 
 */
package com.xmartech.chatbot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmartech.chatbot.model.RequestInviteModel;
import com.xmartech.chatbot.model.ResponseChatfuel;
import com.xmartech.chatbot.model.Text;
import com.xmartech.chatbot.model.User;

/**
 * @author tuanhiep225
 *
 */
@RestController
@RequestMapping("/api/v1/chatbot")
public class ChatBotController {
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
	
	@PostMapping("/request-invite")
	public ResponseChatfuel postObject(@RequestBody RequestInviteModel data) {
		String linkgioithieu = "https://"+data.getBot_link()+"?ref=viral"+data.getMessid();
		Map attributes = new HashMap<String, String>();
		attributes.put("linkgioithieu", linkgioithieu);
		return ResponseChatfuel.builder().set_attributes(attributes).build();
	}
}
