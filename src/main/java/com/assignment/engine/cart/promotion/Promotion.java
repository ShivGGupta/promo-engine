package com.assignment.engine.cart.promotion;

import java.util.Map;
import java.util.UUID;

public class Promotion {
	private String id = UUID.randomUUID().toString();
	private String promoType;
	private Map<String, Integer> details;
	private Double amount;
	private boolean redeemed;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPromoType() {
		return promoType;
	}

	public void setPromoType(String promoType) {
		this.promoType = promoType;
	}

	public Map<String, Integer> getDetails() {
		return details;
	}

	public void setDetails(Map<String, Integer> details) {
		this.details = details;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	

	public boolean isRedeemed() {
		return redeemed;
	}

	public void setRedeemed(boolean redeemed) {
		this.redeemed = redeemed;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", promoType=" + promoType + ", details=" + details + ", amount=" + amount
				+ "]";
	}
	
	

}
