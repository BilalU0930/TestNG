package tests.US_01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US02Page.OpenSourcePage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_01_02_03_04_05 {

    @Test
    public void TC_01_02_03_04_05() throws InterruptedException {
        OpenSourcePage openSourcePage = new OpenSourcePage();

        Driver.getDriver().get("https://www.allure2you.com");

        Thread.sleep(2000);

        openSourcePage.register.click();
        Thread.sleep(2000);
        openSourcePage.registerUsername.sendKeys(ConfigReader.getProperty("username"));
        Thread.sleep(2000);
        openSourcePage.registeremail.sendKeys(ConfigReader.getProperty("email"));
        Thread.sleep(2000);
        openSourcePage.registerpassword.sendKeys(ConfigReader.getProperty("password"));
        Thread.sleep(2000);
        openSourcePage.Iagreetotheprivacypolicy.click();
        Thread.sleep(2000);
        openSourcePage.submit.click();

        Thread.sleep(2000);

        Assert.assertTrue(openSourcePage.alertText.isDisplayed(), "TEST PASSED");

    }

}
