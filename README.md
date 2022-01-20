# promo-engine

#curl 
curl --location --request POST 'http://localhost:8080/carts/add/items' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "quantity": 3,
        "sku": "A"
    },
    {
        "quantity": 5,
        "sku": "B"
    },
    {
        "quantity": 1,
        "sku": "C"
    },
    {
        "quantity": 1,
        "sku": "D"
    }
]'

Response - 
{
    "id": "6e1bd840-c1c7-475a-9622-24a329720f37",
    "cartTotal": 280.0,
    "lineItems": [
        {
            "lineId": "fcda6cbb-bcf4-4921-9e6e-9d987fffbaa2",
            "displayName": "A",
            "quantity": 3,
            "sku": "A",
            "price": {
                "itemPrice": 50.0,
                "salePrice": 50.0,
                "discountPrice": null,
                "totalPrice": 130.0,
                "discounts": [
                    {
                        "name": "buy_3_sku_a_get_130.0",
                        "code": "buy_3_sku_a_get_130.0",
                        "discountAmount": 130.0
                    }
                ],
                "priceAdjustment": null
            },
            "productId": null
        },
        {
            "lineId": "db10710d-d10a-40f8-a6f3-c2a8d20bb549",
            "displayName": "B",
            "quantity": 5,
            "sku": "B",
            "price": {
                "itemPrice": 30.0,
                "salePrice": 30.0,
                "discountPrice": null,
                "totalPrice": 120.0,
                "discounts": [
                    {
                        "name": "buy_2_sku_b_get_45.0",
                        "code": "buy_2_sku_b_get_45.0",
                        "discountAmount": 120.0
                    }
                ],
                "priceAdjustment": null
            },
            "productId": null
        },
        {
            "lineId": "c616c01f-9066-4db7-8e35-5ca7923dc8de",
            "displayName": "C",
            "quantity": 1,
            "sku": "C",
            "price": {
                "itemPrice": 20.0,
                "salePrice": 20.0,
                "discountPrice": null,
                "totalPrice": 0.0,
                "discounts": [
                    {
                        "name": "buy_1_sku_c_get_30.0",
                        "code": "buy_1_sku_c_get_30.0",
                        "discountAmount": 30.0
                    }
                ],
                "priceAdjustment": null
            },
            "productId": null
        },
        {
            "lineId": "4e45846b-7cf7-41b2-8256-8c324c14a2b5",
            "displayName": "D",
            "quantity": 1,
            "sku": "D",
            "price": {
                "itemPrice": 15.0,
                "salePrice": 15.0,
                "discountPrice": null,
                "totalPrice": 30.0,
                "discounts": [
                    {
                        "name": "buy_1_sku_d_get_30.0",
                        "code": "buy_1_sku_d_get_30.0",
                        "discountAmount": 30.0
                    }
                ],
                "priceAdjustment": null
            },
            "productId": null
        }
    ]
}
