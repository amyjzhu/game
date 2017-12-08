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

    public static void load(String filePath) {
        File file = new File(BASE_URL + filePath);
        try {
            FileInputStream fis = new FileInputStream(file);

            StringBuffer result = new StringBuffer();
            int content = 0;
            do {
                content = fis.read();
                result.append((char) content);
            } while (content != -1);

            Application.getGameData().newValue(result.toString().trim());
            new GameEvent().run("replaceText");

        } catch (FileNotFoundException e) {
            System.out.println("sad, no file at " + filePath + " or at " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
