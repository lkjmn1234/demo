package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

public class Demo {

  @Id
  private Integer id;
  private String demo;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDemo() {
    return demo;
  }

  public void setDemo(String demo) {
    this.demo = demo;
  }
}
