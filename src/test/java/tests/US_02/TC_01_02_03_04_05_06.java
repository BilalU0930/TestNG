package tests.US_02;

import org.testng.annotations.Test;
import pages.US01Page.OpenSourcePage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_01_02_03_04_05_06 {

    @Test
    public void TC_01_02_03_04_05_06() throws InterruptedException {
        OpenSourcePage openSourcePage = new OpenSourcePage();

        Thread.sleep(3000);

        Driver.getDriver().get("https://www.allure2you.com");

        Thread.sleep(3000);

        openSourcePage.register.click();
        Thread.sleep(3000);
        openSourcePage.registerUsername.sendKeys(ConfigReader.getProperty("username"));
        Thread.sleep(3000);
        openSourcePage.registeremail.sendKeys(ConfigReader.getProperty("email"));
        Thread.sleep(3000);
        openSourcePage.registerpassword.sendKeys(ConfigReader.getProperty("password"));
        Thread.sleep(3000);
        openSourcePage.Iagreetotheprivacypolicy.click();
        Thread.sleep(3000);
        openSourcePage.submit.click();



    }
}
