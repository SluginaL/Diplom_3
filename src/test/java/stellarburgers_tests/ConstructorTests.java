package stellarburgers_tests;

import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pom.MainPage;

@RunWith(Parameterized.class)
public class ConstructorTests {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    public ConstructorTests(String sectionButton, String sectionName) {
        this.sectionButton = sectionButton;
        this.sectionName = sectionName;
    }

    private final String sectionButton;
    private final String sectionName;

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] data() {
        return new Object[][]{
                {MainPage.breadButton, "Булки"},
                {MainPage.saucesButton, "Соусы"},
                {MainPage.fillingsButton, "Начинки"}
        };
    }

    @Test
    public void checkBreadButton() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.open();
        if (sectionName.equals("Булки")) {
            mainPage.chooseSection(MainPage.saucesButton);
        }
        mainPage.chooseSection(sectionButton);
        Assert.assertTrue("Переход к разделу не осуществлен", mainPage.getSelectedSection().contains(sectionName));
    }
}