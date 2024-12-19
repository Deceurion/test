package com.example.demo.dto;

public class MemberResponseDto {
	private Long id;
	private String name;

	public MemberResponseDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
}
