package main.model;

/**
 * Created by gijin on 2017-12-06.
 */
public class GameData extends Data {
    // constants for the game or persistent data
    // gamedata should be a wrapper class for the raw statistics

    String text = "initial text";



    // observer implementation...
    public String getNew() {
        return text;
    }

    // should use a JSON map or something, or a cache
    public void newValue(String newVal) {
        text = newVal;
    }
}
