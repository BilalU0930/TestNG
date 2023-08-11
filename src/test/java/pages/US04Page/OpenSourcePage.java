package pages.US04Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OpenSourcePage {

    public OpenSourcePage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signInFirst;
    @FindBy (id = "username")
    public WebElement usernameS;
    @FindBy (id = "password")
    public WebElement passwordS;
    @FindBy (name = "login")
    public WebElement singInButton;
    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement signOutButton;
    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement MyAccountS;
    @FindBy(linkText = "Addresses")
    public WebElement addressButon;

    @FindBy(xpath = "//a[@href='https://hubcomfy.com/my-account-2/edit-address/shipping/']")
    public WebElement shippingaddButton;

    @FindBy(xpath = "//*[@class='edit btn btn-link btn-primary btn-underline mb-4']")
    public WebElement addButton;

    @FindBy(id = "shipping_first_name")
    public WebElement shippingfirstName;
    @FindBy(id = "shipping_last_name")
    public WebElement shippinglastName;
    @FindBy(id = "shipping_country")
    public WebElement shippingcountry;
    @FindBy(id = "shipping_address_1")
    public WebElement shippingstreet;

    @FindBy(id="shipping_postcode")
    public WebElement shippingpostcode;
    @FindBy(id="shipping_city")
    public WebElement shippingcity;
    @FindBy(id="shipping_state")
    public WebElement shippingprovience;
    @FindBy(xpath = "//*[@class='btn btn-dark btn-rounded btn-sm']")
    public WebElement saveAdressButton;
    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement addreschangedsuccessfully;

    @FindBy(xpath = "//*[@data-id='shipping_first_name']")
    public WebElement shippingkayitGorunmeName;

    @FindBy(xpath = "//*[@data-id='shipping_last_name']")
    public WebElement shippingkayitGorunmeLastName;

    @FindBy(xpath = "//*[@data-id='shipping_address_1']")
    public WebElement shippingkayitGorunmeaddreskutu;

    @FindBy(xpath = "//*[@data-id='shipping_postcode']")
    public WebElement shippingpostcdeuyari;

}
