package com.assignment.engine.cart.controller;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.engine.cart.request.AddLineItemInfo;
import com.assignment.engine.cart.response.Cart;
import com.assignment.engine.cart.response.LineItem;
import com.assignment.engine.cart.service.LineItemService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class LineItemController {

	@Autowired
	private LineItemService lineItemService;

	@PostMapping(value = "/carts/add/items", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Adds an item to a cart.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error") })
	public Cart addItemsToCart(@RequestBody List<AddLineItemInfo> addItemInfos) {
		List<LineItem> items = lineItemService.addItemsToCart(UUID.randomUUID().toString(), addItemInfos);

		return getCart(items);
	}

	Cart getCart(List<LineItem> items) {

		if (!items.isEmpty()) {
			Cart cart = new Cart();

			double cartTotal = 0.0d;

			Iterator<LineItem> iterator = items.iterator();
			while (iterator.hasNext()) {
				LineItem lineItem = (LineItem) iterator.next();
				if (null != lineItem.getPrice()) {
					cartTotal += lineItem.getPrice().getTotalPrice();
				}
			}

			cart.setCartTotal(cartTotal);
			cart.setLineItems(items);

			return cart;
		}
		return null;

	}
}
