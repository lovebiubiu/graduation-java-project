package com.ok.okhelper.pojo.po;

import javax.persistence.*;

public class Friendlylink {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String id;

    @Column(name = "linkName")
    private String linkname;

    @Column(name = "linkUrl")
    private String linkurl;

    @Column(name = "linkDescription")
    private String linkdescription;

    public Friendlylink(String id, String linkname, String linkurl, String linkdescription) {
        this.id = id;
        this.linkname = linkname;
        this.linkurl = linkurl;
        this.linkdescription = linkdescription;
    }

    public Friendlylink() {
        super();
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return linkName
     */
    public String getLinkname() {
        return linkname;
    }

    /**
     * @param linkname
     */
    public void setLinkname(String linkname) {
        this.linkname = linkname == null ? null : linkname.trim();
    }

    /**
     * @return linkUrl
     */
    public String getLinkurl() {
        return linkurl;
    }

    /**
     * @param linkurl
     */
    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl == null ? null : linkurl.trim();
    }

    /**
     * @return linkDescription
     */
    public String getLinkdescription() {
        return linkdescription;
    }

    /**
     * @param linkdescription
     */
    public void setLinkdescription(String linkdescription) {
        this.linkdescription = linkdescription == null ? null : linkdescription.trim();
    }
}