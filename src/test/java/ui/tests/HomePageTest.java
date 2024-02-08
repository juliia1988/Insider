package ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.pageobjects.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    @Description("The test is checking positive case that Home page is opened")
    public void testHomePageLoaded() {
        new HomePage()
                .set();

        SelenideElement mainText = new HomePage()
                .getMainText();
        mainText.shouldBe(Condition.visible);
        mainText.shouldHave(Condition.text("#1 platform for individualized, ")).getText();

    }

}
