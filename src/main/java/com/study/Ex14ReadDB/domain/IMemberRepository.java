package com.study.Ex14ReadDB.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMemberRepository extends JpaRepository<Member, Integer> {

    List<Member> findAllByMemberId(String memberId);

    List<Member> findAllByMemberIdAndMemberPw(String memberId, String memberPw);

    List<Member> findAllByMemberNameAndMemberEmail(String memberName, String memberEmail);

    List<Member> findAllByMemberIdAndMemberNameAndMemberEmail(String memberId,String memberName, String memberEmail);

    List<Member> findTop5ByOrderByMemberIdAsc();
    List<Member> findTop5ByOrderByMemberIdDesc();
    List<Member> findTop5ByOrderByMemberJoinDateAsc();
    List<Member> findTop5ByOrderByMemberJoinDateDesc();

    List<Member> findTop10ByOrderByMemberIdAsc();
    List<Member> findTop10ByOrderByMemberIdDesc();
    List<Member> findTop10ByOrderByMemberJoinDateAsc();
    List<Member> findTop10ByOrderByMemberJoinDateDesc();

    @Query("SELECT m FROM Member m WHERE lower(m.memberId) LIKE lower(concat('%', :keyword, '%')) OR lower(m.memberName) LIKE lower(concat('%', :keyword, '%')) OR lower(m.memberEmail) LIKE lower(concat('%', :keyword, '%'))")
    List<Member> searchAllMembers(String keyword);
    List<Member> findByMemberIdContainingIgnoreCase(String keyword);
    List<Member> findByMemberNameContainingIgnoreCase(String keyword);
    List<Member> findByMemberEmailContainingIgnoreCase(String keyword);


}
