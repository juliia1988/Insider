package ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pageobjects.QualityAssurancePage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class QualityAssurancePageTest {

    private static final String QA_PAGE_URL = "https://useinsider.com/careers/quality-assurance/";

    @BeforeMethod
    public void openQaPage() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Selenide.open(QA_PAGE_URL);
    }

    @Test
    @Description("The test is checking positive case that Assuranc page is opened and Apply button is visible")
    public void testQualityAssurancePageOpened() {
        SelenideElement maiText = new QualityAssurancePage()
                .closeBanner()
                .getAllQaJobsButton();
        maiText.shouldBe(Condition.visible);
        maiText.shouldHave(Condition.text("APPLY FOR THIS JOB"));

    }


    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        closeWebDriver();
    }

}

