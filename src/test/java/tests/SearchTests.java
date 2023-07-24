package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("ui")
@Feature("Search")
@Owner("lebedevich-es")
public class SearchTests extends BaseTest {

    static SearchPage searchPage = new SearchPage();
    private final String noResultText = "Please make sure your words are spelled correctly, " +
            "or use fewer or different keywords.";

    @ValueSource(strings = {
            "Nizkiz",
            "Nemiga",
            "Naviband"
    })
    @DisplayName("Check search: ")
    @ParameterizedTest(name = "Verify that 'Top result' section is displayed for value: {0}")
    void searchTest(String title) {
        step("Open Search Page", () -> {
            open("/search");
        });
        step("Decline cookies", () -> {
            loginPage.declineCookies();
        });
        step("Enter '" + title + "' in the search input", () -> {
            searchPage.setValueToSearchInput(title);
        });
        step("Verify that 'Top Result' section is displayed", () -> {
            searchPage.checkTopResultSectionIsVisible();
        });
    }

    @Test
    @DisplayName("Verify that 'No Result' is displayed")
    void searchNoResultTest() {
        step("Open Search Page", () -> {
            open("/search");
        });
        step("Decline cookies", () -> {
            loginPage.declineCookies();
        });
        step("Enter '-' in the search input", () -> {
            searchPage.setValueToSearchInput(" ");
        });
        step("Verify 'No Result' text is displayed", () -> {
            searchPage.checkNoResultSectionText(noResultText);
        });
    }
}
