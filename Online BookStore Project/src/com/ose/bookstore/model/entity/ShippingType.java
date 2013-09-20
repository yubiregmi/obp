package com.ose.bookstore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ShippingType
 * 
 */
@Entity
public class ShippingType implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	private int shippingId;
	private String type;
	private Double rate;

	public int getShippingId() {
		return shippingId;
	}

	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

}
