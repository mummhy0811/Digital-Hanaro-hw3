package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.domain.QnA;
import com.study.Ex14ReadDB.dto.One2oneSaveDto;
import com.study.Ex14ReadDB.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/one2one")
    public String one2one(@ModelAttribute One2oneSaveDto dto){
        int id=customerService.saveOne2one(dto);
        if(customerService.checkExistsById(id)) return "<script>alert('1:1 문의가 전송되었습니다.');  location.href='/';</script>";
        return "<script>alert('1:1 문의 등록을 실패했습니다.');  history.back();</script>";
    }
    @GetMapping("/qna-list")
    public List<QnA> getList(){
        return customerService.findAllQnA();
    }

    @GetMapping("/qna/search")
    public List<QnA> searchQna(@RequestParam String select, @RequestParam String word){
        return customerService.searchQnA(select, word);
    }
}
