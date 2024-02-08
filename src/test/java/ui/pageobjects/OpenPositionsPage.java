package ui.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OpenPositionsPage {

    private final SelenideElement filterByLocation = $("#select2-filter-by-location-container");
    private final SelenideElement filterByLocationInput = $("span ul:nth-child(1) li:nth-child(2)");
    private final SelenideElement filterByDepartment = $("#select2-filter-by-department-container");
    private final SelenideElement filterByDepartmentInput = $("span ul:nth-child(1) li:nth-child(15)");
    private final SelenideElement jobsList = $("[id='jobs-list']");

    private final SelenideElement titletOfDepartments = $("[id='jobs-list']>div:nth-child(1)");
    private final SelenideElement bannerCloseButton = $("[class='wt-cli-element medium cli-plugin-button wt-cli-accept-all-btn cookie_action_close_header cli_action_button']");

    private final SelenideElement viewRoleButton = $("#jobs-list > div:nth-child(1) > div > a");


    public SelenideElement getJobsList() {
        filterByLocation.click();
        filterByLocationInput.click();
        filterByDepartment.click();
        filterByDepartmentInput.click();
        return jobsList.scrollIntoView(true);
    }

    public SelenideElement getMainText() {
        return $("[class='col-12 text-center'] h3");
    }

    public SelenideElement getDepartment() {
        return titletOfDepartments;
    }

    public OpenPositionsPage closeBanner() {
        bannerCloseButton.click();
        return this;
    }

    public SelenideElement getViewRoleButton() {
        return viewRoleButton.scrollIntoView(true).hover();
    }

    public SelenideElement goToLevelApplicationPage() {
        viewRoleButton.hover().click();
        return new LevelApplicationPage().getApplyForThisJobButton();
    }

}
