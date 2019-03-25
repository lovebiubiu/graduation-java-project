package com.ok.okhelper.pojo.po;

import javax.persistence.*;

public class User {
    private String uname;

    private String upassword;

    private String email;

    public User(String uname, String upassword, String email) {
        this.uname = uname;
        this.upassword = upassword;
        this.email = email;
    }

    public User() {
        super();
    }

    /**
     * @return uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * @param uname
     */
    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    /**
     * @return upassword
     */
    public String getUpassword() {
        return upassword;
    }

    /**
     * @param upassword
     */
    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}