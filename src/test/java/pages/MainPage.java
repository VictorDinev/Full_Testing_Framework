package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[@class=\"chip-label text-bold\"]")
    public WebElement TypeOfVehicleBtn;

    @FindBy(xpath = "//a[@class=\"remove-color\"]//label[@for=\"typeoffer_1\"]")
    public WebElement carBtn;

    @FindBy(xpath = "(//button[@class=\"mdc-fab mdc-fab--extended js-sheet-close-submit\"])[1]")
    public WebElement doneBtn;

    @FindBy(xpath = "//div[@sync-data=\"categorySelectSheet\"]//span[text()='Купе']")
    public WebElement chassisTypeBtn;

    @FindBy(xpath = "//label[@for=\"categoryId_1\"]//div[@class=\"mdc-chip mdc-ripple-upgraded\"]")
    public WebElement sedanBtn;

    @FindBy(xpath = "//div[@id=\"typeSelectSheet\"]//div[@role=\"dialog\"]")
    public WebElement typeOverlay;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickTypeVehicle(){
        TypeOfVehicleBtn.click();
    }

    public void clickCarBtn(){
        carBtn.click();
    }

    public void clickDone(){
        doneBtn.click();
    }

    public void clickChassisType(){
        chassisTypeBtn.click();
    }

    public void clickSedanBtn(){
        sedanBtn.click();
    }



}

