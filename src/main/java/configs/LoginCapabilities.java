package configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("classpath:login.properties")
public interface LoginCapabilities extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("wrongpass")
    String wrongpass();

    @Key("wronglogin")
    String wronglogin();
}
