package com.example.Transaction.Entity;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private int id;
	@Column(length=64)
	private String name;
	@OneToOne
	@JoinColumn(name="parent_id")
	private Category parent;
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL)
	private Set<Category> children=new HashSet<>();
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(String name) {
		super();
		this.name = name;
	}


	public Category(String name, Category parent) {
		super();
		this.name = name;
		this.parent = parent;
	}


	public long getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Category getParent() {
		return parent;
	}


	public void setParent(Category parent) {
		this.parent = parent;
	}


	public Set<Category> getChildren() {
		return children;
	}


	public void setChildren(Set<Category> children) {
		this.children = children;
	}


	public void addChild(Category childern) {
		this.children.add(childern);
	}
}
