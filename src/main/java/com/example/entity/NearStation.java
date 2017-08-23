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
public class NearStation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idStation;
	private String type;
	private String nameStation;
	private String distance;

	@ManyToOne
	@JoinColumn(name = "idSalon", referencedColumnName = "idSalon")
	@JsonBackReference
	private Salon salon;

	public int getIdStation() {
		return idStation;
	}

	public void setIdStation(int idStation) {
		this.idStation = idStation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNameStation() {
		return nameStation;
	}

	public void setNameStation(String nameStation) {
		this.nameStation = nameStation;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public NearStation(String type, String nameStation, String distance) {
		super();
		this.type = type;
		this.nameStation = nameStation;
		this.distance = distance;
	}

	public NearStation() {
		super();
	}

}
