package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PlaylistPage {

    private final SelenideElement
            createPlaylistOrFolderButton = $("button[aria-label='Create playlist or folder']"),
            createPlaylistButton = $$("button[role='menuitem']").first(),
            playlistImage = $("div[data-testid='playlist-image']"),
            searchInput = $$("input[placeholder='Search for songs or episodes']").last(),
            searchPlaylistInput = $("input[placeholder='Search in Your Library']"),
            addButton = $$("button[data-testid='add-to-playlist-button']").first(),
            trackName = $("a[data-testid='internal-track-link'] div"),
            menuButton = $("button[data-testid='more-button']"),
            editDetailsButton = $$("button[role='menuitem']").findBy(Condition.text("Edit details")),
            deleteButton = $$("button[role='menuitem']").findBy(Condition.text("Delete")),
            deleteModal = $("p[data-testid='confirm-dialog-description']"),
            deleteButtonInDeleteModal = $$("button[data-encore-id='buttonPrimary']").last(),
            playlistName = $("span[data-testid='entityTitle'] h1"),
            noSearchResult = $("div[data-testid='no-search-results-view']"),
            nameInput = $("input[data-testid='playlist-edit-details-name-input']"),
            descriptionInput = $("textarea[data-testid='playlist-edit-details-description-input']"),
            saveButton = $("button[data-testid='playlist-edit-details-save-button']");

    public PlaylistPage clickCreatePlaylistButton() {
        createPlaylistOrFolderButton.click();
        createPlaylistButton.click();
        return this;
    }

    public PlaylistPage checkPlaylistImageIsVisible() {
        playlistImage.shouldBe(Condition.visible);
        return this;
    }

    public PlaylistPage setValueInSearchInput(String value) {
        searchInput.setValue(value).pressEnter();
        return this;
    }

    public PlaylistPage clickAddButton() {
        addButton.click();
        return this;
    }

    public PlaylistPage checkAddedSongToPlaylist(String value) {
        trackName.shouldHave(Condition.text(value));
        return this;
    }

    public PlaylistPage clickMenuButton() {
        menuButton.click();
        return this;
    }

    public PlaylistPage clickEditDetailsButton() {
        editDetailsButton.click();
        return this;
    }

    public PlaylistPage clickDeleteButton() {
        deleteButton.click();
        return this;
    }

    public PlaylistPage checkDeleteModalIsVisible() {
        deleteModal.shouldBe(Condition.visible);
        return this;
    }

    public PlaylistPage clickDeleteButtonInDeleteModal() {
        deleteButtonInDeleteModal.click();
        return this;
    }

    public String getPlaylistName() {
        return playlistName.getText();
    }

    public PlaylistPage setValueToSearchPlaylistInput(String value) {
        searchPlaylistInput.setValue(value);
        return this;
    }

    public PlaylistPage checkNoSearchResultIsVisible() {
        noSearchResult.shouldBe(Condition.visible);
        return this;
    }

    public PlaylistPage checkPlaylistName(String value) {
        playlistName.shouldBe(Condition.text(value));
        return this;
    }

    public PlaylistPage updateInfoInEditDetailsModal(String title, String description) {
        nameInput.setValue(title);
        descriptionInput.setValue(description);
        saveButton.click();
        return this;
    }
}
