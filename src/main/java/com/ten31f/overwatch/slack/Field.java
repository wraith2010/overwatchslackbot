package com.ten31f.overwatch.slack;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Field {

	private String title;
	private String value;

	@JsonProperty("short")
	private boolean shortBoolean;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isShortBoolean() {
		return shortBoolean;
	}

	public void setShortBoolean(boolean shortBoolean) {
		this.shortBoolean = shortBoolean;
	}

}
