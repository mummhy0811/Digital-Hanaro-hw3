package com.study.Ex14ReadDB.service;

import com.study.Ex14ReadDB.domain.IOne2oneRepository;
import com.study.Ex14ReadDB.domain.IQnARepository;
import com.study.Ex14ReadDB.domain.One2one;
import com.study.Ex14ReadDB.domain.QnA;
import com.study.Ex14ReadDB.dto.One2oneSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final IOne2oneRepository iOne2oneRepository;
    private final IQnARepository iQnARepository;

    public int saveOne2one(One2oneSaveDto dto){
        One2one one2one = dto.toEntity();
        iOne2oneRepository.save(one2one);
        return one2one.getOne2oneIdx();
    }

    public boolean checkExistsById(int id){
        return iOne2oneRepository.findById(id).isPresent();
    }
    public List<QnA> findAllQnA(){
        return iQnARepository.findAll();
    }

    public List<QnA> searchQnA(String select, String word){

        if(select.equals("제목")) return iQnARepository.findAllByQnATitle(word);
        else if(select.equals("내용")) return iQnARepository.findAllByQnAContent(word);
        return iQnARepository.findAllByQnAName(word);
    }
}
