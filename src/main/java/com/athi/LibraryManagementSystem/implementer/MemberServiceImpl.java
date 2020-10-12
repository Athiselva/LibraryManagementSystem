package com.athi.LibraryManagementSystem.implementer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athi.LibraryManagementSystem.repository.MemberRepository;
import com.athi.LibraryManagementSystem.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
}
