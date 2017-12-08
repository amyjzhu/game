package main.data;

import main.Application;
import main.model.events.GameEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by gijin on 2017-12-06.
 */
public class DialogueParser {

    public static final String BASE_URL = "resources/dialogue/";

    public static String load(String filePath) {
        File file = new File(BASE_URL + filePath);
        try {
            FileInputStream fis = new FileInputStream(file);

            StringBuffer result = new StringBuffer();
            int content = 0;
            while ((content = fis.read()) != -1) {
                result.append((char) content);
            }

            return result.toString().trim();
        } catch (FileNotFoundException e) {
            System.out.println("sad, no file at " + filePath + " or at " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void changeDisplayText(String value) {
        Application.getGameData().newValue(value);
        new GameEvent().run("replaceText");
    }

    public static void runScript(String script) {
        //Json
        new GameEvent().run(script);
    }

}
