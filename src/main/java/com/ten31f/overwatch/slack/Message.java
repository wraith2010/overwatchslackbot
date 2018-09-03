package com.ten31f.overwatch.slack;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Message {

	private String text;
	private ResponseType responseType;
	private List<Attachment> attachments;

	public Message() {

	}

	public Message(ResponseType responseType, String text, List<Attachment> attachments) {
		setText(text);
		setResponseType(responseType);
		setAttachments(attachments);
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}

	public ResponseType getResponseType() {
		return responseType;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public enum ResponseType {
		@JsonProperty("ephemeral")
		EPHEMERAL,

		@JsonProperty("in_channel")
		IN_CHANNEL;
	}

}
