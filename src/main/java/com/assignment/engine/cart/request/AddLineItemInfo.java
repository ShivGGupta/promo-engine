package com.assignment.engine.cart.request;

public class AddLineItemInfo {
	private String sku;
	private String productId;
	private int quantity;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "AddLineItemInfo [sku=" + sku + ", productId=" + productId + ", quantity=" + quantity + "]";
	}

}
