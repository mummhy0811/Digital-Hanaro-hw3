package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.dto.One2oneSaveDto;
import com.study.Ex14ReadDB.service.One2oneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final One2oneService one2oneService;

    @PostMapping("/one2one")
    public String one2one(@ModelAttribute One2oneSaveDto dto){
        int id=one2oneService.saveOne2one(dto);
        if(one2oneService.checkExistsById(id)) return "<script>alert('1:1 문의가 전송되었습니다.');  location.href='/';</script>";
        return "<script>alert('1:1 문의 등록을 실패했습니다.');  history.back();</script>";
    }
}
