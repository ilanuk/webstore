package com.packt.webstore.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ShippingDetail implements Serializable {

	private static final long serialVersionUID = 6350930334140807514L;

	private String name;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date shippingDate;
	private Address shippingAddress;

	public ShippingDetail() {
		this.shippingAddress = new Address();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((shippingAddress == null) ? 0 : shippingAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ShippingDetail)) {
			return false;
		}
		ShippingDetail other = (ShippingDetail) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (shippingAddress == null) {
			if (other.shippingAddress != null) {
				return false;
			}
		} else if (!shippingAddress.equals(other.shippingAddress)) {
			return false;
		}
		return true;
	}

	
}
