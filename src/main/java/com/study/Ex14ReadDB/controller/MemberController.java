package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.dto.BooleanStatusDto;
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
        int idx = memberService.saveMember(dto);
        if(memberService.findByIdx(idx)) return "<script>alert('회원가입 되었습니다');  history.back();</script>";
        return "<script>alert('회원가입 실패했습니다');  history.back();</script>";
    }
    @GetMapping("/check-duple")
    public BooleanStatusDto findById(@RequestParam String memberId){
        boolean find = memberService.findByMemberId(memberId);
        return new BooleanStatusDto(find);
    }
}
