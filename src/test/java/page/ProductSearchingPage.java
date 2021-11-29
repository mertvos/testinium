package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductSearchingPage extends BasePage {

    public ProductSearchingPage (WebDriver driver) {super(driver);}

    // WEB Elements ****

    By searchBar = By.name("k");
    By searchButton = By.xpath("//header[@id='main-header']/div[3]/div/div/div/div[2]/form/div/div[2]/button/span");
    By searchItemName = By.xpath("//div[@id='__next']/main/div[2]/div/div/div[2]/div/div[3]/div/div/h1/b");
    By goTo2ndPage = By.xpath("//div[@id='__next']/main/div[2]/div/div/div[2]/div/div[3]/div[4]/nav/ul/li[3]/a/span");
    By secondPageVerify= By.xpath("//div[@id='__next']/main/div[2]/div/div/div[2]/div/div[3]/div[4]/nav/ul/li[3]/a/span");

    public ProductSearchingPage searchProduct (String searchItem) throws Exception {
        writeText(searchBar, searchItem);
        click(searchButton);
        return this;
    }

    public ProductSearchingPage goTo2ndPage ()throws Exception{
        scrollAndClick(goTo2ndPage);
        return this;
    }

    //verify search item
    public ProductSearchingPage verifyItemName (String expectedText) {
        assertEquals(searchItemName, expectedText);
        return this;
    }
    //verify 2nd page
    public ProductSearchingPage verify2ndPage (String expectedText) {
        assertEquals(secondPageVerify, expectedText);
        return this;
    }

}
