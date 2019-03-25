package com.ok.okhelper.pojo.po;

import javax.persistence.*;

@Table(name = "question_sort")
public class QuestionSort {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    private String sort;

    public QuestionSort(Integer id, String sort) {
        this.id = id;
        this.sort = sort;
    }

    public QuestionSort() {
        super();
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return sort
     */
    public String getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }
}