package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.QuestionDetail;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component(value = "QuestionDetailMapper")
public interface QuestionDetailMapper extends MyMapper<QuestionDetail> {
    List<QuestionDetail> getQuestionDetail(int sortId,int num);

    //List<QuestionDetail> getRandomQuestionDetail(int num);
    List<QuestionDetail> getRandomQuestionDetail(int num);
}