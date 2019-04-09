package com.example.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post {
  @Id
  @GeneratedValue

  
  int id;
  String subject;
  String subtitle;
  String content;
  Date reg;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="name")
  public Category category;
  
  
  
}
