package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class RegistrationPage {
    private WebDriver driver;

    private static final String url = "https://stellarburgers.nomoreparties.site/register";

    // Поле "Имя"
    public final static By nameField = By.xpath(".//label[text() = 'Имя']/parent::div/input");

    // Поле "Email"
    public final static By emailField = By.xpath(".//label[text() = 'Email']/parent::div/input");

    // Поле "Пароль"
    public final static By passwordField = By.xpath(".//input[@name = 'Пароль']");

    // Кнопка "Зарегистрироваться"
    public final static By registrationButton = By.xpath(".//*[text() = 'Зарегистрироваться']");

    // Ошибка "Неверный пароль"
    public final static By error = By.xpath(".//p[contains(@class, 'input__error')]");

    // Ссылка Войти
    public final static By logIn = By.xpath(".//a[text() = 'Войти']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage open() {
        driver.get(url);
        return this;
    }

    private void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    private void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    private void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void registerCorrect() {
        enterName(getName());
        enterEmail(getEmail());
        enterPassword(getPassword());
        clickRegistrationButton();
    }

    public void registerCorrect(String email, String password) {
        enterName(getName());
        enterEmail(email);
        enterPassword(password);
        clickRegistrationButton();
    }

    public void registerIncorrect() {
        enterName(getName());
        enterEmail(getEmail());
        enterPassword("12345");
        clickRegistrationButton();
    }

    public boolean hasError() {
        try {
            driver.findElement(error);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickLogIn() {
        driver.findElement(logIn).click();
    }

    public String getName() {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder username = new StringBuilder();
        Random rnd = new Random();
        while (username.length() < 10) {
            int index = (int) (rnd.nextFloat() * symbols.length());
            username.append(symbols.charAt(index));
        }
        String name = username.toString();
        return name;
    }

    public String getEmail() {
        String symbols = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();
        Random rnd = new Random();
        while (email.length() < 10) {
            int index = (int) (rnd.nextFloat() * symbols.length());
            email.append(symbols.charAt(index));
        }
        String userEmail = email.toString();
        return userEmail;
    }

    public String getPassword() {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*";
        StringBuilder password = new StringBuilder();
        Random rnd = new Random();
        while (password.length() < 7) {
            int index = (int) (rnd.nextFloat() * symbols.length());
            password.append(symbols.charAt(index));
        }
        String userPassword = password.toString();
        return userPassword;
    }
}