package com.study.Ex14ReadDB.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "company_qna")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QnA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_idx", nullable = false)
    private int qnaIdx;

    @Column(name = "qna_name", length = 20)
    private String qnaName;

    @Column(name = "qna_pw", length = 20)
    private String qnaPw;
    @Column(name = "qna_title", length = 100)
    private String qnaTitle;
    @Column(name = "qna_content", length = 2000)
    private String qnaContent;
    @Column(name = "qna_date", length = 20)
    private LocalDateTime qnaDate;
}
