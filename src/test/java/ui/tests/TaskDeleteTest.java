package ui.tests;

import api.steps.LinkProjectApiSteps;
import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pageobjects.DashboardPage;
import ui.pageobjects.LogInPage;
import ui.pageobjects.ProjectPage;
import ui.pageobjects.TaskPage;

public class TaskDeleteTest extends BaseTest {

    private static final String USERNAME = "userTaskDeleteTest";
    private static final String PASSWORD = "myTestPassword";

    UserApiSteps userApiSteps = new UserApiSteps();
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    private String userId;
    private String projectId;

    @BeforeMethod
    public void prepareDataForTest() {
        userId = String.valueOf(userApiSteps.createUser(USERNAME, PASSWORD));
        System.out.println(userId);
    }

    @Test
    @Description("Check TASK could be deleted through the UI when USER and PROJECT was created/deleted through the API.")
    public void taskDeleteTest() {
        new LogInPage()
                .logIn(USERNAME, PASSWORD);


        String name = "project YS";
        projectId = String.valueOf(projectApiSteps.createProject(name));
        System.out.println(projectId);

        LinkProjectApiSteps linkProjectApiSteps = new LinkProjectApiSteps();
        Boolean linkProject = linkProjectApiSteps.linkProject(projectId, userId);
        System.out.println(linkProject);

        String formId = RandomStringUtils.randomAlphabetic(10);
        new DashboardPage()
                .createProject("Project 6", formId).toString();
        System.out.println("Project with projectId: " + projectId);

        String randomTaskName = "TASK_" + RandomStringUtils.randomAlphabetic(10);
        new ProjectPage()
                .createTask(randomTaskName);
        System.out.println("Task name is: " + randomTaskName);

        new TaskPage()
                .deleteTask();

        SelenideElement alertMessage = new TaskPage()
                .getAlertMessage();
        alertMessage.shouldBe(Condition.visible);
        alertMessage.shouldHave(Condition.text("No tasks found."));
        System.out.println("This task was deleted: " + randomTaskName);

    }

    @AfterMethod(alwaysRun = true)
    public void removeProjectAfterTest() {
        projectApiSteps.deleteProject(projectId);
    }

    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        userApiSteps.deleteUser(userId);
    }

}
