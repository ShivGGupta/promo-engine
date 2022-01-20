package com.assignment.engine.cart.response;

public class PriceAdjustment {
	private Double adjustment;
	private String adjustmentType;
	private Double adjustmentAmount;
	private Double priceBeforeAdjustment;

	public Double getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(Double adjustment) {
		this.adjustment = adjustment;
	}

	public String getAdjustmentType() {
		return adjustmentType;
	}

	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public Double getAdjustmentAmount() {
		return adjustmentAmount;
	}

	public void setAdjustmentAmount(Double adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}

	public Double getPriceBeforeAdjustment() {
		return priceBeforeAdjustment;
	}

	public void setPriceBeforeAdjustment(Double priceBeforeAdjustment) {
		this.priceBeforeAdjustment = priceBeforeAdjustment;
	}

	@Override
	public String toString() {
		return "PriceAdjustment [adjustment=" + adjustment + ", adjustmentType=" + adjustmentType
				+ ", adjustmentAmount=" + adjustmentAmount + ", priceBeforeAdjustment=" + priceBeforeAdjustment + "]";
	}

}
