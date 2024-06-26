package com.study.Ex14ReadDB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;


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


    @GetMapping("/customer/customer03") //FAQ
    @ResponseBody
    public String customer03(@SessionAttribute(name = "userId", required = false) String userId){
        if(userId != null) {
            return "<script> location.href='/customer/FAQ';</script>";
        } else {
            return "<script>alert('로그인을 해주세요'); window.location.href='/member/login';</script>";
        }
    }

    @GetMapping("/customer/FAQ")
    public String customerFAQ(){
        return "/customer/customer03"; //html반환
    }

    @GetMapping("/member/findReturn")
    public String findResult(){
        return "/member/findReturn";
    }

}
