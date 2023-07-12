package tests.ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import tests.ui.pageobjects.DashboardPage;
import tests.ui.pageobjects.LogInPage;

public class ProjectCreateTest extends BaseTest {

    private final static String NAME = "Yuliia";
    private final static String PASS = "Yuliia";

    @Test
    @Description("Check the alert text exist if user has no available Projects")
    public void testCreateProject() {
        new LogInPage()
                .logIn(NAME, PASS);

        String formId = RandomStringUtils.randomAlphabetic(10);
        SelenideElement projectSummmaryText = new DashboardPage()
                .CreateProject("Project 2", formId).getProjectSummary();

        projectSummmaryText.shouldBe(Condition.visible);
        projectSummmaryText.shouldHave(Condition.text("Summary")).getText();
    }
}
