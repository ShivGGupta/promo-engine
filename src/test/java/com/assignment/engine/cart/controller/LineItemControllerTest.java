package com.assignment.engine.cart.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.engine.cart.request.AddLineItemInfo;
import com.assignment.engine.cart.response.Cart;
import com.assignment.engine.cart.response.LineItem;
import com.assignment.engine.cart.service.LineItemService;
import com.google.gson.Gson;

public class LineItemControllerTest {
	@Autowired
	private LineItemController lineItemController;
	@Mock
	private LineItemService mockItemService;

	@Test
	public void test_1() throws Exception {
		
		List<AddLineItemInfo> itemList = new ArrayList<>();
		AddLineItemInfo item1 = new AddLineItemInfo();
		item1.setSku("A");
		item1.setQuantity(3);
		itemList.add(item1);
		
		AddLineItemInfo item2 = new AddLineItemInfo();
		item1.setSku("B");
		item1.setQuantity(5);
		itemList.add(item2);
		
		AddLineItemInfo item3 = new AddLineItemInfo();
		item1.setSku("C");
		item1.setQuantity(1);
		itemList.add(item3);
		
		AddLineItemInfo item4 = new AddLineItemInfo();
		item1.setSku("D");
		item1.setQuantity(1);
		itemList.add(item4);
		
		String string = "[\r\n"
				+ "    {\r\n"
				+ "      \"lineId\": \"fcda6cbb-bcf4-4921-9e6e-9d987fffbaa2\",\r\n"
				+ "      \"displayName\": \"A\",\r\n"
				+ "      \"quantity\": 3,\r\n"
				+ "      \"sku\": \"A\",\r\n"
				+ "      \"price\": {\r\n"
				+ "        \"itemPrice\": 50.0,\r\n"
				+ "        \"salePrice\": 50.0,\r\n"
				+ "        \"discountPrice\": null,\r\n"
				+ "        \"totalPrice\": 130.0,\r\n"
				+ "        \"discounts\": [\r\n"
				+ "          {\r\n"
				+ "            \"name\": \"buy_3_sku_a_get_130.0\",\r\n"
				+ "            \"code\": \"buy_3_sku_a_get_130.0\",\r\n"
				+ "            \"discountAmount\": 130.0\r\n"
				+ "          }\r\n"
				+ "        ],\r\n"
				+ "        \"priceAdjustment\": null\r\n"
				+ "      },\r\n"
				+ "      \"productId\": null\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"lineId\": \"db10710d-d10a-40f8-a6f3-c2a8d20bb549\",\r\n"
				+ "      \"displayName\": \"B\",\r\n"
				+ "      \"quantity\": 5,\r\n"
				+ "      \"sku\": \"B\",\r\n"
				+ "      \"price\": {\r\n"
				+ "        \"itemPrice\": 30.0,\r\n"
				+ "        \"salePrice\": 30.0,\r\n"
				+ "        \"discountPrice\": null,\r\n"
				+ "        \"totalPrice\": 120.0,\r\n"
				+ "        \"discounts\": [\r\n"
				+ "          {\r\n"
				+ "            \"name\": \"buy_2_sku_b_get_45.0\",\r\n"
				+ "            \"code\": \"buy_2_sku_b_get_45.0\",\r\n"
				+ "            \"discountAmount\": 120.0\r\n"
				+ "          }\r\n"
				+ "        ],\r\n"
				+ "        \"priceAdjustment\": null\r\n"
				+ "      },\r\n"
				+ "      \"productId\": null\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"lineId\": \"c616c01f-9066-4db7-8e35-5ca7923dc8de\",\r\n"
				+ "      \"displayName\": \"C\",\r\n"
				+ "      \"quantity\": 1,\r\n"
				+ "      \"sku\": \"C\",\r\n"
				+ "      \"price\": {\r\n"
				+ "        \"itemPrice\": 20.0,\r\n"
				+ "        \"salePrice\": 20.0,\r\n"
				+ "        \"discountPrice\": null,\r\n"
				+ "        \"totalPrice\": 0.0,\r\n"
				+ "        \"discounts\": [\r\n"
				+ "          {\r\n"
				+ "            \"name\": \"buy_1_sku_c_get_30.0\",\r\n"
				+ "            \"code\": \"buy_1_sku_c_get_30.0\",\r\n"
				+ "            \"discountAmount\": 30.0\r\n"
				+ "          }\r\n"
				+ "        ],\r\n"
				+ "        \"priceAdjustment\": null\r\n"
				+ "      },\r\n"
				+ "      \"productId\": null\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"lineId\": \"4e45846b-7cf7-41b2-8256-8c324c14a2b5\",\r\n"
				+ "      \"displayName\": \"D\",\r\n"
				+ "      \"quantity\": 1,\r\n"
				+ "      \"sku\": \"D\",\r\n"
				+ "      \"price\": {\r\n"
				+ "        \"itemPrice\": 15.0,\r\n"
				+ "        \"salePrice\": 15.0,\r\n"
				+ "        \"discountPrice\": null,\r\n"
				+ "        \"totalPrice\": 30.0,\r\n"
				+ "        \"discounts\": [\r\n"
				+ "          {\r\n"
				+ "            \"name\": \"buy_1_sku_d_get_30.0\",\r\n"
				+ "            \"code\": \"buy_1_sku_d_get_30.0\",\r\n"
				+ "            \"discountAmount\": 30.0\r\n"
				+ "          }\r\n"
				+ "        ],\r\n"
				+ "        \"priceAdjustment\": null\r\n"
				+ "      },\r\n"
				+ "      \"productId\": null\r\n"
				+ "    }\r\n"
				+ "  ]";
		
		 List<LineItem> data = (List<LineItem>) new Gson().fromJson(string, LineItem.class);
		 
		 when(mockItemService.addItemsToCart(anyString(),anyList())).thenReturn(data);
		 
		 Cart res = lineItemController.addItemsToCart(itemList);
	     assertNotNull(res);
	     assertEquals(280.0, res.getCartTotal());
		
		
	}

}
