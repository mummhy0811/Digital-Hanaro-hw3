package com.study.Ex14ReadDB.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "company_one2one")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class One2one {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "one2one_idx", nullable = false)
    private int one2oneIdx;

    @Column(name = "one2one_name", length = 20)
    private String one2oneName;

    @Column(name = "one2one_phone", length = 20)
    private String one2onePhone;
    @Column(name = "one2one_email", length = 100)
    private String one2oneEmail;
    @Column(name = "one2one_address", length = 200)
    private String one2oneAddress;
    @Column(name = "one2one_title", length = 100)
    private String one2oneTitle;
    @Column(name = "one2one_content", length = 100)
    private String one2oneContent;
    @Column(name = "one2one_date", length = 100)
    private LocalDateTime one2oneDate = LocalDateTime.now();

    @Builder
    public One2one(String one2oneName, String one2onePhone, String one2oneEmail, String one2oneAddress, String one2oneTitle, String one2oneContent, LocalDateTime one2oneDate) {
        this.one2oneName = one2oneName;
        this.one2onePhone = one2onePhone;
        this.one2oneEmail = one2oneEmail;
        this.one2oneAddress = one2oneAddress;
        this.one2oneTitle = one2oneTitle;
        this.one2oneContent = one2oneContent;
        this.one2oneDate = one2oneDate;
    }
}
