package tests.US_05;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.US05Page.OpenSourcePage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_01_02_03_04 {

        @Test
        public void TC_01_02_03_04 () throws InterruptedException {

            OpenSourcePage openSourcePage = new OpenSourcePage();
            //1. Belirtilen URL'e gidilir
            Driver.getDriver().get(ConfigReader.getProperty("url"));
            Thread.sleep(2000);

            //2.  Sing in butonuna tıklanir
            openSourcePage.signInButton.click();
            Thread.sleep(2000);

            //3. Username ya da Email girilir
            openSourcePage.usernameTextBox.sendKeys(ConfigReader.getProperty("username"));
            Thread.sleep(2000);

            //4. Password girilir
            openSourcePage.passwordTextBox.sendKeys(ConfigReader.getProperty("password"));
            Thread.sleep(2000);

            //5. SIGN IN butonuna tiklanir
            openSourcePage.submitButton.click();
            Thread.sleep(2000);

            //6. My account butonuna tiklanir
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            Thread.sleep(2000);
            jse.executeScript("arguments[0].click()", openSourcePage.myAccount);
            Thread.sleep(2000);

            //7.Account details butonuna tiklanir
            openSourcePage.accountDetail.click();

            //8.firstname degistibilmeli
            openSourcePage.firstNameTextBox.sendKeys("canyon");
            openSourcePage.firstNameTextBox.clear();
            openSourcePage.firstNameTextBox.sendKeys("carl");

            //9.lastname degistibilmeli
            openSourcePage.lastNameTextBox.sendKeys("langston");
            openSourcePage.lastNameTextBox.clear();
            openSourcePage.lastNameTextBox.sendKeys("sagan");

            //10.displayname degistibilmeli
            openSourcePage.displayNameTextBox.clear();
            openSourcePage.displayNameTextBox.sendKeys("carlSagan");

            //11.Email degistibilmeli
            openSourcePage.emailAddress.clear();
            openSourcePage.emailAddress.sendKeys("jully.carroll@fixedfor.com");

            //12.Biografi bolumunu doudurabilmeli
            Driver.getDriver().switchTo().frame(openSourcePage.iFrame);

            openSourcePage.textInput.sendKeys("Selenium TestNG Project");

            Driver.getDriver().switchTo().parentFrame();


            //13.Password” u degistirebilmeli
            openSourcePage.mainPassword.sendKeys(ConfigReader.getProperty("password"));
            openSourcePage.newPassword.sendKeys("gkzax9U$");
            openSourcePage.confirmPassword.sendKeys("gkzax9U$");

            jse.executeScript("arguments[0].click()", openSourcePage.saveChanges);


        }
}