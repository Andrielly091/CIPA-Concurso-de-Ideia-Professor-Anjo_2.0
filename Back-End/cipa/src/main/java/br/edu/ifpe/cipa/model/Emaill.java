package br.edu.ifpe.cipa.model;

import lombok.Data;

@Data
public class Emaill {
	
	private String awnerRef;
	private String from;
	private String to;
	private String subject;
	private String text;
	public String getAwnerRef() {
		return awnerRef;
	}
	public void setAwnerRef(String awnerRef) {
		this.awnerRef = awnerRef;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	
	
	

}
