package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.API.APIConfig;

import java.rmi.UnexpectedException;

public class APIUserVerification {

    private static String authToken;

    @DataProvider(name = "userCredentials")
    public Object[][] getUserCredentials(){
        return APIConfig.getCredsAsData();
    }

    @BeforeClass
    public void getAuthToken(){

       Response response = RestAssured.given().baseUri(APIConfig.getAPIBaseURL())
                .basePath(APIConfig.getAuthLoginURI())
                .header("Content-Type", "application/json")
                .body(APIConfig.getUserCredentials())
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        authToken = jsonObject.getString("accessToken");

        System.out.println("Authentication token " + authToken);

    }

    @Test
    public void getCurentUser(){

        Response response = RestAssured.given().baseUri(APIConfig.getAPIBaseURL())
                .basePath("auth/me")
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().response();

        JSONObject jsonObject = new JSONObject(response.getBody().asString());

        Assert.assertEquals(jsonObject.getString("firstName"), "Emily", "first name doesn't mach");
        Assert.assertEquals(jsonObject.getString("lastName"), "Johnson", "lastName name doesn't mach");

        System.out.println(response.asPrettyString());
    }

    @Test(dataProvider = "userCredentials")
    public void testCredentials(String credentials){

        Response response = RestAssured.given().baseUri(APIConfig.getAPIBaseURL())
                .basePath(APIConfig.getAuthLoginURI())
                .header("Content-type", "application/json")
                .body(credentials)
                .when()
                .post()
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();

        switch (statusCode){
            case 200:
                JSONObject jsonObject = new JSONObject(response.getBody().asPrettyString());
                System.out.println(jsonObject);
                break;
            case 400:
                Assert.assertEquals(statusCode, 400, "Status code is not expected " + statusCode);
                break;
            default:
                throw new IllegalArgumentException("Unexpected status code " + statusCode);
        }
    }

}
