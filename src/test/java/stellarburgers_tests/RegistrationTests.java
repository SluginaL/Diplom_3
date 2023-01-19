package stellarburgers_tests;

import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.LoginPage;
import pom.RegistrationPage;

public class RegistrationTests {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void registrationTest() {
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());
        registrationPage
                .open()
                .registerCorrect();
        new WebDriverWait(browserRule.getDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text() = 'Войти']")));
        Assert.assertTrue("Пользователь не зарегистрирован", loginPage.getHeader().getText().contains("Вход"));
    }

    @Test
    public void passwordErrorTest() {
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());
        registrationPage
                .open()
                .registerIncorrect();
        Assert.assertTrue("Должно появиться сообщение о некорректном пароле!", registrationPage.hasError());
    }
}