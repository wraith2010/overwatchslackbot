package com.ten31f.overwatch.slack;

import java.util.List;

public class Attachment {

	private String color;
	private String fallback;
	private String pretext;
	private String author_name;
	private String author_link;
	private String author_icon;
	private String title;
	private String title_link;
	private String text;
	private String image_url;
	private String thumb_url;
	private String footer;
	private String footer_icon;
	private String ts;
	private List<Field> fields;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFallback() {
		return fallback;
	}

	public void setFallback(String fallback) {
		this.fallback = fallback;
	}

	public String getPretext() {
		return pretext;
	}

	public void setPretext(String pretext) {
		this.pretext = pretext;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getAuthor_link() {
		return author_link;
	}

	public void setAuthor_link(String author_link) {
		this.author_link = author_link;
	}

	public String getAuthor_icon() {
		return author_icon;
	}

	public void setAuthor_icon(String author_icon) {
		this.author_icon = author_icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle_link() {
		return title_link;
	}

	public void setTitle_link(String title_link) {
		this.title_link = title_link;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getThumb_url() {
		return thumb_url;
	}

	public void setThumb_url(String thumb_url) {
		this.thumb_url = thumb_url;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getFooter_icon() {
		return footer_icon;
	}

	public void setFooter_icon(String footer_icon) {
		this.footer_icon = footer_icon;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

}
