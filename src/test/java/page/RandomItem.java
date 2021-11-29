package page;

import base.BasePage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

import java.util.List;
import java.util.Random;

public class RandomItem extends BasePage {


    public RandomItem (WebDriver driver) {super(driver);}

    //web element:



    public RandomItem randomItem() throws Exception{ //istenirse diğerleri gibi object pattern olabilir.

        List<WebElement> itemLinks = driver.findElements(By.partialLinkText("Ram"));
        System.out.println("The Number Of item links in the 2nd page " +itemLinks.size());
        Random r = new Random();
        int randomItem = (r.nextInt(itemLinks.size()-1));
        itemLinks.get(randomItem).click();
        return this;

    }


}
