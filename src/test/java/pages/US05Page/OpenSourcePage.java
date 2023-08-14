package pages.US05Page;

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

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/nav/ul/li[5]/a")
    public WebElement accountDetail;

    @FindBy(xpath = "//input[@id='account_first_name']")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@id='account_last_name']")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//*[@id='account_display_name']")
    public WebElement displayNameTextBox;

    @FindBy(xpath = "//*[@id='account_email']")
    public WebElement emailAddress;

    @FindBy(xpath = "//*[@id='user_description_ifr']")
    public WebElement iFrame;

    @FindBy(xpath = "//*[@id='tinymce']")
    public WebElement textInput;

    @FindBy(id = "password_current")
    public WebElement mainPassword;

    @FindBy(id = "password_1")
    public WebElement newPassword;

    @FindBy(id = "password_2")
    public WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/form/p[7]/button")
    public WebElement saveChanges;

}
