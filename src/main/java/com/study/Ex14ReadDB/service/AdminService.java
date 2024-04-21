package com.study.Ex14ReadDB.service;

import com.study.Ex14ReadDB.domain.Admin;
import com.study.Ex14ReadDB.domain.IAdminRepository;
import com.study.Ex14ReadDB.domain.Member;
import com.study.Ex14ReadDB.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final IAdminRepository iAdminRepository;

    public boolean findByMemberId(String id){
        List<Admin> admins = iAdminRepository.findAllByMemberId(id);
        return !admins.isEmpty();
    }
    public boolean isRightPw(LoginDto dto){
        List<Admin> admins = iAdminRepository.findAllByMemberIdAndMemberPw(dto.getLoginID(), dto.getLoginPW());
        return !admins.isEmpty();
    }

}
