package com.study.Ex14ReadDB.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMemberRepository extends JpaRepository<Member, Integer> {

    List<Member> findAllByMemberId(String memberId);

    List<Member> findAllByMemberIdAndMemberPw(String memberId, String memberPw);
}
