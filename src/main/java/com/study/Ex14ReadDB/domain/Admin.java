package com.study.Ex14ReadDB.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "company_member_admin")
public class Admin {
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
    @Column(name = "member_join_date", nullable = false)
    private LocalDateTime memberJoinDate= LocalDateTime.now();
}
