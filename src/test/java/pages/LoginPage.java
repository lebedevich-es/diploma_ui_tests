package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement
            loginButton = $("[data-testid='login-button']"),
            usernameField = $("[data-testid='login-username']"),
            passwordField = $("[data-testid='login-password']"),
            avatar = $("[data-testid='user-widget-link']"),
            banner = $("[data-encore-id='banner']");

    public LoginPage setEmail(String email) {
        usernameField.setValue(email);
        return this;
    }

    public LoginPage setCorrectPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public LoginPage setWrongPassword(String wrongPassword) {
        passwordField.setValue(wrongPassword);
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public LoginPage checkSuccessLogin() {
        avatar.shouldBe(Condition.visible);
        return this;
    }

    public LoginPage checkFailedLogin() {
        banner.shouldBe(Condition.visible);
        return this;
    }
}
