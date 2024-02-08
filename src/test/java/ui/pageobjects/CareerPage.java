package ui.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CareerPage {

    private final SelenideElement mainText = $("[class ='big-title big-title-media mt-4 mt-lg-0']");
    private final SelenideElement teamsBlockItem = $("div:nth-child(1) > div.job-title.mt-0.mt-lg-2.mt-xl-5 > a > h3");
    private final SelenideElement locations = $("#career-our-location > div > div > div > div.col-12.col-md-6 > h3");
    private final SelenideElement lifeAtInsider = $("div.elementor-element.elementor-element-21cea83.elementor-widget.elementor-widget-heading > div > h2");


    public SelenideElement getMainText() {
        return mainText;
    }


    public SelenideElement getTeamsBlockItem() {
        return teamsBlockItem;
    }

    public SelenideElement getLocations() {
        return locations;
    }

    public SelenideElement getLifeAtInsider() {
        return lifeAtInsider;
    }
}
