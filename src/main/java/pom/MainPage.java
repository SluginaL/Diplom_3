package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

    private static final String url = "https://stellarburgers.nomoreparties.site/";

    // Кнопка "Личный Кабинет" в хэдэре
    public static final By personalCabinetButton = By.xpath(".//*[text()='Личный Кабинет']");

    // Заголовок
    public final static By header = By.tagName("h1");

    // Кнопки залогина
    public static String logInButton = ".//*[text()='Войти в аккаунт']";
    public static String personalCabinet = ".//*[text()='Личный Кабинет']";

    // Кнопка Оформить заказ
    public static final By makeOrderButton = By.xpath(".//button[text() = 'Оформить заказ']");

    // Кнопка Булки
    public static String breadButton = ".//span[text() = 'Булки']/parent::div";

    // Кнопка Соусы
    public static String saucesButton = ".//span[text() = 'Соусы']/parent::div";

    // Кнопка Начинки
    public static String fillingsButton = ".//span[text() = 'Начинки']/parent::div";

    // Выбранный раздел
    public static final By selectedSection = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPersonalCabinetButton() {
        driver.findElement(personalCabinetButton).click();
    }

    public void logIn(String button) {
        driver.findElement(By.xpath(button)).click();
    }
    public MainPage chooseSection(String section) {
        driver.findElement(By.xpath(section)).click();
        return this;
    }

    public MainPage open() {
        driver.get(url);
        return this;
    }

    public WebElement getMakeOrderButton() {
        return driver.findElement(makeOrderButton);
    }

    public String getSelectedSection() {
        return driver.findElement(selectedSection).getText();
    }

    public WebElement getHeader() {
        return driver.findElement(header);
    }
}