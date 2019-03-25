package com.ok.okhelper.pojo.po;

import javax.persistence.*;

@Table(name = "question_detail")
public class QuestionDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "sort_id")
    private Integer sortId;

    private String ask;

    private String answer;

    public QuestionDetail(Integer id, Integer sortId, String ask, String answer) {
        this.id = id;
        this.sortId = sortId;
        this.ask = ask;
        this.answer = answer;
    }

    public QuestionDetail() {
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
     * @return sort_id
     */
    public Integer getSortId() {
        return sortId;
    }

    /**
     * @param sortId
     */
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    /**
     * @return ask
     */
    public String getAsk() {
        return ask;
    }

    /**
     * @param ask
     */
    public void setAsk(String ask) {
        this.ask = ask == null ? null : ask.trim();
    }

    /**
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}