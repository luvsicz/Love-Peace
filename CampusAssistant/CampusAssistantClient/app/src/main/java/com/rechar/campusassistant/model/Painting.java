package com.rechar.campusassistant.model;

import java.io.Serializable;

/*
 * {
 * STATTE:200,
 * DATA:{
 * A:[],
 * B[]
 * }
 * }
 * List<社团> list=request();
 * list[0].url/ingUrl/name/content
 *
 * */
public class Painting implements Serializable {

  private final int id;
  private final String title;
  private final String content;
  private final String url;

  private static final String TAG = "Painting";

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public int getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public Painting(int id, String title, String content, String url) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.url = url;
  }

}
