package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:selenoid.properties"
})
public interface SelenoidConfig extends Config {

    @Key("selenoidUrl")
    String getSelenoidUrl();

    @Key("selenoidVideoUrl")
    String getSelenoidVideoUrl();

}
