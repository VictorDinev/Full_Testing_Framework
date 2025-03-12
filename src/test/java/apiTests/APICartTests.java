package apiTests;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.API.APIConfig;
import org.json.JSONObject;
import utils.API.DummyJsonAPITestData;

public class APICartTests {


    @DataProvider(name = "cartOneData")
    public Object[][] getCartOneData() {
        // Providing the expected JSON string
        return DummyJsonAPITestData.getCartOneBody();
    }

    @Test(dataProvider = "cartOneData")
    public void getSingleCart(String expectedBody) {
        Response response = RestAssured.given().baseUri(APIConfig.getAPIBaseURL())
                .basePath(APIConfig.getCartByID(1))
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();

        String extractedResponse = response.getBody().asString();

        JSONObject jsonObject = new JSONObject(extractedResponse);
        JSONObject responseCart = jsonObject.getJSONArray("products").getJSONObject(0);

        JSONObject expectedCartResponse = new JSONObject(expectedBody);
        JSONObject expectedCart = expectedCartResponse.getJSONArray("products").getJSONObject(0);


        Assert.assertEquals(responseCart.getInt("id"), expectedCart.getInt("id"), "Product ID does not match");
        Assert.assertEquals(responseCart.getString("title"), expectedCart.getString("title"), "Product price does not match");
        Assert.assertEquals(responseCart.getInt("quantity"), expectedCart.getInt("quantity"), "Product quantity does not match");

        String actual = response.jsonPath().prettyPrint();

    }


    @Test(dataProvider = "cartOneData")
    //providing to the test method with data provider above and parameter to the test method
    public void verifyEntireCartOne(String expectedCartResponse) {
        Response response = RestAssured.given().baseUri(APIConfig.getAPIBaseURL())
                .basePath(APIConfig.getCartByID(1))
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().response();

        String actualCartResponse = response.asPrettyString();

        Assert.assertEquals(actualCartResponse.replace("\\s+", ""), expectedCartResponse.replace("\\s+", ""));

    }
}
