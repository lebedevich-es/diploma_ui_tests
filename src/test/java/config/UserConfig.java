package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface UserConfig extends Config {

    @Key("email")
    String getEmail();

    @Key("password")
    String getPassword();

    @Key("wrongPassword")
    String getWrongPassword();

}
