package com.example.demo.dto;

public class ApiResponseDto {
	private String message;

	public ApiResponseDto(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
