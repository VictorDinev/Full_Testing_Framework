package stepDefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import utils.UI.Config;
import utils.UI.DriverManager;


public class MainPageSteps {

    WebDriver driver = DriverManager.getDriver();
    MainPage mainPage = new MainPage(driver);


    @Given("User opens the main page")
    public void navigateToMainPage() {
        driver.get(Config.BASE_URL);
    }

    @When("User selects car category search")
    public void selectCarCategory() {

        Config.jsWaitForTwoSec();
        Config.waitToBeClickable(mainPage.TypeOfVehicleBtn);
        mainPage.clickTypeVehicle();
        Config.jsWaitForTwoSec();
        Config.waitToBeClickable(mainPage.carBtn);
        mainPage.clickCarBtn();
        Config.waitToBeClickable(mainPage.doneBtn);
        mainPage.clickDone();
    }

    @When("User selects the type of chassis")
    public void selectChassis() {

        Config.waitAndClickBtn(mainPage.chassisTypeBtn);
        Config.jsWaitForTwoSec();
        Config.waitAndClickBtn(mainPage.sedanBtn);
        Config.waitAndClickBtn(mainPage.doneBtn);

    }

    @Then("User should be redirected to the dashboard")
    public void userRedirected() {
    }

}
