package ui.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class  DashboardPage {

    private final SelenideElement projectTabMenu = $("[section.page:nth-child(2) section.sidebar-container div.sidebar ul:nth-child(1) li.active:nth-child(2) > a:nth-child(1)]");
    private final SelenideElement projectCreatetLink = $("ul:nth-child(1) li:nth-child(1) > a.js-modal-medium");
    private final SelenideElement formNameField = $("#form-name");
    private final SelenideElement formIdentifierField = $("#form-identifier");
    private final SelenideElement saveButton = $("button.btn.btn-blue:nth-child(1)");
    private final SelenideElement overviewMenu = $("[class='view-overview']");
    private final SelenideElement activityContent = $("[class='activity-content']");




    @Step("Open Project page")
    public ProjectPage openProjectPage() {
        getProjectTabMenu().click();
        return new ProjectPage();
    }

    @Step("User сreate New Project")
    public ProjectPage CreateProject(String formName, String formIdentifier) {
        getProjectCreatetLink().click();
        getFormNameField().sendKeys(formName);
        getFormIdentifierField().sendKeys(formIdentifier);
        getSaveButton().click();
        return new ProjectPage();
    }

    @Step("Check that Comment was added")
    public ProjectPage checkTaskComment () {
      getOverviewMenu().click();
      getActivityContent().shouldBe(Condition.visible);
        return new ProjectPage();
    }

    public SelenideElement getProjectTabMenu() {
        return projectTabMenu;
    }
    public SelenideElement getProjectCreatetLink() {
        return projectCreatetLink;
    }
    public SelenideElement getFormIdentifierField() {
        return formIdentifierField;
    }
    public SelenideElement getFormNameField() {
        return formNameField;
    }
    public SelenideElement getSaveButton() {
        return saveButton;
    }
    public SelenideElement mainTitle() {
        return $("[class = 'title']");
    }
    public SelenideElement getOverviewMenu() {
        return overviewMenu;
    }
    public SelenideElement getActivityContent() {
        return activityContent;
    }



}
