package com.example.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
@ToString(exclude="post")
public class Category {

	
	
    @Id
	public String name;

	private int post_count;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="category")
	private List<Post> postList;
}
