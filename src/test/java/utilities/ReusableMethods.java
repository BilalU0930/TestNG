package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mongodb.assertions.Assertions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.asserts.Assertion;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;

public class ReusableMethods {


    public static ExtentReports extentReports; //Raporlamayı başlatır
    protected static ExtentHtmlReporter extentHtmlReporter;//Raporu HTML formatında düzenler
    public static ExtentTest extentTest;//Tüm test aşamalarında extentTest objesi ile bilgi ekleriz


    //HARD WAIT METHOD
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //ALERT ACCEPT
    public static void alertAccept() {
        Driver.getDriver().switchTo().alert().accept();
    }

    //Alert DISMISS
    public static void alertDismiss() {
        Driver.getDriver().switchTo().alert().dismiss();
    }

    //Alert getText()
    public static void alertText() {
        Driver.getDriver().switchTo().alert().getText();
    }

    //Alert promptBox
    public static void alertSendText(String text) {
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }

    /*
     Select select2 = new Select(gun);
     select2.selectByVisibleText("7");

       //ddmVisibleText(gun,"7"); -->Yukarıdaki kullanım yerine sadece method ile handle edebilirim.
     */

    //DropDown VisibleText
    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //DropDown Index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public static void ddmValue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    //SwitchToWindow
    public static void switchToWindow(int sayi) {
        List<String> tumWindowsHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tumWindowsHandles.get(sayi));
    }

    //SwitchToWindow
    public static void window(int sayi) {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[sayi].toString());
    }

    //EXPLİCİT WAIT METHODS
    //VİSİBLE Wait
    public static void visibleWait(WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //VisibleElementLocator Wait
    public static void visibleWaitPractice(WebElement webElement, int sure) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sure));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    //Alert Wait
    public static void alertWait(int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());


    }
    /**
     bu metot ekrani bir masue tekeri donmesi kadar asagi kaydirir
     */
    public static void pageDown() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    /**
     bu metot ekrani bir masue tekeri donmesi kadar yukari kaydirir
     */
    public static void pageUp() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    /**
     bu metot ekrani bir tik asagi kaydirir
     */
    public static void arrowDown() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }

    /**
     bu metot ekrani bir tik yukari kaydirir
     */
    public static void arrowUp() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_UP).perform();
    }

    /**
     bu metot ile mause element ustunde bekletilir
     @param webElement girilmesi gereken locate dir
     */
    public static void moveToElement(WebElement webElement) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(webElement).perform();
    }

    //Tüm sayfa ScreenShot
    public static void tumSayfaResmi(String name) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/screenShot" + tarih + name + ".png";

        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();

        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //Webelement Screenshot
    public static void webElementResmi(WebElement webElement) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/webElementScreenShot" + tarih + ".png";
        try {
            FileUtils.copyFile(webElement.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     bu metot ile extent rapor olusturulur
     */
    public static void extentReport() {

        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);


        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Hakan Kara");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");


    }
    /**
     bu metot ile extent rapora bilgi girisi saglanir
     @param message
     */
    public static void extentTestInfo(String message) {
        if (extentTest != null) {
            extentTest.info(message);
        }
    }
    /**
     bu metot ile extent rapor bitirilir
     */
    public static void extentRaporBitir() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }


   //WebTable
    public static void printData(int satir, int sutun) {

        WebElement satirSutun = Driver.getDriver().findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(satirSutun.getText());
    }

    //Click method
    public static void clickJavaScript(WebElement webElement) {
        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].click();", webElement);
        }
    }


    //JS Scroll
    public static void scrollToWebelementJavaScript(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    //JS Sayfa Sonu Scroll
    public static void scrollEndJavaScript() {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //JS Sayfa Başı Scroll
    public static void scrollHomeJavaScript() {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }


    /**
     @param  webElement girilmesi gereken element locati
     @param text gonderilmek istenen metin
      *bu metot ile metin kutusuna sendkeys gonderir
     */
    public static void sendKeysJavaScript(WebElement webElement, String text) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].value='" + text + "'", webElement);
    }


    /**
     @param id girilmesi gereken id degeri
     @param attributeName gonderilmesi gereken attribute ismi
     bu metot ile girilen attribute degerleri ile texti alabilirim
     */
    public static void getValueByJavaScript(String id, String attributeName) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);

    }

    /**
     *  JavaScript ile webelement olusturma
     * @param javascriptYolu internet sitesinden sag klik ile JS yolunu kopyala ile alınan metin olacak
     */

    public static WebElement webelementJavaScript(String javascriptYolu) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement webElement = (WebElement) js.executeScript("return "+javascriptYolu+"");
        return webElement;
    }

    /**
     *  JavaScript ile webelement olusturup isEnabled oldugunu sorgulama
     * @param str internet sitesinden sag klik ile JS yolunu kopyala ile alınan metin olacak
     */
    public static void assertIsEnabled(String str){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement webElement = (WebElement) js.executeScript("return "+str+"");
        AssertJUnit.assertTrue(webElement.isEnabled());
    }

    /**
     *  JavaScript ile cift klik yapma
     * @param element ile locate verilir
     */
    public static void doubleClick (WebElement element){
        Actions actions=new Actions(Driver.getDriver());
        actions.doubleClick(element).perform();

    }









    public static void uploadFilePath(String filePath){
        try{
            ReusableMethods.bekle(3);
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
            Robot robot = new Robot();
            //pressing ctrl+v
            robot.keyPress(KeyEvent.VK_CONTROL);
            ReusableMethods.bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            ReusableMethods.bekle(3);
            //releasing ctrl+v
            robot.keyRelease(KeyEvent.VK_CONTROL);
            ReusableMethods.bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            ReusableMethods.bekle(3);
            System.out.println("PASSED");
            //pressing enter
            ReusableMethods.bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            ReusableMethods.bekle(3);
            //releasing enter
            robot.keyRelease(KeyEvent.VK_ENTER);
            ReusableMethods.bekle(3);
            System.out.println("ENTER");
        }catch (Exception e){
        }
    }


    /**
     bu metot ile acilan ilk pencereye donulur
     @param sayi girilmesi gereken gecilecek pencerenin indexidir
     */
    public static void switchToWindow1(int sayi) {
        List<String> tumWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tumWindowHandles.get(sayi));
    }

    /**
     bu metot ile acilan pencereye gecilir
     @param sayi girilmesi gereken gecilecek pencerenin indexidir
     */
    public static void switchToWindow2(int sayi) {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[sayi].toString());
    }

    /** Bu metot ile select objesinin indexi ile secim yapilir
     *
     * @param webElement elementin locatidir
     * @param str   secilecek index numarasidir
     */
    public static void selectByIndexWithJavascript(WebElement webElement, String str) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].selectedIndex = "+str+"; arguments[0].dispatchEvent(new Event('change'))", webElement);
    }

    /** Bu metot ile select objesinin indexi ile secim yapilir
     *
     * @param webElement elementin locatidir
     * @param str   gonderilecek value degeridir
     */
    public static void selectByValueWithJavascript(WebElement webElement, String str) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value = "+str+"; arguments[0].dispatchEvent(new Event('change'))", webElement);
    }

    public static void extentReportName(String testerName, String reportName) {

        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/reports/extentReport_" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);


        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", testerName);
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName(reportName);


    }


}
