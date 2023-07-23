package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PlaylistPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("ui")
@Feature("Playlist")
@Owner("lebedevich-es")
public class PlaylistTests extends BaseTest {
    private String playlistName = "";

    static PlaylistPage playlistPage = new PlaylistPage();

    @Test
    @DisplayName("Create a new playlist")
    void createNewPlaylistTest() {
        step("Open Home Page", () -> {
            open("");
        });
        step("Login with correct credentials", () -> {
            loginPage.clickLoginButton()
                    .setEmail(email)
                    .setCorrectPassword(password)
                    .clickLoginButton();
        });
        step("Create new playlist", () -> {
            playlistPage.clickCreatePlaylistButton();
        });
        step("Verify that new playlist is created", () -> {
            playlistPage.checkPlaylistImageIsVisible();
        });
    }

    @Test
    @DisplayName("Add song to playlist")
    void addSongToPlaylistTest() {
        step("Open Home Page", () -> {
            open("");
        });
        step("Login with correct credentials", () -> {
            loginPage.clickLoginButton()
                    .setEmail(email)
                    .setCorrectPassword(password)
                    .clickLoginButton();
        });
        step("Create new playlist", () -> {
            playlistPage.clickCreatePlaylistButton();
        });
        step("Set value to search input", () -> {
            playlistPage.setValueInSearchInput("hero");
        });
        step("Add track to playlist", () -> {
            playlistPage.clickAddButton();
        });
        step("Verify that track is added to playlist", () -> {
            playlistPage.checkAddedSongToPlaylist("hero");
        });
    }

    @Test
    @DisplayName("Remove playlist")
    void removePlaylistTest() {
        step("Open Home Page", () -> {
            open("");
        });
        step("Login with correct credentials", () -> {
            loginPage.clickLoginButton()
                    .setEmail(email)
                    .setCorrectPassword(password)
                    .clickLoginButton();
        });
        step("Create new playlist", () -> {
            playlistPage.clickCreatePlaylistButton();
            playlistName = playlistPage.getPlaylistName();
        });
        step("Remove playlist from profile", () -> {
            playlistPage.clickMenuButton()
                    .clickDeleteButton()
                    .checkDeleteModalIsVisible()
                    .clickDeleteButtonInDeleteModal();
        });
        step("Verify that playlist is removed", () -> {
            playlistPage.setValueToSearchPlaylistInput(playlistName)
                    .checkNoSearchResultIsVisible();
        });
    }

    @Test
    @DisplayName("Edit playlist info")
    @Disabled
    @Issue("Error: Error fetching playlist via GraphQL!")
    void editPlaylistInfoTest() {
        step("Open Home Page", () -> {
            open("");
        });
        step("Login with correct credentials", () -> {
            loginPage.clickLoginButton()
                    .setEmail(email)
                    .setCorrectPassword(password)
                    .clickLoginButton();
        });
        step("Create new playlist", () -> {
            playlistPage.clickCreatePlaylistButton();
        });
        step("Open 'Edit details' modal", () -> {
            playlistPage.clickMenuButton()
                    .clickEditDetailsButton();
        });
        step("Add description for playlist info", () -> {
            playlistPage.updateInfoInEditDetailsModal("PLAYLIST", "DESCRIPTION FOR PLAYLIST");
        });
        step("Verify that playlist info is updated", () -> {
            playlistPage.checkPlaylistName("PLAYLIST");
        });
    }
}
