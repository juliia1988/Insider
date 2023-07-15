package ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import ui.pageobjects.DashboardPage;
import ui.pageobjects.LogInPage;
import ui.pageobjects.ProjectPage;
import ui.pageobjects.TaskPage;

public class End2EndTest extends BaseTest {

    private final static String NAME = "Yuliia";
    private final static String PASS = "Yuliia";

    @Test
    @Description("Check that Project AND Task AND COMMENT createcd SUCCESFULLY")
    public void testEndToEndUiFlow() {
        new LogInPage()
                .logIn(NAME, PASS);

        String formId = RandomStringUtils.randomAlphabetic(10);
        SelenideElement commentText = new DashboardPage()
                .CreateProject("Project 6", formId).getComment();

        String randomTaskName = RandomStringUtils.randomAlphabetic(10);
        new ProjectPage()
                .createTask(randomTaskName);

        new TaskPage()
                .addComment("YS TEST COMMENT");

        new DashboardPage()
                .checkTaskComment();

        commentText.shouldBe(Condition.visible);
        commentText.shouldHave(Condition.partialText("commented")).getText();
    }
}
