package pages.US04Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OpenSourcePage {

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

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/div[2]/div/a")
    public WebElement addButton;

    @FindBy(xpath = "//*[@id='shipping_first_name']")
    public WebElement firstNameTextbox;

    @FindBy(xpath = "//*[@id='shipping_last_name']")
    public WebElement lastNameTextbox;

    @FindBy(xpath = "//select[@id='shipping_country']")
    public WebElement country;

    @FindBy(xpath = "//input[@id='shipping_company']")
    public WebElement companyName;

    @FindBy(xpath = "//*[@id='shipping_address_1']")
    public WebElement streetAddress;

    @FindBy(xpath = "//*[@id='shipping_city']")
    public WebElement townCity;

    @FindBy(xpath = "//select[@id='shipping_state']")
    public WebElement state;

    @FindBy(xpath = "//*[@id=\"shipping_postcode\"]")
    public WebElement postCode;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/form/div/p/button")
    public WebElement shippingSubmit;

}
