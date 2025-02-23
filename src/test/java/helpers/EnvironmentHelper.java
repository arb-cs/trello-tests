package helpers;

import config.Auth;
import config.Trello;

public final class EnvironmentHelper {
    private EnvironmentHelper() {
    }

    // API config
    public static final String key = System.getProperty("key", Auth.config.key());
    public static final String token = System.getProperty("token", Auth.config.token());
    public static final String baseURI = System.getProperty("baseURI", Trello.config.baseURI());
    public static final String basePath = System.getProperty("basePath", Trello.config.basePath());

    // UI config
    public static final String username = System.getProperty("username", Auth.config.username());
    public static final String password = System.getProperty("password", Auth.config.password());
    public static final String remote = System.getProperty("remote", Trello.config.remoteUrl());
    public static final String baseUrl = System.getProperty("baseUrl", Trello.config.baseUrl());
    public static final String browser = System.getProperty("browser", Trello.config.browser());
    public static final String browserVersion = System.getProperty("browserVersion", Trello.config.browserVersion());
    public static final String browserSize = System.getProperty("browserSize", Trello.config.browserSize());
    public static final String pageLoadStrategy = System.getProperty("pageLoadStrategy", Trello.config.pageLoadStrategy());

    // Remote run
    public static final boolean isRemote = remote.isBlank();
}
