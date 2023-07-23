package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement
            searchInput = $("input[data-testid='search-input']"),
            topResultSection = $("div[data-testid='herocard-click-handler']"),
            noResultSection = $("div[id='searchPage'] p");

    public SearchPage setValueToSearchInput(String value) {
        searchInput.setValue(value);
        return this;
    }

    public SearchPage checkTopResultSectionIsVisible() {
        topResultSection.shouldBe(Condition.visible);
        return this;
    }

    public SearchPage checkNoResultSectionText(String text) {
        noResultSection.shouldHave(Condition.text(text));
        return this;
    }
}
