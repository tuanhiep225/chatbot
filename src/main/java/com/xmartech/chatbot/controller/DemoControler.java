/**
 * 
 */
package com.xmartech.chatbot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmartech.chatbot.model.User;

/**
 * @author tuanhiep225
 *
 */
@RestController
@RequestMapping("/api/v1/demo")
public class DemoControler {
	@GetMapping("/get-object")
	public User getObject(String name) {
		return User.builder().name("Nguyễn Tuấn Hiệp").phone("0984599264").email("tuanhiep225@gmail.com").build();
	}
}
