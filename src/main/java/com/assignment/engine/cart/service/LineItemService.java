package com.assignment.engine.cart.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.assignment.engine.cart.request.AddLineItemInfo;
import com.assignment.engine.cart.response.LineItem;
import com.assignment.engine.cart.response.LineItemDiscount;
import com.assignment.engine.cart.response.LineItemPrice;

@Service
public class LineItemService {
	
	@Autowired
	private PromotionService promotionService;
	
	Set<String> skus = Set.of("A", "B", "C" , "D");
	
	public List<LineItem> addItemsToCart(String cartId, List<AddLineItemInfo> addItemInfos) {
		if (addItemInfos.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no items are found", null);
		}
		
		boolean combinedSku = hasCombinedSku(addItemInfos);
		List<LineItem> itemInfos = new ArrayList<>();
		
		Iterator<AddLineItemInfo> iterator = addItemInfos.iterator();
		while (iterator.hasNext()) {
			AddLineItemInfo addLineItemInfo = (AddLineItemInfo) iterator.next();
			if(null != addLineItemInfo) {
				itemInfos.add(addLineItem(addLineItemInfo,combinedSku));
			}
		}
		
		return itemInfos;
	}
	
	private boolean hasCombinedSku(List<AddLineItemInfo> addItemInfos) {
		
		Iterator<AddLineItemInfo> iterator = addItemInfos.iterator();
		boolean isC = false;
		boolean isD = false;
		while (iterator.hasNext()) {
			AddLineItemInfo addLineItemInfo = (AddLineItemInfo) iterator.next();
			if(null != addLineItemInfo) {
				String sku = addLineItemInfo.getSku();
				if(sku.equals("C")) {
					isC = true;
				}else if(sku.equals("D")) {
					isD = true;
				}
			}
		}
		
		return isC && isD;
		
	}

	private LineItem addLineItem(AddLineItemInfo addLineItemInfo, boolean isCombinedSku) {
		
		int qty = addLineItemInfo.getQuantity();
		String skuId = addLineItemInfo.getSku();
		
		System.out.println("skuId is being added " + skuId + "with quantity " + qty);	
		
		if (qty < 1) {
			String message = "Invalid qty being passed for skuId" + skuId;
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message, null);
		}

		if(!skus.contains(skuId)) {
			String message = "Invalid sku is being passed with Id " + skuId;
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message, null);
		}
		
		LineItem lItem = new LineItem();
		lItem.setLineId(UUID.randomUUID().toString());
		lItem.setSku(skuId.toUpperCase());
		lItem.setProductId(addLineItemInfo.getProductId());
		lItem.setQuantity(qty);
		lItem.setDisplayName(skuId);
		lItem.setPrice(getLineItemPrice(skuId,qty,isCombinedSku));

		return lItem;
	}

	private LineItemPrice getLineItemPrice(String skuId, int qty,boolean isCombinedSku) {
		double price = getRegularItemPrice(skuId);
		if (price < 0.0d) {

		}

		LineItemPrice itemPrice = new LineItemPrice();
		itemPrice.setItemPrice(price);
		itemPrice.setSalePrice(price);

		LineItemDiscount itemDisc = promotionService.calculateDiscount(skuId, qty, price,isCombinedSku);
		if (null != itemDisc) {
			List<LineItemDiscount> lItemDislist = new ArrayList<>();
			lItemDislist.add(itemDisc);
			itemPrice.setDiscounts(lItemDislist);
		}

		if (null != itemDisc && itemDisc.getDiscountAmount() > 0.0d) {
			if (isCombinedSku && "C".equals(skuId)) {
				itemPrice.setTotalPrice(0.0d);
			} else {
				itemPrice.setTotalPrice(itemDisc.getDiscountAmount());
			}
		} else {
			itemPrice.setTotalPrice(qty * price);
		}

		return itemPrice;
	}
	
	private double getRegularItemPrice(String skuId) {
		switch (skuId) {
		case "A":
			return 50d;
		case "B":
			return 30d;
		case "C":
			return 20d;
		case "D":
			return 15d;
		default:
			break;
		}
		return 0.0d;
	}
	
}
