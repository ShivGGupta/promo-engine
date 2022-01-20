package com.assignment.engine.cart.response;

import java.util.List;

public class LineItemPrice {
	private Double itemPrice;
	private Double salePrice;
	private Double discountPrice;
	private Double totalPrice;
	private List<LineItemDiscount> discounts;
	private PriceAdjustment priceAdjustment;

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<LineItemDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<LineItemDiscount> discounts) {
		this.discounts = discounts;
	}

	public PriceAdjustment getPriceAdjustment() {
		return priceAdjustment;
	}

	public void setPriceAdjustment(PriceAdjustment priceAdjustment) {
		this.priceAdjustment = priceAdjustment;
	}

	@Override
	public String toString() {
		return "LineItemPrice [itemPrice=" + itemPrice + ", salePrice=" + salePrice + ", discountPrice=" + discountPrice
				+ ", totalPrice=" + totalPrice + ", discounts=" + discounts + ", priceAdjustment=" + priceAdjustment
				+ "]";
	}

}
