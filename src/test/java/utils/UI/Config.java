package utils.UI;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Config {

    public static final String BASE_URL = "https://www.cars.bg/";
    private static final WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    private static final JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();



    public static void waitToBeClickable(WebElement webElement) {

        WebElement waitedElement = wait.until(ExpectedConditions.elementToBeClickable(webElement ));
    }

    public static void waitAndClickBtn(WebElement webElement){

        WebElement waitedElement = wait.until(ExpectedConditions.elementToBeClickable(webElement ));
        webElement.click();
    }

    public static void jsWaitForTwoSec(){
        js.executeScript("setTimeout(arguments[arguments.length -1], 10000);");

    }
}
