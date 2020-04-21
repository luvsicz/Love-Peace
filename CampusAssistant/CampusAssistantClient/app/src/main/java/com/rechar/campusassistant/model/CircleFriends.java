package com.rechar.campusassistant.model;

/**
 * create by bamboo time 2020/4/5
 */
public class CircleFriends {

  private String username;
  private String content;
  private String postDate;
  private int friendsId;

  public CircleFriends(String username, String content, String postDate, int friendsId) {
    this.username = username;
    this.content = content;
    this.postDate = postDate;
    this.friendsId = friendsId;
  }

  public CircleFriends(String username, String content, String postDate) {
    this.username = username;
    this.content = content;
    this.postDate = postDate;
  }

  public int getFriendsId() {
    return friendsId;
  }

  public void setFriendsId(int friendsId) {
    this.friendsId = friendsId;
  }

  public String getUserName() {
    return username;
  }

  public void setUserName(String username) {
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



