package ui.pageobjects;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LevelApplicationPage {

    private final SelenideElement applyForThisJobButton = $("body > div.content-wrapper.posting-page > div > div.section-wrapper.accent-section.page-full-width > div > div.postings-btn-wrapper > a");

    public SelenideElement getApplyForThisJobButton() {
        switchTo().window(1);
        return applyForThisJobButton;
    }

}