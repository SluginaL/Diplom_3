package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private static final String url = "https://stellarburgers.nomoreparties.site/login";

    // Заголовок страницы
    public final static By header = By.xpath(".//h2");

    // Поле "Имя"
    public final static By emailField = By.xpath(".//label[text() = 'Email']/parent::div/input");

    // Поле "Пароль"
    public final static By passwordField = By.xpath(".//input[@name = 'Пароль']");

    // Кнопка "Войти"
    public final static By logInButton = By.xpath(".//button[text() = 'Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHeader() {
        return driver.findElement(header);
    }

    public LoginPage open() {
        driver.get(url);
        return this;
    }

    public void logIn(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(logInButton).click();
    }
}