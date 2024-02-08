package ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pageobjects.LevelApplicationPage;
import ui.pageobjects.OpenPositionsPage;
import ui.pageobjects.QualityAssurancePage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class OpenPositionTest {
    private static final String OPEN_POSITION_URL = "https://useinsider.com/careers/open-positions/";

    @BeforeMethod
    public void openQaPage() {
        Configuration.browser = "chrome";
        Selenide.open(OPEN_POSITION_URL);
    }

    @Test
    @Description("The test is checking that Open Positions contain Quality Assurance department")
    public void testQualityAssuranceDepartmentExist() {

        SelenideElement jobsList = new OpenPositionsPage()
                .closeBanner()
                .getJobsList();

        SelenideElement department = new OpenPositionsPage()
                .getDepartment();

        jobsList.shouldBe(Condition.exist);
        jobsList.shouldBe(Condition.visible);
        department.shouldHave(Condition.partialText("Quality Assurance\n" +
                "Istanbul, Turkey"));
    }

    @Test
    @Description("The test is checking that screet is created in case test failed. Screenshot foulder: IdeaProjects/Insider/build/reports/tests/")
    public void testFailedWithScreenshot(){

        SelenideElement jobsList = new OpenPositionsPage()
                .closeBanner()
                .getJobsList();

        SelenideElement department = new OpenPositionsPage()
                .getDepartment();

        jobsList.shouldBe(Condition.exist);
        jobsList.shouldBe(Condition.visible);
        department.shouldHave(Condition.partialText("Failed Department Name"));
    }

    @Test
    @Description("The test is checking that Vieaw Role button appeared on Hover")
    public void testViewRoleButtonExist() {
        new OpenPositionsPage()
                .closeBanner()
                .getJobsList();

        SelenideElement buttonTitle = new OpenPositionsPage()
                .getViewRoleButton();
        buttonTitle.shouldBe(Condition.exist);
        buttonTitle.shouldHave(Condition.text("View Role"));
        buttonTitle.click();
    }

    @Test
    @Description("The test is checking that Vieaw Role button redirect to Level Application page")
    public void testViewRoleButtonRedirectToLevelApplicationPage() {

        testViewRoleButtonExist();

        SelenideElement applyButton = new LevelApplicationPage()
                .getApplyForThisJobButton();
        applyButton.shouldBe(Condition.exist);
        applyButton.shouldHave(Condition.text("APPLY FOR THIS JOB"));
    }

    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        closeWebDriver();
    }

}
