package main.data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gijin on 2017-12-17.
 */
public class Reflection {


    static Map<String, Class[]> eventsToArguments;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // take in the name
        //Class[] params = new Class[]{Integer.TYPE, Integer.TYPE};
        Class[] params = new Class[]{Integer.TYPE, Integer.TYPE};
        eventsToArguments = new HashMap<>();
        eventsToArguments.put("add", params);

        Class theClass = Class.forName("main.data.Reflection");
        Object[] argus = new Object[]{2, 3};
        Method m = theClass.getMethod("add", params);
        Object inst = theClass.newInstance();
        Object ret = m.invoke(inst, argus);
        System.out.println(ret.toString());

        Functions.printTypes();
    }

    // need two classes to handle stats and


    public int add(int a, int b) {
        return a + b;
    }


    // functional interface loaded with arguments already?
    public static Method getMethod(String methodName) {
        Method m = null;
        Class theClass = null;
        try {
            theClass = Class.forName("main.data.Reflection");
            Class[] params = eventsToArguments.get(methodName);
            m = theClass.getMethod(methodName, params);
            Object inst = theClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return m;
    }

    public static Class[] getArgumentTypes(String[] types) {
        return Arrays.stream(types).map(Reflection::getClass).toArray(Class[]::new);
    }

    private static Class getClass(String name) {
        // lmao check this out
        try {
            if (name.startsWith("class")) {
                name = name.substring(5); // get rid of "class "
            }
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Is there really a class for the name " + name +"?");
        }
    }
}
