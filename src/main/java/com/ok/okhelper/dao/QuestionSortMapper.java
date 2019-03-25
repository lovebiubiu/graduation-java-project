package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.QuestionSort;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component(value = "QuestionSortMapper")
public interface QuestionSortMapper extends MyMapper<QuestionSort> {
    List<QuestionSort> getSortList();
}