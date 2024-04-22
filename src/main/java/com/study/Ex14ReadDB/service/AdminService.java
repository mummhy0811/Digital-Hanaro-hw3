package com.study.Ex14ReadDB.service;

import com.study.Ex14ReadDB.domain.*;
import com.study.Ex14ReadDB.dto.EditNoticeDto;
import com.study.Ex14ReadDB.dto.LoginDto;
import com.study.Ex14ReadDB.dto.WriteNoticeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final IAdminRepository iAdminRepository;
    private final INoticeRepository iNoticeRepository;

    public boolean findByMemberId(String id){
        List<Admin> admins = iAdminRepository.findAllByMemberId(id);
        return !admins.isEmpty();
    }
    public boolean isRightPw(LoginDto dto){
        List<Admin> admins = iAdminRepository.findAllByMemberIdAndMemberPw(dto.getLoginID(), dto.getLoginPW());
        return !admins.isEmpty();
    }


    public List<Notice> getAllNotices(String s, int n){
        if(s.equals("id_asc")){
            if(n==0) return iNoticeRepository.findAllByOrderByNoticeMemberIdAsc();
            if(n==5) return iNoticeRepository.findTop5ByOrderByNoticeMemberIdAsc();
            return iNoticeRepository.findTop10ByOrderByNoticeMemberIdAsc();
        }else if(s.equals("id_desc")){
            if(n==0)return iNoticeRepository.findAllByOrderByNoticeMemberIdDesc();
            if(n==5) return iNoticeRepository.findTop5ByOrderByNoticeMemberIdDesc();
            return iNoticeRepository.findTop10ByOrderByNoticeMemberIdDesc();
        }else if(s.equals("reg_date_asc")){
            if(n==0) return iNoticeRepository.findAllByOrderByNoticeDateAsc();
            if(n==5) return iNoticeRepository.findTop5ByOrderByNoticeDateAsc();
            return iNoticeRepository.findTop10ByOrderByNoticeDateAsc();
        }else{
            if(n==0) return iNoticeRepository.findAllByOrderByNoticeDateDesc();
            if(n==5) return iNoticeRepository.findTop5ByOrderByNoticeDateDesc();
            return iNoticeRepository.findTop10ByOrderByNoticeDateDesc();
        }
    }

    public List<Notice> searchNotices(String option, String keyword, String order, int n) {
        List<Notice> notices = switch (option) {
            case "id" -> iNoticeRepository.findByNoticeMemberIdContainingIgnoreCase(keyword);
            case "title" -> iNoticeRepository.findByNoticeTitleContainingIgnoreCase(keyword);
            case "content" -> iNoticeRepository.findByNoticeContentContainingIgnoreCase(keyword);
            default -> iNoticeRepository.searchAllNotice(keyword);
        };

        // 정렬 적용
        switch (order) {
            case "id_desc":
                notices.sort(Comparator.comparing(Notice::getNoticeMemberId).reversed());
                break;
            case "reg_date_asc":
                notices.sort(Comparator.comparing(Notice::getNoticeDate));
                break;
            case "reg_date_desc":
                notices.sort(Comparator.comparing(Notice::getNoticeDate).reversed());
                break;
            default:
                notices.sort(Comparator.comparing(Notice::getNoticeMemberId));
                break;
        }

        // 페이지네이션 적용
        if(n==0) return notices;
        if (n == 5) {
            return notices.subList(0, Math.min(5, notices.size()));
        } else {
            return notices.subList(0, Math.min(10, notices.size()));
        }
    }
    public Notice getNotice(int no){
        return iNoticeRepository.findById(no).get();
    }

    public Notice editNotice(EditNoticeDto dto) throws Exception {
        int noticeIdx = dto.getNoticeIdx();
        String noticeContent = dto.getNoticeContent();

        Optional<Notice> optionalNotice = iNoticeRepository.findById(noticeIdx);
        if (optionalNotice.isPresent()) {
            Notice notice = optionalNotice.get();
            notice.setNoticeContent(noticeContent);
            return iNoticeRepository.save(notice);
        } else {
            throw new Exception("Notice with ID " + noticeIdx + " not found");
        }
    }

    public int writeNotice(String userId, WriteNoticeDto dto){
        System.out.println(dto.getNoticeContent());
        System.out.println(dto.getNoticeTitle());
        Notice notice = Notice.builder().noticeMemberId(userId).noticeTitle(dto.getNoticeTitle()).noticeContent(dto.getNoticeContent()).build();
        iNoticeRepository.save(notice);
        return notice.getNoticeIdx();
    }

    public boolean checkExistNotice(int id){
        return iNoticeRepository.findById(id).isPresent();
    }

}
