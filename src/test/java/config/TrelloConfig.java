package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
    "classpath:config/${env}.properties",
    "classpath:config/remote.properties"
})
public interface TrelloConfig extends Config {
    @Key("api.baseURI")
    String baseURI();

    @Key("api.basePath")
    String basePath();

    @Key("ui.baseUrl")
    String baseUrl();

    @Key("ui.remoteUrl")
    String remoteUrl();

    @Key("ui.browser")
    String browser();

    @Key("ui.pageLoadStrategy")
    String pageLoadStrategy();

    @Key("ui.browserVersion")
    String browserVersion();

    @Key("ui.browserSize")
    String browserSize();
}
