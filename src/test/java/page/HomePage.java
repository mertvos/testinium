package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage(WebDriver driver) { super(driver); }

    //*********Page Variables*********

    String baseURL = "https://www.gittigidiyor.com";


    // WEB ELEMENTS ****
    By cookieClosed = By.xpath("//*/text()[normalize-space(.)='Kapat']/parent::*");


    //*********Page Methods*********
    //Go to Homepage
    public HomePage goToTestGittigidiyor () throws Exception {
        driver.get(baseURL);
        click(cookieClosed);
        return this;
    }

}
