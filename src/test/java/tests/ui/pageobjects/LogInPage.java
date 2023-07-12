package tests.ui.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LogInPage {

    private final SelenideElement userNameField = $("#form-username");
    private final SelenideElement passwordField = $("#form-password");
    private final SelenideElement logInButton = $("[class = 'btn btn-blue']");


    @Step("The user logs in with valid creds [{0}, {1}]")
    public LogInPage logIn(String userName, String password) {
        getUserNameField().sendKeys(userName);
        getPasswordField().sendKeys(password);
        getLogInButton().click();
        return new LogInPage();
    }

    public SelenideElement getUserNameField() {
        return userNameField;
    }
    public SelenideElement getPasswordField() {
        return passwordField;
    }
    public SelenideElement getLogInButton() {
        return logInButton;
    }


}
