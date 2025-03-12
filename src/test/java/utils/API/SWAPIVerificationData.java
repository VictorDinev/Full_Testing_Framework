package utils.API;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class SWAPIVerificationData {


    private static Ship createStarship(JSONObject starshipJson) {

        return new Ship.ShipsBuilder()
                .setName(starshipJson.getString("name"))
                .setModel(starshipJson.getString("model"))
                .setManufacturer(starshipJson.getString("manufacturer"))
                .setCostInCredits(starshipJson.getString("cost_in_credits"))
                .setLength(starshipJson.getString("length"))
                .setMaxAtmospheringSpeed(starshipJson.getString("max_atmosphering_speed"))
                .setCrew(starshipJson.getString("crew"))
                .setPassengers(starshipJson.getString("passengers"))
                .setCargoCapacity(starshipJson.getString("cargo_capacity"))
                .setConsumables(starshipJson.getString("consumables"))
                .setHyperdriveRating(starshipJson.getString("hyperdrive_rating"))
                .setMGLT(starshipJson.getString("MGLT"))
                .setStarshipClass(starshipJson.getString("starship_class"))
                .setPilots(jsonArrayToList(starshipJson.getJSONArray("pilots")))
                .setFilms(jsonArrayToList(starshipJson.getJSONArray("films")))
                .build();

    }

    private static List<String> jsonArrayToList(JSONArray jsonArray) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getString(i));
        }
        return list;
    }

    @DataProvider(name = "starshipDataProvider")
    public static Object[][] starshipDataProvider() {
        return new Object[][]{
                {getStarDestroyerJson()},
                {getDeathStarResponse()}
        };
    }

    private static Ship getStarDestroyerJson() {

        String jsonResponseStarDestroyer = """
                {
                    "name": "Star Destroyer",
                    "model": "Imperial I-class Star Destroyer",
                    "manufacturer": "Kuat Drive Yards",
                    "cost_in_credits": "150000000",
                    "length": "1,600",
                    "max_atmosphering_speed": "975",
                    "crew": "47,060",
                    "passengers": "n/a",
                    "cargo_capacity": "36000000",
                    "consumables": "2 years",
                    "hyperdrive_rating": "2.0",
                    "MGLT": "60",
                    "starship_class": "Star Destroyer",
                    "pilots": [],
                    "films": [
                        "https://swapi.dev/api/films/1/",
                        "https://swapi.dev/api/films/2/",
                        "https://swapi.dev/api/films/3/"
                    ]
                }
                """;

        JSONObject jsonObject = new JSONObject(jsonResponseStarDestroyer);
        return createStarship(jsonObject);
    }

    private static Ship getDeathStarResponse() {
        String jsonResponseDeathStar = """
                {
                	"name": "Death Star",
                	"model": "DS-1 Orbital Battle Station",
                	"manufacturer": "Imperial Department of Military Research, Sienar Fleet Systems",
                	"cost_in_credits": "1000000000000",
                	"length": "120000",
                	"max_atmosphering_speed": "n/a",
                	"crew": "342,953",
                	"passengers": "843,342",
                	"cargo_capacity": "1000000000000",
                	"consumables": "3 years",
                	"hyperdrive_rating": "4.0",
                	"MGLT": "10",
                	"starship_class": "Deep Space Mobile Battlestation",
                	"pilots": [],
                	"films": [
                		"https://swapi.dev/api/films/1/"
                	],
                	"created": "2014-12-10T16:36:50.509000Z",
                	"edited": "2014-12-20T21:26:24.783000Z",
                	"url": "https://swapi.dev/api/starships/9/"
                }
                """;
        JSONObject jsonObject = new JSONObject(jsonResponseDeathStar);
        return createStarship(jsonObject);
    }
}
