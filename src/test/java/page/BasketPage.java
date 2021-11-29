package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver){super(driver);}

    By productSize = By.cssSelector("select.amount");
    By verifyProductCounttab = By.xpath("//form[@id='submit-cart']/div/div[2]/div[2]/div/div/div/div[5]/div/div/ul/li/div");
    By btnDeleteBasket = By.className("btn-delete");
    By verifyemptyBasket = By.cssSelector("h2");

    public BasketPage basketCountIncrease (String productCount )throws Exception{
        writeText(productSize, productCount );
        return this;
    }

    public BasketPage verifyProductCount (String expectedText) {
        assertEquals(verifyProductCounttab, expectedText);
        return this;

    }

    public BasketPage deleteBasket () throws Exception{
        click(btnDeleteBasket);
        return this;
    }
    public BasketPage verifyEmptyBasket (String expectedText) {
        assertEquals(verifyemptyBasket, expectedText);
        return this;
    }

    public BasketPage verifyProductPrices () throws Exception{

        compareProducts();
        return this;
    }


}
