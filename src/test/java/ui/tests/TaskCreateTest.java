package ui.tests;

import api.steps.UserApiSteps;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pageobjects.DashboardPage;
import ui.pageobjects.LogInPage;
import ui.pageobjects.ProjectPage;

public class TaskCreateTest extends BaseTest {

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
    @Description("Check that ouldu create TASK")
    public void testEndToEndUiFlow() {
        new LogInPage()
                .logIn(USERNAME, PASSWORD);

        String formId = RandomStringUtils.randomAlphabetic(10);
        SelenideElement commentText = new DashboardPage()
                .CreateProject("Project 6", formId).getComment();

        String randomTaskName = RandomStringUtils.randomAlphabetic(10);
        new ProjectPage()
                .createTask(randomTaskName);
    }

    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        userApiSteps.deleteUser(userId);
    }

}
