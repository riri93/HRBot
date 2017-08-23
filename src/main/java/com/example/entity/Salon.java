package com.example.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Salon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSalon;
	private String nameSalon;
	private String address;
	private String phone;
	private String email;
	private String dayoff;
	private Date openTime;
	private Date closeTime;

	@OneToMany(mappedBy = "salon")
	private List<Client> clients;
	@OneToMany(mappedBy = "salon")
	private List<Menu> menus;
	@OneToMany(mappedBy = "salon")
	private List<NearStation> nearStations;
	@OneToMany(mappedBy = "salon")
	private List<Staff> staffs;
	@OneToMany(mappedBy = "salon")
	private List<Promotion> promotions;

	public int getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(int idSalon) {
		this.idSalon = idSalon;
	}

	public String getNameSalon() {
		return nameSalon;
	}

	public void setNameSalon(String nameSalon) {
		this.nameSalon = nameSalon;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDayoff() {
		return dayoff;
	}

	public void setDayoff(String dayoff) {
		this.dayoff = dayoff;
	}

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<NearStation> getNearStations() {
		return nearStations;
	}

	public void setNearStations(List<NearStation> nearStations) {
		this.nearStations = nearStations;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public Salon(String nameSalon, String address, String phone, String email, String dayoff, Date openTime,
			Date closeTime) {
		super();
		this.nameSalon = nameSalon;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.dayoff = dayoff;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}

	public Salon() {
		super();
	}

	@Override
	public String toString() {
		return "Salon [nameSalon=" + nameSalon + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", dayoff=" + dayoff + ", openTime=" + openTime + ", closeTime=" + closeTime + "]";
	}

}
