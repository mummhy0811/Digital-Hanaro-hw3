package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.domain.QnA;
import com.study.Ex14ReadDB.dto.One2oneSaveDto;
import com.study.Ex14ReadDB.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    //---------------------1:1 문의
    @GetMapping("/customer/customer01")
    @ResponseBody
    public String customer01(@SessionAttribute(name = "userId", required = false) String userId){
        if(userId != null) {
            return "<script> location.href='/customer/personalQuestion';</script>";
        } else {
            return "<script>alert('로그인을 해주세요'); window.location.href='/member/login';</script>";
        }
    }
    @GetMapping("/customer/personalQuestion")
    public String customerPersonalQuestion(){
        return "/customer/customer01"; //html반환
    }

    @PostMapping("/one2one")
    @ResponseBody
    public String one2one(@ModelAttribute One2oneSaveDto dto){
        int id=customerService.saveOne2one(dto);
        if(customerService.checkExistsById(id)) return "<script>alert('1:1 문의가 전송되었습니다.');  location.href='/';</script>";
        return "<script>alert('1:1 문의 등록을 실패했습니다.');  history.back();</script>";
    }

    //-----------------------------------QNA
    @GetMapping("/qna-list")
    @ResponseBody
    public List<QnA> getList(){
        return customerService.findAllQnA();
    }

    @GetMapping("/qna/search")
    @ResponseBody
    public List<QnA> searchQna(@RequestParam String select, @RequestParam String word){
        return customerService.searchQnA(select, word);
    }

    @GetMapping("/qna/checkPw")
    @ResponseBody
    public boolean checkPw(@RequestParam int no, @RequestParam String pw){
        return customerService.checkPw(no, pw);
    }

    @GetMapping("/customer/customer02") //묻고 답하기
    @ResponseBody
    public String customer02(@SessionAttribute(name = "userId", required = false) String userId){
        if(userId != null) {
            return "<script> location.href='/customer/QNA';</script>";
        } else {
            return "<script>alert('로그인을 해주세요'); window.location.href='/member/login';</script>";
        }
    }
    @GetMapping("/QNA")
    public String customerQNA(){
        return "/customer/customer02"; //html반환
    }
    @GetMapping("/customer/customer02_2")
    public String customer02_2(){
        return "/customer/customer02_2";
    }
    @GetMapping("/customer/customer02_3")
    public String customer02_3(){
        return "/customer/customer02_3";
    }
    @GetMapping("/customer02_4")
    public String customer02_4(@RequestParam int no, Model model){
        model.addAttribute("qna", customerService.findQnA(no));
        return "/customer/customer02_4";
    }
}
