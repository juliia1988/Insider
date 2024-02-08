package ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.pageobjects.CareerPage;
import ui.pageobjects.HomePage;

public class CareerPageTest extends BaseTest {

    @Test
    @Description("The test is checking positive case that Career page is opened")
    public void testCatreerPageLoaded() {
        SelenideElement mainText = new HomePage()
                .getCareerPage();
        mainText.shouldBe(Condition.visible);
        mainText.shouldHave(Condition.text("Ready to disrupt? ")).getText();

    }

    @Test
    @Description("The test is checking that Location block is available on Career page")
    public void testLocationBlockOpened() {
        new HomePage()
                .getCareerPage();
        SelenideElement locationsTitle = new CareerPage()
                .getLocations();
        locationsTitle.shouldBe(Condition.visible);
        locationsTitle.shouldHave(Condition.text("Our Locations ")).getText();

    }

    @Test
    @Description("The test is checking that Teams block is available on Career page")
    public void testTeamsBlockOpened() {
        new HomePage()
                .getCareerPage();
        SelenideElement jobTitle = new CareerPage()
                .getTeamsBlockItem();
        jobTitle.shouldBe(Condition.visible);
        jobTitle.shouldHave(Condition.text("Customer Success")).getText();

    }

    @Test
    @Description("The test is checking that Life at Insider block is available on Career page")
    public void testLifeAtInsiderBlockOpened() {
        new HomePage()
                .getCareerPage();
        SelenideElement jobTitle = new CareerPage()
                .getLifeAtInsider();
        jobTitle.shouldBe(Condition.visible);
        jobTitle.shouldHave(Condition.text("Life at Insider")).getText();

    }

}
