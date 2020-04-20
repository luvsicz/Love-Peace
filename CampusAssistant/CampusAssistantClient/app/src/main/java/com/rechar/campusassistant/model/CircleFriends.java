package com.rechar.campusassistant.model;

/**
 * create by bamboo time 2020/4/5
 */
public class CircleFriends {

  private String username;
  private String content;
  private String postDate;

  public CircleFriends(String username, String content, String postDate) {
    this.username = username;
    this.content = content;
    this.postDate = postDate;
  }

  public String getId() {
    return username;
  }

  public void setId(String username) {
    this.username = username;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getPostDate() {
    return postDate;
  }

  public void setPostDate(String postDate) {
    this.postDate = postDate;
  }

}



