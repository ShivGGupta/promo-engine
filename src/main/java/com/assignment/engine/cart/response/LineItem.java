package com.assignment.engine.cart.response;

public class LineItem {
	private String lineId;
	private String displayName;
	private Integer quantity;
	private String sku;
	private LineItemPrice price;
	private String productId;

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public LineItemPrice getPrice() {
		return price;
	}

	public void setPrice(LineItemPrice price) {
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "LineItem [lineId=" + lineId + ", displayName=" + displayName + ", quantity=" + quantity + ", sku=" + sku
				+ ", price=" + price + ", productId=" + productId + "]";
	}

}
