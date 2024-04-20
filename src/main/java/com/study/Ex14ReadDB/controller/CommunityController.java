package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.domain.Notice;
import com.study.Ex14ReadDB.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping("/community01")
    public String community01(Model model){
        return "/community/community01";
    }
    @GetMapping("/community01_1")
    public String community01_1(@RequestParam int no, Model model){
        Notice notice = communityService.findById(no);
        model.addAttribute("notice", notice);
        return "/community/community01_1";
    }

    @GetMapping("/community01/list")
    @ResponseBody
    public List<Notice> community01(){
        return communityService.getNotices();
    }

    @GetMapping("/community01/search")
    @ResponseBody
    public List<Notice> community01(@RequestParam String select, @RequestParam String word){
        return communityService.searchNotices(select, word);
    }
}
