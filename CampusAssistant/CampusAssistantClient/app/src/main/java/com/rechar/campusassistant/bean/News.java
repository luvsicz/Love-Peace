package com.rechar.campusassistant.bean;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class News extends DataSupport{
    private int newsid;
    private String title;//标题
    private String description;
    private String content;//内容
    private String pdate;//发布时间
    private String img;//图片
    private String url;//相关链接
    private String src;//新闻来源
    private int userid;//录入人员
    private int newstype;//新闻分类
    private int readstatus;//是否可阅
    private List<Comment> comments = new ArrayList<Comment>();

    public int getNewsid() {
        return newsid;
    }

    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getNewstype() {
        return newstype;
    }

    public void setNewstype(int newstype) {
        this.newstype = newstype;
    }

    public int getReadstatus() {
        return readstatus;
    }

    public void setReadstatus(int readstatus) {
        this.readstatus = readstatus;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
