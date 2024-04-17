package com.study.Ex14ReadDB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminLogin(){
        return "/admin/admin_login";
    }

    @GetMapping("/admin/admin_member")
    public String admin_member(){
        return "/admin/admin_member";
    }

    @GetMapping("/admin/admin_notice")
    public String admin_notice(){
        return "/admin/admin_notice";
    }

    @GetMapping("/admin/admin_notice_view")
    public String admin_notice_view(){
        return "/admin/admin_notice_view";
    }

    @GetMapping("/admin/admin_notice_write")
    public String admin_notice_write(){
        return "/admin/admin_notice_write";
    }

}
