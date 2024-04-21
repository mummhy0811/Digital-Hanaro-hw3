package com.study.Ex14ReadDB.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQnARepository extends JpaRepository<QnA, Integer> {
    @Query("select q from QnA q where q.qnaTitle like %:title%")
    List<QnA> findAllByQnATitle(@Param("title") String title);

    @Query("select q from QnA q where q.qnaName like %:memberName%")
    List<QnA> findAllByQnAName(@Param("memberName") String memberName);

    @Query("select q from QnA q where q.qnaContent like %:content%")
    List<QnA> findAllByQnAContent(@Param("content") String content);
}
