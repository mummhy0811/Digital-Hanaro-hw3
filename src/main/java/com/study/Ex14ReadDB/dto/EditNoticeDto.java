package com.study.Ex14ReadDB.dto;

import com.study.Ex14ReadDB.domain.Notice;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditNoticeDto {
    private int noticeIdx;
    private String noticeContent;

    public Notice toEntity(){
        return Notice.builder()
                .noticeContent(noticeContent)
                .noticeIdx(noticeIdx).build();
    }
}
