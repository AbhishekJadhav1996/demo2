package com.cybage.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "promocode")
public class Promocode {
	
	@Id
	private int promocodeId;
	@Column
	private String promoName;
	@Column
	private double discount;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookingId")
    private Booking booking;
	
	@OneToOne(mappedBy = "booking")
    private Promocode promocode;
	
	
	public Promocode() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Promocode(int promocodeId, String promoName, double discount) {
		super();
		this.promocodeId = promocodeId;
		this.promoName = promoName;
		this.discount = discount;
	}



	public int getPromocodeId() {
		return promocodeId;
	}

	public void setPromocodeId(int promocodeId) {
		this.promocodeId = promocodeId;
	}

	public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}



	@Override
	public String toString() {
		return "Promocode [promocodeId=" + promocodeId + ", promoName=" + promoName + ", discount=" + discount + "]";
	}
	
	
	
}
