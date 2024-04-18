package com.study.Ex14ReadDB.dto;

import com.study.Ex14ReadDB.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveDto {

    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
    private String memberEmailReceive;
    private int memberPwQuestion;
    private String memberPwAnswer;
    private String memberGender;
    private LocalDate memberBirthDate;

    @Builder
    public MemberSaveDto(String memberId, String memberPw, String memberName, String memberEmail, String memberEmailReceive, int memberPwQuestion, String memberPwAnswer, String memberGender, LocalDate memberBirthDate) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberEmailReceive = memberEmailReceive;
        this.memberPwQuestion = memberPwQuestion;
        this.memberPwAnswer = memberPwAnswer;
        this.memberGender = memberGender;
        this.memberBirthDate = memberBirthDate;
    }

    public Member toEntity(){
        return Member.builder()
                .memberId(memberId)
                .memberPw(memberPw)
                .memberName(memberName)
                .memberEmail(memberEmail)
                .memberEmailReceive(Integer.parseInt(memberEmailReceive))
                .memberPwQuestion(memberPwQuestion)
                .memberPwAnswer(memberPwAnswer)
                .memberGender(memberGender)
                .memberBirthDate(memberBirthDate)
                .build();
    }
}
