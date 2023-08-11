package pages.US03Page;

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

    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@class='woocommerce-button button woocommerce-form-login__submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//a[text()='Addresses']")
    public WebElement adresses;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/div[1]/div/a")
    public WebElement addButton;

    @FindBy(xpath = "//*[@id='billing_first_name']")
    public WebElement firstNameTextbox;

    @FindBy(xpath = "//*[@id='billing_last_name']")
    public WebElement lastNameTextbox;

    @FindBy(xpath = "//*[@id=\"billing_country_field\"]/span/span/span[1]/span")
    public WebElement country;

    @FindBy(xpath = "//span[text()='Turkey']")
    public WebElement turkey;

    @FindBy(xpath = "//input[@id='billing_company']")
    public WebElement companyName;

    @FindBy(xpath = "//*[@id='billing_address_1']")
    public WebElement streetAddress;

    @FindBy(xpath = "//*[@id='billing_city']")
    public WebElement townCity;

    @FindBy(xpath = "//*[@id=\"billing_state_field\"]/span/span/span[1]/span")
    public WebElement state;

    @FindBy(xpath = "//*[@id=\"billing_postcode\"]")
    public WebElement postCode;

    @FindBy(xpath = "//*[@id=\"billing_phone\"]")
    public WebElement phoneNumber;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/form/div/p/button")
    public WebElement myAccountSubmit;


}
