package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.domain.Member;
import com.study.Ex14ReadDB.dto.LoginDto;
import com.study.Ex14ReadDB.service.AdminService;
import com.study.Ex14ReadDB.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final MemberService memberService;

    @GetMapping("")
    public String adminLogin(){
        return "/admin/admin_login";
    }

    @GetMapping("/admin_member")
    public String admin_member(){
        return "/admin/admin_member";
    }

    @GetMapping("/admin_notice")
    public String admin_notice(){
        return "/admin/admin_notice";
    }

    @GetMapping("/admin_notice_view")
    public String admin_notice_view(){
        return "/admin/admin_notice_view";
    }

    @GetMapping("/admin_notice_write")
    public String admin_notice_write(){
        return "/admin/admin_notice_write";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, @ModelAttribute LoginDto dto){
        //아이디 존재 체크
        boolean findID = adminService.findByMemberId(dto.getLoginID());
        if(findID){
            boolean findPw=adminService.isRightPw(dto);
            if(findPw) {
                HttpSession session = request.getSession(); // 세션을 생성해서
                session.setAttribute("userId", dto.getLoginID());

                return "<script>alert('로그인되었습니다.'); location.href='/admin/admin_member';</script>";
            }
            return "<script>alert('비밀번호가 다릅니다.');  history.back();</script>";
        }
        return "<script>alert('아이디가 존재하지 않습니다.'); history.back();</script>";
    }

    @GetMapping("/member-list")
    @ResponseBody
    public List<Member> getMemberList(@RequestParam String order, @RequestParam int n){
        return memberService.getAllMembers(order, n);
    }


    @GetMapping("/member-list/search")
    @ResponseBody
    public List<Member> searchMembers(
            @RequestParam String option,
            @RequestParam String keyword,
            @RequestParam String order,
            @RequestParam int n) {
        return memberService.searchMembers(option, keyword, order, n);
    }
}
