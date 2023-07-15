package ui.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    private final SelenideElement projectTitle = $("[class='title']");
    private final SelenideElement projectDropdown = $(byXpath("//section[1]/div[1]/div[1]/div[1]/a[1]"));
    private final SelenideElement addNewTaskForm = $(byXpath("//div[@id='dropdown']/ul[1]/li[1]/a[1]"));
    private final SelenideElement projectAlert = $("[title='My projects'],[class='alert']");
    private final SelenideElement projectSummary = $(byXpath("//h2[contains(text(),'Summary')]"));

    private final SelenideElement comment = $(byXpath("//body/section[1]/section[1]/details[4]/div[1]/div[1]/div[2]/p[1]"));

    private final SelenideElement formTitle = $("#form-title");
    private final SelenideElement saveButton = $(byXpath("//form[1]/div[1]/div[4]/div[1]/div[1]/button[1]"));
    private final SelenideElement listMenu = $(byXpath("//section[1]/div[1]/div[2]/ul[1]/li[3]"));

    @Step("User Create new Task for Project")
    public TaskPage createTask(String taskTitle) {
        getProjectDropdown().shouldBe(Condition.visible).click();
        getAddNewTaskForm().click();
        getFormTitle().sendKeys(taskTitle);
        getSaveButton().click();
        getListMenu().click();
        return new TaskPage();
    }

    public SelenideElement getProjectDropdown() {
        return projectDropdown;
    }

    public SelenideElement getProjectAlert() {
        return projectAlert;
    }
    public SelenideElement getProjectSummary() {
        return projectSummary;
    }

    public SelenideElement getAddNewTaskForm() {
        return addNewTaskForm;
    }
    public SelenideElement getFormTitle() {
        return formTitle;
    }
    public SelenideElement getSaveButton() {
        return saveButton;
    }

    public SelenideElement getListMenu() {
        return listMenu;
    }
    public SelenideElement getProjectTitle() {
        return projectTitle;
    }

    public SelenideElement getComment() {
        return comment;
    }
}
