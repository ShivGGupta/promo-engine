package com.assignment.engine.cart.response;

public class LineItemDiscount {
	private String name;
	private String code;
	private Double discountAmount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Override
	public String toString() {
		return "LineItemDiscount [name=" + name + ", code=" + code + ", discountAmount=" + discountAmount + "]";
	}

}
