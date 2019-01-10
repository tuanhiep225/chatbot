/**
 * 
 */
package com.xmartech.chatbot.model;

import javax.jdo.annotations.Unique;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.xmartech.chatbot.model.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tuanhiep225
 *
 */
@Document(collection = "InformationRequestModel")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformationRequestModel extends BaseEntity<String>{
	private String id;
	private String hoten;
	private String thamgialuc;
	private String bot_id;
	private String bot_token;
	private String bot_link;
	@Unique
	private String messid;
	private String ref;
	private String linkgioithieu;
	@Override
	public String getId() {
		return this.id;
	}
	@Override
	public void setId(String id) {
		this.id= id;
	}
}
