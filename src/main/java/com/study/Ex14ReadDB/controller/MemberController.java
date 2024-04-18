package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.dto.MemberSaveDto;
import com.study.Ex14ReadDB.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @PostMapping("/joinAction")
    public String joinMember(@ModelAttribute MemberSaveDto dto){
        System.out.println("-------------------------"+dto.getMemberEmailReceive());
        System.out.println("-------------------------"+dto.getMemberEmail());
        System.out.println("-------------------------"+dto.getMemberBirthDate());
        int idx = memberService.saveMember(dto);
        if(memberService.findByIdx(idx)) return "성공";
        return "실패";
    }
    @GetMapping("/")
    public String findById(@RequestParam String memberId){
        boolean find = memberService.findByMemberId(memberId);
        if(find) return "<script>alert('아이디가 중복됩니다');  history.back();</script>";
        return "<script>alert('아이디 사용가능합니다'); history.back();</script>";
    }
}
