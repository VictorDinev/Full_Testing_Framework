package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.API.APIConfig;
import utils.API.SWAPIVerificationData;
import utils.API.Ship;

public class APITestSWAPI {

    @Test(dataProvider = "starshipDataProvider", dataProviderClass = SWAPIVerificationData.class)
    public void getShip(Ship expectedShip) {

        int shipID;
        String shipName = expectedShip.getName();

        switch (shipName){
            case "Star Destroyer":
                shipID = 3;
                break;
            case "Death Star":
                shipID = 9;
                break;
            default:
                throw new IllegalArgumentException("Unexpected ship " + expectedShip.getName());
        }

        Response response = RestAssured.given().baseUri(APIConfig.getSWAPIBaseURL()).
                basePath(APIConfig.getShipById(shipID))
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().response();

        // Convert response body to JSON object
        JSONObject jsonObject = new JSONObject(response.getBody().asString());

        //Use builder pattern to create object for the response
        Ship actualShip = new Ship.ShipsBuilder()
                .setName(jsonObject.getString("name"))
                .setCrew(jsonObject.getString("crew"))
                .setPilots(jsonObject.getJSONArray("pilots").toList())
                .setFilms(jsonObject.getJSONArray("films").toList())
                .build();

        System.out.println(jsonObject.getJSONArray("pilots").toList());

        String string = response.asPrettyString();
        System.out.println(string);

        Assert.assertEquals(actualShip.getName(), expectedShip.getName(), "Name doesn't match!");
        Assert.assertEquals(actualShip.getCrew(), expectedShip.getCrew(), "Crew number is not the expected number!");
        Assert.assertEquals(actualShip.getFilms(), expectedShip.getFilms(), "Crew number is not the expected number!");

        System.out.println(actualShip.getFilms());

    }


}
