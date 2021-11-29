package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public By iconBasketElement = By.cssSelector("div.icon-sepet-line-wrapper &gt; img");
    public By productPriceElement = By.cssSelector("p.new-price");


    public ProductPage goToBasket() throws Exception {
        click(iconBasketElement);
        return this;
    }


}
