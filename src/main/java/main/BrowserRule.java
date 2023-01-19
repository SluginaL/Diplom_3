package main;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BrowserRule extends ExternalResource {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public String DRIVER_PATH = new File("drivers/chromedriver").getAbsolutePath();


    @Override
    protected void before() throws Throwable {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Override
    protected void after() {
        driver.quit();
    }

}