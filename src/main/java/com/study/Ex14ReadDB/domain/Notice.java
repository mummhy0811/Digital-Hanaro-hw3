package com.study.Ex14ReadDB.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="company_notice")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_idx", nullable = false)
    private int noticeIdx;

    @Column(name = "notice_title", nullable = false, length = 100)
    private String noticeTitle;

    @Column(name = "notice_content", nullable = false, length = 2000)
    private String noticeContent;

    @Column(name = "notice_member_id", nullable = false, length = 20)
    private String noticeMemberId;

    @Column(name = "notice_date", nullable = false, length = 100)
    private LocalDateTime noticeDate = LocalDateTime.now();

    @Builder
    public Notice(String noticeTitle, String noticeContent, String noticeMemberId, LocalDateTime noticeDate) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeMemberId = noticeMemberId;
        this.noticeDate = noticeDate;
    }
}
