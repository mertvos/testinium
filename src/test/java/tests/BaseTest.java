package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger logTest = Logger.getLogger(BaseTest.class);

    public void setUp(String driverName)
    {
        PropertyConfigurator.configure("drivers/log4j.properties");
        //logTest.info("Driver:" + driverName.toUpperCase());

        if ("CHROME".equals(driverName.toUpperCase()))
        {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if ("FİREFOX".equals(driverName.toUpperCase()))
        {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown () {
        driver.quit();
    }
}
