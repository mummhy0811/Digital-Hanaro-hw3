package com.study.Ex14ReadDB.service;

import com.study.Ex14ReadDB.domain.INoticeRepository;
import com.study.Ex14ReadDB.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final INoticeRepository iNoticeRepository;

    public List<Notice> getNotices(){
        return iNoticeRepository.findAll();
    }

    public Notice findById(int id){
        return iNoticeRepository.findById(id).get();
    }

    public  List<Notice> searchNotices(String select, String word){
        if(select.equals("제목")){
            return iNoticeRepository.findAllByNoticeTitle(word);
        }else{//내용
            return iNoticeRepository.findAllByNoticeMemberId(word);
        }
    }
}
