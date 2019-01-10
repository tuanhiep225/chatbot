/**
 * 
 */
package com.xmartech.chatbot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmartech.chatbot.model.ResponseChatfuel;
import com.xmartech.chatbot.model.Text;
import com.xmartech.chatbot.model.User;

/**
 * @author tuanhiep225
 *
 */
@RestController
@RequestMapping("/api/v1/demo")
public class DemoControler {
	@GetMapping("/get-object")
	public ResponseChatfuel getObject(@RequestParam("name") String name) {
		List<Text> texts = new ArrayList<Text>();
		
		texts.add(Text.builder().text("Tuấn Hiệp").build());
		texts.add(Text.builder().text("Tuấn Hiệp1").build());
		texts.add(Text.builder().text("Tuấn Hiệp2").build());
		
		return ResponseChatfuel.builder().messages(texts).build();
	}
}
