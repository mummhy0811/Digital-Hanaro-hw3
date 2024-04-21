package com.study.Ex14ReadDB.service;

import com.study.Ex14ReadDB.domain.IMemberRepository;
import com.study.Ex14ReadDB.domain.Member;
import com.study.Ex14ReadDB.dto.LoginDto;
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

    public boolean isRightPw(LoginDto dto){
        List<Member> member = iMemberRepository.findAllByMemberIdAndMemberPw(dto.getLoginID(), dto.getLoginPW());
        return !member.isEmpty();
    }

    public String findByMemberNameAndMemberEmail(String name, String email){
        List<Member> member = iMemberRepository.findAllByMemberNameAndMemberEmail(name, email);
        if(member.isEmpty()) return "";
        return member.get(0).getMemberId();
    }

    public String findByMemberIdAndMemberNameAndMemberEmail(String id, String name, String email){
        List<Member> member = iMemberRepository.findAllByMemberIdAndMemberNameAndMemberEmail(id, name, email);
        if(member.isEmpty()) return "";
        return member.get(0).getMemberPw();
    }

    public List<Member> getAllMembers(String s, int n){
        if(s.equals("id_asc")){
            if(n==5) return iMemberRepository.findTop5ByOrderByMemberIdAsc();
            return iMemberRepository.findTop10ByOrderByMemberIdAsc();
        }else if(s.equals("id_desc")){
            if(n==5) return iMemberRepository.findTop5ByOrderByMemberIdDesc();
            return iMemberRepository.findTop10ByOrderByMemberIdDesc();
        }else if(s.equals("join_date_asc")){
            if(n==5) return iMemberRepository.findTop5ByOrderByMemberJoinDateAsc();
            return iMemberRepository.findTop10ByOrderByMemberJoinDateAsc();
        }else{
            if(n==5) return iMemberRepository.findTop5ByOrderByMemberJoinDateDesc();
            return iMemberRepository.findTop10ByOrderByMemberJoinDateDesc();
        }
    }

    // 모든 회원을 반환하는 메서드 (전체 검색)
    public List<Member> searchAll(String keyword) {
        return iMemberRepository.searchAllMembers(keyword);
    }

    // 아이디로 회원을 검색하는 메서드
    public List<Member> searchById(String keyword) {
        return iMemberRepository.findByMemberIdContainingIgnoreCase(keyword);
    }

    // 이름으로 회원을 검색하는 메서드
    public List<Member> searchByName(String keyword) {
        return iMemberRepository.findByMemberNameContainingIgnoreCase(keyword);
    }

    // 이메일로 회원을 검색하는 메서드
    public List<Member> searchByEmail(String keyword) {
        return iMemberRepository.findByMemberEmailContainingIgnoreCase(keyword);
    }
}
