package utils.API;

public class DummyJsonAPITestData {





    private static final String CartResponseBody = "{\n" +
            "    \"id\": 1,\n" +
            "    \"products\": [\n" +
            "        {\n" +
            "            \"id\": 168,\n" +
            "            \"title\": \"Charger SXT RWD\",\n" +
            "            \"price\": 32999.99,\n" +
            "            \"quantity\": 3,\n" +
            "            \"total\": 98999.97,\n" +
            "            \"discountPercentage\": 13.39,\n" +
            "            \"discountedTotal\": 85743.87,\n" +
            "            \"thumbnail\": \"https://cdn.dummyjson.com/products/images/vehicle/Charger%20SXT%20RWD/thumbnail.png\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 78,\n" +
            "            \"title\": \"Apple MacBook Pro 14 Inch Space Grey\",\n" +
            "            \"price\": 1999.99,\n" +
            "            \"quantity\": 2,\n" +
            "            \"total\": 3999.98,\n" +
            "            \"discountPercentage\": 18.52,\n" +
            "            \"discountedTotal\": 3259.18,\n" +
            "            \"thumbnail\": \"https://cdn.dummyjson.com/products/images/laptops/Apple%20MacBook%20Pro%2014%20Inch%20Space%20Grey/thumbnail.png\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 183,\n" +
            "            \"title\": \"Green Oval Earring\",\n" +
            "            \"price\": 24.99,\n" +
            "            \"quantity\": 5,\n" +
            "            \"total\": 124.94999999999999,\n" +
            "            \"discountPercentage\": 6.28,\n" +
            "            \"discountedTotal\": 117.1,\n" +
            "            \"thumbnail\": \"https://cdn.dummyjson.com/products/images/womens-jewellery/Green%20Oval%20Earring/thumbnail.png\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 100,\n" +
            "            \"title\": \"Apple Airpods\",\n" +
            "            \"price\": 129.99,\n" +
            "            \"quantity\": 5,\n" +
            "            \"total\": 649.95,\n" +
            "            \"discountPercentage\": 12.84,\n" +
            "            \"discountedTotal\": 566.5,\n" +
            "            \"thumbnail\": \"https://cdn.dummyjson.com/products/images/mobile-accessories/Apple%20Airpods/thumbnail.png\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"total\": 103774.85,\n" +
            "    \"discountedTotal\": 89686.65,\n" +
            "    \"userId\": 33,\n" +
            "    \"totalProducts\": 4,\n" +
            "    \"totalQuantity\": 15\n" +
            "}";

    //declaring a method that will return and object representing CartResponseBody
    public static Object[][] getCartOneBody() {
        return new Object[][]{
                {CartResponseBody}
        };
    }
}
