package com.assignment.engine.cart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.assignment.engine.cart.promotion.Promotion;
import com.assignment.engine.cart.response.LineItemDiscount;

@Component
public class PromotionService {

	public LineItemDiscount calculateDiscount(String sku, Integer skuQty, double unitPrice,boolean isCombinedSku) {
		Promotion p = determinePromotionForItem(sku,isCombinedSku);
		if (p != null) {
			if(isCombinedSku && "C".equals(sku) || "D".equals(sku)) {
				int thrQty = p.getDetails().get("C_D");
				if (skuQty >= thrQty) {
					return calculate(p, sku, thrQty, skuQty, unitPrice,isCombinedSku);
				}
			}else {
				int thrQty = p.getDetails().get(sku);
				if (skuQty >= thrQty) {
					return calculate(p, sku, thrQty, skuQty, unitPrice,isCombinedSku);
				}
			}
			
		}

		return null;
	}
	
	private LineItemDiscount calculate(Promotion p, String sku, int thrQty, Integer skuQty,double unitPrice, boolean isCombinedSku) {
		System.out.println("sku " + sku + " thrQty " + thrQty + " skuQty " + skuQty );
		int discountNo = skuQty / thrQty;
		int reminder = skuQty % thrQty;
		System.out.println("discountNo " + discountNo + " reminder " + reminder);
		
		double discountPrice = discountNo * p.getAmount() + reminder * unitPrice;
		
		LineItemDiscount discount = new LineItemDiscount();
		discount.setCode("buy_"+thrQty+"_sku_"+sku.toLowerCase()+"_get_"+p.getAmount());
		discount.setName("buy_"+thrQty+"_sku_"+sku.toLowerCase()+"_get_"+p.getAmount());
		discount.setDiscountAmount(discountPrice);
		
		if(isCombinedSku && ("C".equals(sku) || "D".equals(sku))) {
			p.setRedeemed(true);
		}
		
		return discount;
	}

	public Promotion determinePromotionForItem(String skuId,boolean isCombinedSku){
		List<Promotion> activePromoList = getActivePromotions();
		if(!activePromoList.isEmpty() && !isItemHasAlreadyPromotionApplied()) {
			return getQualiyingPromo(activePromoList,skuId,isCombinedSku);
		}
		return null;
	}
	
	private Promotion getQualiyingPromo(List<Promotion> activePromoList,String sku,boolean isCombinedSku) {
		if(isCombinedSku && "C".equals(sku) || "D".equals(sku)) {
			sku = "C_D";
		}
		
		Iterator<Promotion> iterator = activePromoList.iterator();
		while (iterator.hasNext()) {
			Promotion promotion = (Promotion) iterator.next();
			if(null != promotion.getDetails().get(sku)) {
				return promotion;
			}
			
		}
		
		return null;
	}

	public boolean isItemHasAlreadyPromotionApplied() {
		return false;
	}
	
	public List<Promotion> getActivePromotions() {
		List<Promotion> pList = new ArrayList<>();
		pList.add(cretaePromotion("amountOff", 130, "A", 3));
		pList.add(cretaePromotion("amountOff", 45, "B", 2));
		pList.add(cretaePromotion("amountOff", 30, "C_D", 1));
		return pList;

	}

	public Promotion cretaePromotion(String type, double value, String skuId, Integer qty) {
		Promotion promotion = new Promotion();
		promotion.setPromoType(getPromotionType(type));
		Map<String, Integer> promoMap = new HashMap<>();
		promoMap.put(skuId, qty);
		promotion.setDetails(promoMap);
		promotion.setAmount(value);
		return promotion;

	}

	public String getPromotionType(String type) {

		switch (type) {
		case "amountOff":
			return "AMOUNT_OFF";

		default:
			break;
		}

		return "NONE";

	}
}
