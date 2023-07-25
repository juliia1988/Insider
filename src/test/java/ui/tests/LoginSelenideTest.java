//package tests;
package ui.tests;

import api.steps.UserApiSteps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pageobjects.DashboardPage;
import ui.pageobjects.LogInPage;

import static com.codeborne.selenide.Selenide.$;

public class LoginSelenideTest extends BaseTest {

    private static final String USERNAME = "user8899";
    private static final String PASSWORD = "myTestPassword";

    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;

    @BeforeMethod
    public void prepareDataForTest() {
        userId = String.valueOf(userApiSteps.createUser(USERNAME, PASSWORD));
        System.out.println(userId);
    }

    @Test
    @Description("The test is checking positive case for login")
    public void testLogInPositive() {
        new LogInPage()
                .logIn(USERNAME, PASSWORD);

        SelenideElement dashboardHeaderText = new DashboardPage()
                .mainTitle();
        dashboardHeaderText.shouldBe(Condition.visible);
        dashboardHeaderText.shouldHave(Condition.text("Dashboard for " + USERNAME)).getText();

    }

    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        userApiSteps.deleteUser(userId);
    }
}
