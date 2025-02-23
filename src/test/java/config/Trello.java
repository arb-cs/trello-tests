package config;

import org.aeonbits.owner.ConfigFactory;

public class Trello {
    private Trello() {
    }

    public static TrelloConfig config = ConfigFactory.create(TrelloConfig.class, System.getProperties());
}
