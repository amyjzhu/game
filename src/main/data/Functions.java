package main.data;

import main.model.GameData;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by gijin on 2017-12-17.
 */
public class Functions {

    public static String CLASS_NAME = "main.data.Functions";


    // public static void all the possible functions
    // movements and statistics
    // generate a file that has all the names and argument types

    public static void addCharacter() {
        System.out.println("reached addCharacter!");

    }

    public static void moveCharacter() {

    }

    public static void incrementStat(GameData.StatsTypes s, int amt) {

    }

    public static void printTypes() throws ClassNotFoundException {
        Class thisClass = Class.forName(CLASS_NAME);
        Method[] methods = thisClass.getMethods();
        Map<String, String> methodParamMap = new HashMap<>();
        Arrays.stream(methods).forEach(
                method -> {
                    List<String> paramString = new ArrayList<>();
                    Class[] params = method.getParameterTypes();
                    Arrays.stream(params).forEach(
                            param -> {
                                paramString.add(param.toString());
                            }
                    );
                    methodParamMap.put(method.getName(),
                            paramString.toString());
                }
        );
        // how can I translate a list of types to types?
        // hmm... https://stackoverflow.com/questions/2408789/getting-class-type-from-string I guess
        // for now I'll just use their class names.

        System.out.println(methodParamMap.toString());
    }
}
