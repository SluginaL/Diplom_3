package stellarburgers_tests;

import main.BrowserRule;
import org.junit.*;
import pom.LoginPage;
import pom.MainPage;
import pom.PasswordRecoverPage;
import pom.RegistrationPage;

public class LogInTests {

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
    public void checkLogInFromMainPageLogInButton() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        mainPage.open();
        mainPage.logIn(MainPage.logInButton);
        loginPage.logIn(email, password);
        Assert.assertTrue("Пользователь не залогинен", mainPage.getMakeOrderButton().isDisplayed());
    }

    @Test
    public void checkLogInFromMainPagePersonalCabinetButton() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        mainPage.open();
        mainPage.logIn(MainPage.personalCabinet);
        loginPage.logIn(email, password);
        Assert.assertTrue("Пользователь не залогинен", mainPage.getMakeOrderButton().isDisplayed());
    }

    @Test
    public void checkLogInFromRegistrationForm() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());
        registrationPage
                .open()
                .clickLogIn();
        loginPage.logIn(email, password);
        Assert.assertTrue("Пользователь не залогинен", mainPage.getMakeOrderButton().isDisplayed());
    }

    @Test
    public void checkLogInFromPasswordRecoverForm() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        PasswordRecoverPage passwordRecoverPage = new PasswordRecoverPage(browserRule.getDriver());
        passwordRecoverPage
                .open()
                .clickLogIn();
        loginPage.logIn(email, password);
        Assert.assertTrue("Пользователь не залогинен", mainPage.getMakeOrderButton().isDisplayed());
    }
}