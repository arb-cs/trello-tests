package config;

import org.aeonbits.owner.ConfigFactory;

public class Auth {
    private Auth() {
    }

    public static AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
}
