package ui.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class QualityAssurancePage {

    private final SelenideElement seeAllQaJobsButton = $("[class='btn btn-outline-secondary rounded text-medium mt-2 py-3 px-lg-5 w-100 w-md-50']");
    private final SelenideElement bannerCloseButton = $("[class='wt-cli-element medium cli-plugin-button wt-cli-accept-all-btn cookie_action_close_header cli_action_button']");


    public SelenideElement getAllQaJobsButton() {
        seeAllQaJobsButton.click();
        return new OpenPositionsPage().goToLevelApplicationPage();
    }

    public QualityAssurancePage closeBanner() {
        bannerCloseButton.click();
        return this;
    }
}

