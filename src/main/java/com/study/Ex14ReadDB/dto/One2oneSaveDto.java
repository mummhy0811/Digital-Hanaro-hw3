package com.study.Ex14ReadDB.dto;

import com.study.Ex14ReadDB.domain.One2one;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class One2oneSaveDto {
    private String one2oneName;
    private String one2onePhone;
    private String one2oneEmail;
    private String one2oneAddress;
    private String one2oneDetailAddress;
    private String one2oneTitle;
    private String one2oneContent;

    @Builder
    public One2oneSaveDto(String one2oneName, String one2onePhone, String one2oneEmail, String one2oneAddress, String one2oneDetailAddress, String one2oneTitle, String one2oneContent) {
        this.one2oneName = one2oneName;
        this.one2onePhone = one2onePhone;
        this.one2oneEmail = one2oneEmail;
        this.one2oneAddress = one2oneAddress;
        this.one2oneDetailAddress = one2oneDetailAddress;
        this.one2oneTitle = one2oneTitle;
        this.one2oneContent = one2oneContent;
    }

    public One2one toEntity(){
        return One2one.builder()
                .one2oneName(one2oneName)
                .one2oneAddress(one2oneAddress+" "+one2oneDetailAddress)
                .one2oneContent(one2oneContent)
                .one2oneDate(LocalDateTime.now())
                .one2oneEmail(one2oneEmail)
                .one2onePhone(one2onePhone)
                .one2oneTitle(one2oneTitle)
                .build();
    }
}
