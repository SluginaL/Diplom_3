package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoverPage {
    private WebDriver driver;

    private static final String url = "https://stellarburgers.nomoreparties.site/forgot-password";

    // Кнопка "Войти"
    public final static By logInButton = By.xpath(".//a[text() = 'Войти']");

    public PasswordRecoverPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogIn() {
        driver.findElement(logInButton).click();
    }

    public PasswordRecoverPage open() {
        driver.get(url);
        return this;
    }
}