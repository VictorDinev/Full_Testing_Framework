package utils.API;

public class APIConfig {

    private static final String dummyJSONURL = "https://dummyjson.com/";
    private static final String SWAPIBaseURL = "https://swapi.dev/api/";
    private static final String PETSBaseURL = "https://petstore3.swagger.io/api/v3/";


    private static final String userCredentials = """
             {
               "username": "emilys",
               "password": "emilyspass",
               "expiresInMins": 30
             }
            """;
    private static final String wrongUserCredentials = """
             {
               "username": "emi",
               "password": "emilyspass",
               "expiresInMins": 30
             }
            """;

    private static final String petBody = """
            {
              "id": 10,
              "name": "doggie",
              "category": {
                "id": 1,
                "name": "Dogs"
              },
              "photoUrls": [
                "string"
              ],
              "tags": [
                {
                  "id": 0,
                  "name": "string"
                }
              ],
              "status": "available"
            }
            """;

    private static final String updatedPetBody = """
            {
              "id": 12,
              "name": "Snoop Dogy",
              "category": {
                "id": 1,
                "name": "Dogs"
              },
              "photoUrls": [
                "string"
              ],
              "tags": [
                {
                  "id": 0,
                  "name": "string"
                }
              ],
              "status": "available"
            }
            """;



    public static String getUserCredentials() {
        return userCredentials;
    }

    public static Object[][] getCredsAsData() {
        return new Object[][]{
                {userCredentials},
                {wrongUserCredentials}
        };
    }

    public static Object[][] addPetDataProvider(){
        return new Object[][]{
                {petBody}
        };
    }

    public static Object[][] updatedPetBody(){
        return new Object[][]{
                {updatedPetBody}
        };
    }

    public static String getAPIBaseURL() {
        return dummyJSONURL;
    }

    public static String getAuthLoginURI() {
        return "auth/login";
    }

    public static String getCartByUserID(int userID) {
        return "carts/user/" + userID;
    }

    public static String getCartByID(int cartID) {
        return "carts/" + cartID;
    }

    public static String addCart() {
        return "carts/add";
    }

    public static String getSWAPIBaseURL() {
        return SWAPIBaseURL;
    }

    public static String getShipById(int shipID) {
        return "starships/" + shipID + "/";
    }

    public static String getPETSBaseURL(){
        return PETSBaseURL;
    }

    public static String addPetURI() {
        return "pet";
    }

    public static String updatePetURI() {
        return "pet";
    }

    public static String deletePetByIDURI(int petID) {
        return "pet/" + petID;
    }

    public static String getPetByIDURI(int petID) {
        return "pet/" + petID;
    }

}
