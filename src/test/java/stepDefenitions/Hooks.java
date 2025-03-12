package stepDefenitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utils.UI.DriverManager;

public class Hooks {

    @BeforeAll
    public static void setUpSuite(){
        System.out.printf("Initializing WebDriver before all tests");
        DriverManager.getDriver();
    }

    @AfterAll
    public static void tearDownSuite(){
        System.out.printf("Closing WebDriver after all tests");
        DriverManager.quitDriver();
    }

}
