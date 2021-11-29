package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.BaseTest;


public class BasePage {
    public WebDriver driver;
    protected WebDriverWait wait;
    private static String firstShopPrice;
    private static String firstProductPrice;
    protected static final org.apache.log4j.Logger logTest = Logger.getLogger(BaseTest.class);
    //scroll
    JavascriptExecutor js = (JavascriptExecutor) driver;

    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    //only find element method
    public void findElements (By elementBy) {
        waitVisibility(elementBy);
         driver.findElement(elementBy);
    }
    //Click Method
    public void click (By elementBy) throws Exception {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }
    //Write Text
    public void writeText (By elementBy, String text) throws Exception {
        //waitVisibility(elementBy);
        //driver.findElement(elementBy).click();
        //driver.findElement(elementBy).clear();
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
        Thread.sleep(1500); //not necessary
    }

    //Read Text
    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void scrollAndClick (By elementBy) throws Exception{

        JavascriptExecutor js = (JavascriptExecutor) driver;
        waitVisibility(elementBy);
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(elementBy));
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();

    }

    public String shopPrice() throws Exception {
        Thread.sleep(1000);
        String shopPrice = (String)driver.findElement(By.id("sp-price-lowPrice")).getText();
        System.out.println(shopPrice);
        firstShopPrice = shopPrice;
        return shopPrice;
    }

    public String productPrice() throws Exception {
        Thread.sleep(1000);
        String productPrice = (String)driver.findElement(By.cssSelector("p.new-price")).getText();
        System.out.println(productPrice);
        firstProductPrice = productPrice;
        return productPrice;
    }

    public void compareProducts() throws Exception {
        productPrice();
        //storeTextChart();
        if(productPrice().equals(firstShopPrice)){
            logTest.info("fiyatlar karşılaştıldığında Aynı üründür." + firstShopPrice);
        }
    }

    //Assert
    public void assertEquals (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);

    }


}
