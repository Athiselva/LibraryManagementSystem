package com.athi.LibraryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athi.LibraryManagementSystem.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}
