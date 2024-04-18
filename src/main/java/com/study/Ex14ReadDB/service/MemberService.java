package com.study.Ex14ReadDB.service;

import com.study.Ex14ReadDB.domain.IMemberRepository;
import com.study.Ex14ReadDB.domain.Member;
import com.study.Ex14ReadDB.dto.MemberSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final IMemberRepository iMemberRepository;

    public int saveMember(MemberSaveDto dto){
        Member member = dto.toEntity();
        iMemberRepository.save(member);
        return member.getMemberIdx();
    }

    public boolean findByIdx(int idx){
        return iMemberRepository.findById(idx).isPresent();
    }

    //아이디 중복 확인
    public boolean findByMemberId(String id){
        List<Member> members = iMemberRepository.findAllByMemberId(id);
        return !members.isEmpty();
    }
}
