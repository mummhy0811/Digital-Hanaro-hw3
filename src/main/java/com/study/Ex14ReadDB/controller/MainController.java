package com.study.Ex14ReadDB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(){
        return "index"; //index.html로 응답
    }

    @GetMapping("/member/login")
    public String login(){
        return "/member/login";
    }

    @GetMapping("/member/join")
    public String join(){
        return "/member/join2"; //join2.html 응답
    }
    @GetMapping("/idFind")
    public String idFind(){
        return "/member/idFind"; //idFind.html 응답
    }
    @GetMapping("/passwordFind")
    public String passwordFind(){
        return "/member/passwordFind"; //idFind.html 응답
    }
    @GetMapping("/community/community01")
    public String community01(){
        return "/community/community01";
    }
    @GetMapping("community01_1")
    public String community01_1(@RequestParam Long no){
        return "/community/community01_1";
    }
    @GetMapping("/company/company01")
    public String company01(){
        return "/company/company01";
    }
    @GetMapping("/company/company03")
    public String company03(){
        return "/company/company03";
    }
    @GetMapping("/business/business01")
    public String business01(){
        return "/business/business01";
    }
    @GetMapping("/product/product01")
    public String product01(){
        return "/product/product01";
    }
    @GetMapping("/customer/customer01")
    public String customer01(){
        return "/customer/customer01";
    }
    @GetMapping("/customer/customer02")
    public String customer02(){
        return "/customer/customer02";
    }
    @GetMapping("/customer/customer03")
    public String customer03(){
        return "/customer/customer03";
    }

}
