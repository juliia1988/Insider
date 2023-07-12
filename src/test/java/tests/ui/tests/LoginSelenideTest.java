//package tests;
package tests.ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.ui.pageobjects.DashboardPage;
import tests.ui.pageobjects.LogInPage;

import static com.codeborne.selenide.Selenide.$;

public class LoginSelenideTest extends BaseTest {

    private final static String NAME = "admin";
    private final static String PASS = "admin";


    @Test
    @Description("The test is checking positive case for login")
    public void testLogInPositive() {
        new LogInPage()
                .logIn(NAME, PASS);

        SelenideElement dashboardHeaderText = new DashboardPage()
                .mainTitle();
        dashboardHeaderText.shouldBe(Condition.visible);
        dashboardHeaderText.shouldHave(Condition.text("Dashboard for admin")).getText();

    }
}
