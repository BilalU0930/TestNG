package tests.US_04;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US04Page.OpenSourcePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_01 {

    @Test
    public void testTC01() {

        OpenSourcePage shippingAddress = new OpenSourcePage();
        Faker faker = new Faker();

        //     1. Belirtilen URL'e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("url"));


        //    2.  Sing in butonuna tıklanir.
        shippingAddress.signInFirst.click();

        //     3. Username ya da Email girilir.
        shippingAddress.usernameS.sendKeys(ConfigReader.getProperty("username"));

        //     4.  Password girilir.
        shippingAddress.passwordS.sendKeys(ConfigReader.getProperty("password"));

        //     5. SIGN IN butonuna tiklanir.
        shippingAddress.singInButton.click();

        //   6. Sign out buttonuna tiklar
        shippingAddress.signOutButton.click();

        //    7. Addresses butonuna tiklanir.
        shippingAddress.addressButon.click();

        //    8. Shipping Adress bolumundeki ADD butonuna tiklanir.
        shippingAddress.addButton.click();

        //    9. 10 .  First name inputuna veri girilir. //Last name inputuna veri girilir.

        shippingAddress.shippingfirstName.clear();
        shippingAddress.shippingfirstName.sendKeys(faker.name().firstName());
        shippingAddress.shippinglastName.clear();
        shippingAddress.shippinglastName.sendKeys(faker.name().lastName());

        //    11.  Country/Region dropdown'indan secim yapilir.
        Select select = new Select(shippingAddress.shippingcountry);
        select.selectByVisibleText("Turkey");

        //     12. Street adress alanina veri girilir.
        shippingAddress.shippingstreet.clear();
        shippingAddress.shippingstreet.sendKeys(faker.address().streetAddress());


        //     13.  Town/City alanina veri girilir.
        shippingAddress.shippingcity.clear();
        shippingAddress.shippingcity.sendKeys(faker.address().city());

        //    14.  Postcode / ZIP alanina veri girilir.
        shippingAddress.shippingpostcode.clear();
        shippingAddress.shippingpostcode.sendKeys(faker.address().zipCode());

        //    15. Province  dropdown'undan secim yapilir.
        Select select1 = new Select(shippingAddress.shippingprovience);
        select1.selectByVisibleText("Ankara");

        //    16. SAVE ADDRESS butonuna tiklanir.
        ReusableMethods.clickJavaScript(shippingAddress.saveAdressButton);


        // 17.   Kaydedilen adresin Shipping address olarak kayit edildigi dogrulanir.
        Assert.assertTrue(shippingAddress.addreschangedsuccessfully.getText().contains("Address changed successfully."));
        Driver.closeDriver();


    }
}
