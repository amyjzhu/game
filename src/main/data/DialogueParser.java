package main.data;

import main.Application;
import main.model.events.Action;
import main.model.events.GameEvent;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

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
            type="{\"title\":\"Sample_Event\",\"description\":\"Amy sits on the bus and writes this sample event\",\"script\":[{\"text\":\"Hello\"},{\"text\":\"Sure is snowing out there\"},{\"action\":\"switchCharacter\",\"arguments\":[\"Amy\",\"openLaptop.png\"]},{\"text\":\"Oh, do you want to see what I'm working on?\"}],\"character\":\"Amy\",\"priority\":\"0\",\"type\":\"Everyday\",\"prerequisites\":\"\",\"choices\":[{\"Forward\":\"Amy-01-Show_Work\"},{\"Reserved\":\"Amy-01-Continue_Chatting\"},{\"...\":\"Amy-01-Confused\"}]}"; //want it to compile haha but we should really serialize the


            JSONObject toParse = new JSONObject(type);
            JSONArray scriptEvents = toParse.getJSONArray("script");
            // for each, if text load up the text
            // if action grab a function

            // parse the method type and grab the function
            // get argument list for the method
            // get argument list and parse into objects
            // I want to make it extensible...


            if (type.equals("text")) {
                Method m = Reflection.getReflectionMethod(type);
                action = new Action(m);
                actions.add(action);
            }

            List<Action> allActions = new ArrayList<>();

            for (int i = 0; i < scriptEvents.length(); i++) {
                JSONObject value = scriptEvents.getJSONObject(i);
                Action currentAction;
                try {
                    String display = value.get("text").toString();
                    Method displayText = Reflection.getReflectionMethod("skfjdf");
                    currentAction = new Action(displayText);
                    currentAction.setArgs(new String[]{display});
                } catch (Exception e) {
                    String methodName = value.get("action").toString();
                    JSONArray arguments = value.getJSONArray("arguments");
                    List<Object> castArgs = parseArguments(arguments);
                    currentAction = new Action(Reflection.getFunctionsMethod(methodName));
                    currentAction.setArgs(castArgs.toArray()); // whoops...
                }

                allActions.add(currentAction);
            }


        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        return event;
    }

    private static List<Object> parseArguments(JSONArray arguments) {
        List<Object> castArgs = new ArrayList<>();
        // do something to match up the list of arguments
        for (int i = 0; i < arguments.length(); i++) {
            castArgs.add(arguments.get(i));
        }

        return castArgs;
    }


    private static <T extends Object> T parseArgument(String value, String className) throws ClassNotFoundException {
        // need special cases for enums
        // overwrite the cast method for those types

        Class<T> classType = (Class<T>) Class.forName(className);
        return classType.cast(value);
    }


    private static void populateArgumentList() {
        Map<String, String[]> arguments = new HashMap<>();
        Class functions = Functions.class;
        for(Method m : functions.getMethods()) {
            String[] args = (String[]) Arrays.stream(m.getParameterTypes()).map(
                    Class::toString).toArray();
            arguments.put(m.getName(), args); //could just leave as class and cast right away with type!
        }
    }


    // maybe I don't want to use GSON because I want to write a custome serializer

    //new Gson().newJsonReader(br);
//            Type theAction = new TypeToken<Serialized>();



    // text into objects. how can I get them to reference one another... maybe set it afterwards?
    // or just do a massive operation at the end - seems better...





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
