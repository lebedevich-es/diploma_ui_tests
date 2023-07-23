package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("browserName")
    @DefaultValue("CHROME")
    String getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    String getBrowserSize();

    @Key("baseUrl")
    @DefaultValue("https://open.spotify.com")
    String getBaseUrl();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("remoteUrl")
    String getRemoteUrl();

}
