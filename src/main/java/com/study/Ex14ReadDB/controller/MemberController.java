package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.dto.*;
import com.study.Ex14ReadDB.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @PostMapping("/joinAction")
    public String joinMember(@ModelAttribute MemberSaveDto dto){
        int idx = memberService.saveMember(dto);
        if(memberService.findByIdx(idx)) return "<script>alert('회원가입 되었습니다');  location.href='/member/login';</script>";
        return "<script>alert('회원가입 실패했습니다');  history.back();</script>";
    }
    @GetMapping("/check-duple")
    public BooleanStatusDto findById(@RequestParam String memberId){
        boolean find = memberService.findByMemberId(memberId);
        return new BooleanStatusDto(find);
    }

    @PostMapping("/loginAction")
    public String loginAction(HttpServletRequest request, @ModelAttribute LoginDto dto){
        //아이디 존재 체크
        boolean findID = memberService.findByMemberId(dto.getLoginID());
        if(findID){
            boolean findPw=memberService.isRightPw(dto);
            if(findPw) {
                HttpSession session = request.getSession(); // 세션을 생성해서
                session.setAttribute("userId", dto.getLoginID());

                return "<script>alert('로그인되었습니다.'); location.href='/';</script>";
            }
            return "<script>alert('비밀번호가 다릅니다.');  history.back();</script>";
        }
        return "<script>alert('아이디가 존재하지 않습니다.'); history.back();</script>";
    }

    @GetMapping("/idFindAction")
    public String findId(@ModelAttribute FindIdDto dto) {
        String id = memberService.findByMemberNameAndMemberEmail(dto.getUserName(), dto.getUserEmail());
        if (id == "") return "일치하는 정보가 없습니다";
        return "회원님의 아이디는 " + id + "입니다.";
    }

    @GetMapping("/pwFindAction")
    public String findPw(@ModelAttribute FindPwDto dto){
        String pw = memberService.findByMemberIdAndMemberNameAndMemberEmail(dto.getUserID(),dto.getUserName(), dto.getUserEmail());
        if(pw=="") return "일치하는 정보가 없습니다";
        return "회원님의 비밀번호는 "+pw+"입니다.";
    }

}
