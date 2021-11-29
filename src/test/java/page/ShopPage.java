package page;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ShopPage extends BasePage{
    String basketURL = "https://www.gittigidiyor.com/sepetim";


        public ShopPage(WebDriver driver) {
            super(driver);
        }

        public By shopProductElement = By.id("sp-title");
        public By addElement = By.id("add-to-basket");



         public ShopPage shopProductName() {
        readText(shopProductElement);
        return this;
    }


    public ShopPage addProduct() throws Exception{
        click(addElement);
        Thread.sleep(1000);
        driver.get(basketURL);
        return this;
    }

    }
