package ui.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class TaskPage {

//    private final SelenideElement taskDropdown = $(byXpath("//body/section[1]/div[2]/div[2]/div[1]/div[1]/a[1]/strong[1]/i[1]"));

    private final SelenideElement taskDropdown = $(byXpath("//body/section[1]/div[2]/div[2]/div[1]/div[1]/a[1]"));

    private final SelenideElement taskRemoveMenu = $(byXpath("//body/div[@id='dropdown']/ul[1]/li[14]/a[1]"));

    private final SelenideElement modalConfirmButton = $("#modal-confirm-button");

    private final SelenideElement alertMessage = $("[class='alert']");

    private final SelenideElement taskAddCommentMenu = $(byXpath("//div[@id='dropdown']/ul[1]/li[7]/a[1]"));
    private final SelenideElement saveCommentButton = $(byXpath("//button[contains(text(),'Save')]"));
    private final SelenideElement commentText = $("div.text-editor-write-mode > textarea:nth-child(2)");


    @Step("User add new Comment to the New Task")
    public TaskPage deleteTask() {
        getTaskDropdown().click();
        getTaskRemoveMenu().click();
        getModalConfirmButton().click();
        getAlertMessage().getText();
        return new TaskPage();
    }


    @Step("User add new Comment to the New Task")
    public TaskPage addComment(String commentText) {
        getTaskDropdown().click();


        getSaveCommentButton().click();
        return new TaskPage();
    }


    public SelenideElement getTaskDropdown() {
        return taskDropdown;
    }

    public SelenideElement getTaskAddCommentMenu() {
        return taskAddCommentMenu;
    }

    public SelenideElement getSaveCommentButton() {
        return saveCommentButton;
    }

    public SelenideElement getCommentText() {
        return commentText;
    }

    public SelenideElement getTaskRemoveMenu() {
        return taskRemoveMenu;
    }

    public SelenideElement getModalConfirmButton() {
        return modalConfirmButton;
    }

    public SelenideElement getAlertMessage() {
        return alertMessage;
    }

}

