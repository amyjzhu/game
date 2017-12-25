package main.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.Application;
import main.model.events.Action;
import main.model.events.GameEvent;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gijin on 2017-12-06.
 */

public class DialogueParser {

    // populate game data from a file
    //

    public static GameEvent createEvent() {
        // read each line and parse into an action
        // choices into fork
        // conversation is full actions sequence

        GameEvent event = new GameEvent();
        List<Action> actions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(""))) {
            String line = br.readLine();
            // GSON?
            Action action;
            String type;

            new Gson().newJsonReader(br);
            Type theAction = new TypeToken<>

            type="text"; //want it to compile haha but we should really serialize the
            // text into objects. how can I get them to reference one another... maybe set it afterwards?
            // or just do a massive operation at the end - seems better...
            if (type.equals("text")) {
                Method m = Reflection.getMethod(type);
                action = new Action(m);
                actions.add(action);
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        return event;
    }








    // ===================================

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

    public static void loadEvent(String line) {
        // hmmm..
        GameEvent.class.getMethods();
    }

}
