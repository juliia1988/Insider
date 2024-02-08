package ui.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private final SelenideElement companyMenuItem = $("li:nth-child(6)");
    private final SelenideElement careerMenuItem = $("[href='https://useinsider.com/careers/']");


    public HomePage set() {
        return new HomePage();
    }

    public SelenideElement getMainText() {
        return $("[class ='col-9']");
    }

    public SelenideElement getCareerPage() {
        companyMenuItem.click();
        careerMenuItem.click();
        return new CareerPage().getMainText();

    }

}
