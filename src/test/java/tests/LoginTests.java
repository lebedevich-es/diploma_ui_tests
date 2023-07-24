package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("ui")
@Feature("Login")
@Owner("lebedevich-es")
public class LoginTests extends BaseTest {

    @Test
    @DisplayName("Log in with correct credentials")
    void successLoginTest() {
        step("Open Home Page", () -> {
            open("");
        });
        step("Decline cookies", () -> {
            loginPage.declineCookies();
        });
        step("Click 'Log in' button", () -> {
            loginPage.clickLoginButton();
        });
        step("Enter correct email", () -> {
            loginPage.setEmail(email);
        });
        step("Enter correct password", () -> {
            loginPage.setCorrectPassword(password);
        });
        step("Click 'Log in' button", () -> {
            loginPage.clickLoginButton();
        });
        step("Verify successful authorization", () -> {
            loginPage.checkSuccessLogin();
        });
    }

    @Test
    @DisplayName("Log in with incorrect password")
    void failedLoginTest() {
        step("Open Home Page", () -> {
            open("");
        });
        step("Decline cookies", () -> {
            loginPage.declineCookies();
        });
        step("Click 'Log in' button", () -> {
            loginPage.clickLoginButton();
        });
        step("Enter correct email", () -> {
            loginPage.setEmail(email);
        });
        step("Enter incorrect password", () -> {
            loginPage.setWrongPassword(wrongPassword);
        });
        step("Click 'Log in' button", () -> {
            loginPage.clickLoginButton();
        });
        step("Verify failed authorization", () -> {
            loginPage.checkFailedLogin();
        });
    }
}
