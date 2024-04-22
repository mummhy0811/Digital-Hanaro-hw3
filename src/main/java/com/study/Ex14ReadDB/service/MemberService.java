package com.study.Ex14ReadDB.service;

import com.study.Ex14ReadDB.domain.IMemberRepository;
import com.study.Ex14ReadDB.domain.Member;
import com.study.Ex14ReadDB.dto.LoginDto;
import com.study.Ex14ReadDB.dto.MemberSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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
            if(n==0) return iMemberRepository.findAllByOrderByMemberIdAsc();
            if(n==5) return iMemberRepository.findTop5ByOrderByMemberIdAsc();
            return iMemberRepository.findTop10ByOrderByMemberIdAsc();
        }else if(s.equals("id_desc")){
            if(n==0) return iMemberRepository.findAllByOrderByMemberIdDesc();
            if(n==5) return iMemberRepository.findTop5ByOrderByMemberIdDesc();
            return iMemberRepository.findTop10ByOrderByMemberIdDesc();
        }else if(s.equals("join_date_asc")){
            if(n==0) return iMemberRepository.findAllByOrderByMemberJoinDateAsc();
            if(n==5) return iMemberRepository.findTop5ByOrderByMemberJoinDateAsc();
            return iMemberRepository.findTop10ByOrderByMemberJoinDateAsc();
        }else{
            if(n==0) return iMemberRepository.findAllByOrderByMemberJoinDateDesc();
            if(n==5) return iMemberRepository.findTop5ByOrderByMemberJoinDateDesc();
            return iMemberRepository.findTop10ByOrderByMemberJoinDateDesc();
        }
    }

    public List<Member> searchMembers(String option, String keyword, String order, int n) {
        List<Member> members = switch (option) {
            case "id" -> iMemberRepository.findByMemberIdContainingIgnoreCase(keyword);
            case "name" -> iMemberRepository.findByMemberNameContainingIgnoreCase(keyword);
            case "email" -> iMemberRepository.findByMemberEmailContainingIgnoreCase(keyword);
            default -> iMemberRepository.searchAllMembers(keyword);
        };

        // 정렬 적용
        switch (order) {
            case "id_desc":
                members.sort(Comparator.comparing(Member::getMemberId).reversed());
                break;
            case "join_date_asc":
                members.sort(Comparator.comparing(Member::getMemberJoinDate));
                break;
            case "join_date_desc":
                members.sort(Comparator.comparing(Member::getMemberJoinDate).reversed());
                break;
            default:
                members.sort(Comparator.comparing(Member::getMemberId));
                break;
        }

        // 페이지네이션 적용
        if( n == 0){
            return members;
        }
        else if (n == 5) {
            return members.subList(0, Math.min(5, members.size()));
        } else {
            return members.subList(0, Math.min(10, members.size()));
        }
    }
}
