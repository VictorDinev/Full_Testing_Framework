package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.API.APIConfig;

public class APITestPets {

    @DataProvider(name = "addPetData")
    public Object[][] addPetData(){
        return APIConfig.addPetDataProvider();
    }

    @DataProvider(name = "updatedPet")
    public Object[][] updatedPetBody(){
        return APIConfig.updatedPetBody();
    }

    @Test(dataProvider = "addPetData")
    public static void addPet(String expectedPet){
     Response response = RestAssured.given()
             .baseUri(APIConfig.getPETSBaseURL())
                .basePath(APIConfig.addPetURI())
                .header("Content-Type", "application/json")
                .body(expectedPet)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        JSONObject jsonObject = new JSONObject(response.getBody().asPrettyString());

        Assert.assertEquals(jsonObject.getString("name"), "doggie");
        Assert.assertEquals(jsonObject.getInt("id"), 10);

        System.out.println(jsonObject);
    }

    @Test(dataProvider = "updatedPet")
    public void updatePet(String updatedPet){

        Response response = RestAssured.given().baseUri(APIConfig.getPETSBaseURL())
                .basePath(APIConfig.updatePetURI())
                .header("Content-type", "application/json")
                .body(updatedPet)
                .when()
                .put()
                .then()
                .statusCode(200)
                .extract().response();

        JSONObject jsonObject = new JSONObject(response.getBody().asPrettyString());

        Assert.assertEquals(jsonObject.getInt("id"), 12);
        Assert.assertEquals(jsonObject.getString("name"), "Snoop Dogy");
    }

    @Test
    public void deletePet(){
        RestAssured.given().baseUri(APIConfig.getPETSBaseURL())
                .basePath(APIConfig.deletePetByIDURI(12))
                .when()
                .delete()
                .then()
                .statusCode(200)
                .extract().response();;

                ggb bc dg


        Response response1 = RestAssured.given().baseUri(APIConfig.getPETSBaseURL())
                .basePath(APIConfig.deletePetByIDURI(12))
                .when()
                .get()
                .then()
                .statusCode(404)
                .extract().response();

        Assert.assertEquals(response1.getStatusCode(), 404);

    }
}
