package tests.ui.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class TaskPage {

    private final SelenideElement taskDropdown = $(byXpath("//body/section[1]/div[2]/div[2]/div[1]/div[1]/a[1]/strong[1]/i[1]"));

    private final SelenideElement taskAddCommentMenu = $(byXpath("//div[@id='dropdown']/ul[1]/li[7]/a[1]"));

    private final SelenideElement saveCommentButton = $(byXpath("//button[contains(text(),'Save')]"));
    private final SelenideElement commentText = $("div.text-editor-write-mode > textarea:nth-child(2)");


    @Step("User add new Comment to the New Task")
    public TaskPage addComment(String commentText) {
        getTaskDropdown().click();
        getTaskAddCommentMenu().click();
        getCommentText().sendKeys(commentText);
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

}

