package com.example.demo.service;

import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.ApiResponseDto;
import com.example.demo.dto.MemberResponseDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.dto.MemberForm;
import com.example.demo.domain.Member;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

@Transactional
@Service
public class MemberService {
	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public ApiResponseDto createMember(MemberForm memberForm) {
		Member member = new Member(memberForm.getName());
		memberRepository.save(member);
		return new ApiResponseDto("생성 성공");
	}

	public MemberResponseDto getMember(Long id) {
		Optional<Member> optionalMember = memberRepository.findById(id);
		Member member = optionalMember.orElseThrow(() -> new IllegalArgumentException("회원이 없습니다"));
		return new MemberResponseDto(member.getId(), member.getName());
	}

	public ApiResponseDto deleteMember(Long id) {
		try {
			memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("회원이 없습니다"));

		} catch (IllegalArgumentException e) {
			return new ApiResponseDto(e.getMessage());
		}

		memberRepository.deleteById(id);
		return new ApiResponseDto("회원 삭제 완료");
	}

	public MemberResponseDto updateMember(Long id, MemberForm memberForm) {
		Optional<Member> optionalMember = memberRepository.findById(id);
		Member member = optionalMember.orElseThrow(() -> new IllegalArgumentException("회원이 없습니다"));
		member.update(memberForm.getName());
		return new MemberResponseDto(member.getId(), member.getName());
	}

	public List<MemberResponseDto> getAllMembers() {
		List<Member> memberList = memberRepository.findAll();
		List<MemberResponseDto> dtoList = new ArrayList<>();
		for(Member member : memberList) {
			dtoList.add(new MemberResponseDto(member.getId(), member.getName()));
		}
		return dtoList;
	}
}
