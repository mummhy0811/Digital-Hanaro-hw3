package com.study.Ex14ReadDB.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INoticeRepository extends JpaRepository<Notice, Integer> {
    @Query("select n from Notice n where n.noticeTitle like %:title%")
    List<Notice> findAllByNoticeTitle(@Param("title") String title);

    @Query("select n from Notice n where n.noticeMemberId like %:memberId%")
    List<Notice> findAllByNoticeMemberId(@Param("memberId") String memberId);
}
