package ui.tests;

import api.steps.UserApiSteps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pageobjects.DashboardPage;
import ui.pageobjects.LogInPage;

public class ProjectCreateTest extends BaseTest {

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
    @Description("Check Project creation through the UI: Check that project Summary exist if create new Projects")
    public void testCreateProject() {
        new LogInPage()
                .logIn(USERNAME, PASSWORD);

        String formId = RandomStringUtils.randomAlphabetic(10);
        SelenideElement projectSummmaryText = new DashboardPage()
                .createProject("Project 2", formId).getProjectSummary();

        projectSummmaryText.shouldBe(Condition.visible);
        projectSummmaryText.shouldHave(Condition.text("Summary")).getText();
    }

    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        userApiSteps.deleteUser(userId);
    }

}
