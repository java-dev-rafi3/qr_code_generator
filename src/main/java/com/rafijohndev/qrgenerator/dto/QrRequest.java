package com.rafijohndev.qrgenerator.dto;

public class QrRequest {

	private String input;
	
	public QrRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public QrRequest(String input) {
		this.input = input;
	}
	
	public void setInput(String input) {
		this.input = input;
	}
	
	public String input() {
		return input;
	}
}
