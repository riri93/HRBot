package com.example.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HairSalon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idHairSaloon;
	private String name;
	private String zone;

	public int getIdHairSaloon() {
		return idHairSaloon;
	}

	public void setIdHairSaloon(int idHairSaloon) {
		this.idHairSaloon = idHairSaloon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public HairSalon(String name, String zone) {
		super();
		this.name = name;
		this.zone = zone;
	}

	public HairSalon() {
		super();
	}
	
	

}
