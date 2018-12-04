/**
 * 
 */
package com.xmartech.chatbot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tuanhiep225
 *
 */
@RestController
@RequestMapping("/api/v1/demo")
public class DemoControler {
	@GetMapping("/get-object")
	public String getObject(String name) {
		return "";
	}
}
