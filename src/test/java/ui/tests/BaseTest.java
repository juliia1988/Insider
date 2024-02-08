package ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    private static final String URL = "https://useinsider.com/";

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
//        Configuration.headless = true;
//        Configuration.browser = "firefox";
        Selenide.open(URL);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        closeWebDriver();
    }

}
