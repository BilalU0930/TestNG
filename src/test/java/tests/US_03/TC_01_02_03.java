package tests.US_03;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.US03Page.OpenSourcePage;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.TestBase.driver;

public class TC_01_02_03 {

    @Test
    public void TC_01_02_03() throws InterruptedException {

        OpenSourcePage openSourcePage = new OpenSourcePage();

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        Thread.sleep(2000);
        openSourcePage.signInButton.click();

        Thread.sleep(2000);
        openSourcePage.usernameTextBox.sendKeys(ConfigReader.getProperty("username"));

        Thread.sleep(2000);
        openSourcePage.passwordTextBox.sendKeys(ConfigReader.getProperty("password"));

        Thread.sleep(2000);
        openSourcePage.submitButton.click();

        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        Thread.sleep(2000);
        jse.executeScript("arguments[0].click()", openSourcePage.myAccount);

        Thread.sleep(2000);
        openSourcePage.adresses.click();

        Thread.sleep(2000);
        openSourcePage.addButton.click();
        Driver.getDriver().manage().window().fullscreen();

        Thread.sleep(2000);
        openSourcePage.firstNameTextbox.clear();
        openSourcePage.firstNameTextbox.sendKeys(ConfigReader.getProperty("firstname"));

        Thread.sleep(2000);
        openSourcePage.lastNameTextbox.clear();
        openSourcePage.lastNameTextbox.sendKeys(ConfigReader.getProperty("lastname"));

        Thread.sleep(2000);
        openSourcePage.companyName.clear();
        openSourcePage.companyName.sendKeys("TechProEdu");

        Thread.sleep(2000);
        Select select = new Select(openSourcePage.country);
        select.selectByVisibleText("Turkey");

        Thread.sleep(2000);
        openSourcePage.streetAddress.click();

        Thread.sleep(2000);
        openSourcePage.streetAddress.clear();
        openSourcePage.streetAddress.sendKeys("Şelale Evleri 205.Sokak No:8/2");

        Thread.sleep(2000);
        openSourcePage.townCity.clear();
        openSourcePage.townCity.sendKeys("Burdur");

        Thread.sleep(2000);
        Select select1 = new Select(openSourcePage.state);
        select1.selectByVisibleText("Burdur");

        Thread.sleep(2000);
        openSourcePage.postCode.clear();
        openSourcePage.postCode.sendKeys("15030");

        Thread.sleep(2000);
        openSourcePage.phoneNumber.clear();
        openSourcePage.phoneNumber.sendKeys("+90 531 527 02 07");

        Thread.sleep(2000);
        jse.executeScript("arguments[0].click()", openSourcePage.myAccountSubmit);

    }
}
