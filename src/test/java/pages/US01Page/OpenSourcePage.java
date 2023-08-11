package pages.US01Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OpenSourcePage {

    private WebDriver driver;

    public OpenSourcePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Register']")
    public WebElement register;

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement registerUsername;

    @FindBy(xpath = "//input[@id='reg_email']")
    public WebElement registeremail;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement registerpassword;

    @FindBy(xpath = "//input[@id='register-policy']")
    public WebElement Iagreetotheprivacypolicy;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement submit;



}