package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
    "classpath:config/auth.properties"
})
public interface AuthConfig extends Config {
    @Key("api.key")
    String key();

    @Key("api.token")
    String token();

    @Key("ui.username")
    String username();

    @Key("ui.password")
    String password();
}
