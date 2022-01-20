package com.assignment.engine.cart.response;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
	private String id = UUID.randomUUID().toString();
	private double cartTotal;
	private List<LineItem> lineItems = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", lineItems=" + lineItems + ", cartTotal=" + cartTotal + "]";
	}

	

}
