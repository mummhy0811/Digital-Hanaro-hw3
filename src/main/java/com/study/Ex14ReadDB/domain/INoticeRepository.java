package com.study.Ex14ReadDB.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INoticeRepository extends JpaRepository<Notice, Integer> {
    List<Notice> findAllByOrderByNoticeMemberIdAsc();
    List<Notice> findAllByOrderByNoticeMemberIdDesc();
    List<Notice> findAllByOrderByNoticeDateAsc();
    List<Notice> findAllByOrderByNoticeDateDesc();
    List<Notice> findTop5ByOrderByNoticeMemberIdAsc();
    List<Notice> findTop5ByOrderByNoticeMemberIdDesc();
    List<Notice> findTop5ByOrderByNoticeDateAsc();
    List<Notice> findTop5ByOrderByNoticeDateDesc();

    List<Notice> findTop10ByOrderByNoticeMemberIdAsc();
    List<Notice> findTop10ByOrderByNoticeMemberIdDesc();
    List<Notice> findTop10ByOrderByNoticeDateAsc();
    List<Notice> findTop10ByOrderByNoticeDateDesc();

    @Query("SELECT n FROM Notice n WHERE lower(n.noticeMemberId) LIKE lower(concat('%', :keyword, '%')) OR lower(n.noticeTitle) LIKE lower(concat('%', :keyword, '%')) OR lower(n.noticeContent) LIKE lower(concat('%', :keyword, '%'))")
    List<Notice> searchAllNotice(String keyword);
    List<Notice> findByNoticeMemberIdContainingIgnoreCase(String keyword);
    List<Notice> findByNoticeTitleContainingIgnoreCase(String keyword);
    List<Notice> findByNoticeContentContainingIgnoreCase(String keyword);
}
