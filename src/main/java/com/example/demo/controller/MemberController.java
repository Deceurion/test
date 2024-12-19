package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.MemberService;
import com.example.demo.dto.ApiResponseDto;
import com.example.demo.dto.MemberForm;
import com.example.demo.dto.MemberResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
public class MemberController {
	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping("/members")
	public ResponseEntity<ApiResponseDto> createMember(@RequestBody MemberForm memberForm) {

		ApiResponseDto responseDto = memberService.createMember(memberForm);
		return ResponseEntity.ok().body(responseDto);

	}

	@GetMapping("/members/{id}")
	public ResponseEntity<MemberResponseDto> getMember(@PathVariable("id") Long id) {
		MemberResponseDto responseDto = memberService.getMember(id);
		return ResponseEntity.ok().body(responseDto);
	}

	@DeleteMapping("/members/{id}")
	public ResponseEntity<ApiResponseDto> deleteMember(@PathVariable("id") Long id) {
		ApiResponseDto responseDto = memberService.deleteMember(id);
		return ResponseEntity.ok().body(responseDto);
	}
	
	@PutMapping ("/members/{id}")
	public ResponseEntity<MemberResponseDto> updateMember(@PathVariable("id") Long id, @RequestBody MemberForm memberForm) {
		MemberResponseDto responseDto = memberService.updateMember(id, memberForm);
		return ResponseEntity.ok().body(responseDto);		
	}
	
	@GetMapping("/members")
	public ResponseEntity<List<MemberResponseDto>> getAllMembers() {
		List<MemberResponseDto> responseDtoList = memberService.getAllMembers();
		return ResponseEntity.ok().body(responseDtoList);
	}

}
