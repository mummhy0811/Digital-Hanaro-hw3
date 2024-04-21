package com.study.Ex14ReadDB.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
    List<Admin> findAllByMemberId(String memberId);

    List<Admin> findAllByMemberIdAndMemberPw(String memberId, String memberPw);
}
