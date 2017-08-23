package com.example.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recommendation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRecommendation;
	private String style;
	private String color;
	private String imageURL;

	public int getIdRecommendation() {
		return idRecommendation;
	}

	public void setIdRecommendation(int idRecommendation) {
		this.idRecommendation = idRecommendation;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Recommendation(String style, String color, String imageURL) {
		super();
		this.style = style;
		this.color = color;
		this.imageURL = imageURL;
	}

	public Recommendation() {
		super();
	}

}
