package com.study.Ex14ReadDB.service;

import com.study.Ex14ReadDB.domain.IOne2oneRepository;
import com.study.Ex14ReadDB.domain.One2one;
import com.study.Ex14ReadDB.dto.One2oneSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class One2oneService {
    private final IOne2oneRepository iOne2oneRepository;

    public int saveOne2one(One2oneSaveDto dto){
        One2one one2one = dto.toEntity();
        iOne2oneRepository.save(one2one);
        return one2one.getOne2oneIdx();
    }

    public boolean checkExistsById(int id){
        return iOne2oneRepository.findById(id).isPresent();
    }
}
