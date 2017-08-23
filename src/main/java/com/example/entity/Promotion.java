package com.example.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Promotion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPromotion;
	private int price;
	private String namePromotion;
	private String period;
	private String description;

	@ManyToOne
	@JoinColumn(name = "idSalon", referencedColumnName = "idSalon")
	@JsonBackReference
	private Salon salon;

	public int getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNamePromotion() {
		return namePromotion;
	}

	public void setNamePromotion(String namePromotion) {
		this.namePromotion = namePromotion;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public Promotion(int price, String namePromotion, String period, String description) {
		super();
		this.price = price;
		this.namePromotion = namePromotion;
		this.period = period;
		this.description = description;
	}

	public Promotion() {
		super();
	}

}
