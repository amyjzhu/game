package main;

import main.model.Day;
import main.model.GameData;
import main.ui.Window;

/**
 * Created by gijin on 2017-12-06.
 */
public class Application {

    static Window mainWindow;
    static GameData data;

    public static void main(String[] args) throws InterruptedException {
        mainWindow = new Window();
        data = new GameData();

        while (true) {
            Day.run();
            Thread.sleep(2000);
        }
    }

    public static void update() {
        String text = data.getNew();
        mainWindow.update(text);
    }

    public static GameData getGameData() {
        return data;
    }
}
