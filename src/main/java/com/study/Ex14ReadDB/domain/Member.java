package com.study.Ex14ReadDB.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="company_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_idx", nullable = false)
    private int memberIdx;

    @Column(name = "member_id", nullable = false, length = 20)
    private String memberId;

    @Column(name = "member_pw", nullable = false, length = 20)
    private String memberPw;
    @Column(name = "member_name", nullable = false, length = 20)

    private String memberName;
    @Column(name = "member_email", nullable = false, length = 100)
    private String memberEmail;

    @Column(name = "member_email_receive", nullable = false)
    private int memberEmailReceive;

    @Column(name = "member_pw_question", nullable = false)
    private int memberPwQuestion;
    @Column(name = "member_pw_answer", nullable = false, length = 100)
    private String memberPwAnswer;
    @Column(name = "member_gender", nullable = false, length = 10)
    private String memberGender;
    @Column(name = "member_birth_date", nullable = false)
    private LocalDate memberBirthDate;
    @Column(name = "member_join_date", nullable = false)
    private LocalDateTime memberJoinDate= LocalDateTime.now();

    @Builder
    public Member(String memberId, String memberPw, String memberName, String memberEmail, int memberEmailReceive, int memberPwQuestion, String memberPwAnswer, String memberGender, LocalDate memberBirthDate) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberEmailReceive = memberEmailReceive;
        this.memberPwQuestion = memberPwQuestion;
        this.memberPwAnswer = memberPwAnswer;
        this.memberGender = memberGender;
        this.memberBirthDate = memberBirthDate;
        this.memberJoinDate = LocalDateTime.now();
    }
}
