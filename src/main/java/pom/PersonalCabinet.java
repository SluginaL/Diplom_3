package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalCabinet {

    private WebDriver driver;

    // Кнопка конструктор
    public final static By constructorButton = By.xpath(".//p[text() = 'Конструктор']");

    // Logo
    public final static By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    // Кнопка выйти
    public final static By logOutButton = By.xpath(".//button[text() = 'Выход']");

    public PersonalCabinet(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickOnLogo() {
        driver.findElement(logo).click();
    }

    public void logOut(){
        driver.findElement(logOutButton).click();
    }

    public WebElement getLogOutButton() {
        return driver.findElement(logOutButton);
    }
}
