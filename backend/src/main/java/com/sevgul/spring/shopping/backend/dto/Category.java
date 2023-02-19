package com.sevgul.spring.shopping.backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) int id;
	private String category;
	private String description;
	@Column(name = "image_url") private String image;
	@Column(name = "is_active") private boolean active;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + ", description=" + description + ", image=" + image
				+ ", active=" + active + "]";
	}

	

}
