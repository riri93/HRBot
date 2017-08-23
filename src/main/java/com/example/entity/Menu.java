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
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMenu;
	private int price;
	private String nameMenu;
	private String paymentMethod;

	@ManyToOne
	@JoinColumn(name = "idSalon", referencedColumnName = "idSalon")
	@JsonBackReference
	private Salon salon;

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNameMenu() {
		return nameMenu;
	}

	public void setNameMenu(String nameMenu) {
		this.nameMenu = nameMenu;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public Menu(int price, String nameMenu, String paymentMethod) {
		super();
		this.price = price;
		this.nameMenu = nameMenu;
		this.paymentMethod = paymentMethod;
	}

	public Menu() {
		super();
	}

}
