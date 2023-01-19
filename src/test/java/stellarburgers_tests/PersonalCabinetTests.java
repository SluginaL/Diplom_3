package stellarburgers_tests;

import main.BrowserRule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.LoginPage;
import pom.MainPage;
import pom.PersonalCabinet;
import pom.RegistrationPage;

public class PersonalCabinetTests {

    private String email;
    private String password;

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Before
    public void prepareTestData() {
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());
        email = registrationPage.getEmail();
        password = registrationPage.getPassword();
        registrationPage
                .open()
                .registerCorrect(email, password);
    }

    @Test
    public void checkGoToPersonalCabinetTest(){
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        PersonalCabinet personalCabinet = new PersonalCabinet(browserRule.getDriver());
        loginPage
                .open()
                .logIn(email, password);
        mainPage.clickPersonalCabinetButton();
        Assert.assertTrue("Личный кабинет не открылся", personalCabinet.getLogOutButton().isDisplayed());
    }

    @Test
    public void checkConstructorLinkTest(){
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        PersonalCabinet personalCabinet = new PersonalCabinet(browserRule.getDriver());
        loginPage
                .open()
                .logIn(email, password);
        mainPage.clickPersonalCabinetButton();
        personalCabinet.clickConstructorButton();
        Assert.assertTrue("Конструктор бургеров не открылся", mainPage.getHeader().getText().contains("Соберите бургер"));
    }

    @Test
    public void checkLogoLinkTest(){
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        PersonalCabinet personalCabinet = new PersonalCabinet(browserRule.getDriver());
        loginPage
                .open()
                .logIn(email, password);
        mainPage.clickPersonalCabinetButton();
        personalCabinet.clickOnLogo();
        Assert.assertTrue("Конструктор бургеров не открылся", mainPage.getHeader().getText().contains("Соберите бургер"));
    }

    @Test
    public void checkLogOutTest(){
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        PersonalCabinet personalCabinet = new PersonalCabinet(browserRule.getDriver());
        loginPage
                .open()
                .logIn("serj@ya.ru", "123456");
        mainPage.clickPersonalCabinetButton();
        new WebDriverWait(browserRule.getDriver(), 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text() = 'Выход']")));
        personalCabinet.logOut();
        new WebDriverWait(browserRule.getDriver(), 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        Assert.assertTrue("Кнопка Выйти не нажалась(((", loginPage.getHeader().getText().contains("Вход"));
    }
}