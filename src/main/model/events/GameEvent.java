package main.model.events;

import main.Application;
import main.model.Day;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by gijin on 2017-12-06.
 */
public class GameEvent {

    @FunctionalInterface
    public interface Animation {
        public void run();
    }

    Map<String, Animation> eventsMap;

    public GameEvent() {
        eventsMap = new HashMap<>();
        eventsMap.put("update",() -> Application.getGameData().newValue(Integer.toString(Day.getDay())));
        eventsMap.put("updateToText", () -> {Application.getGameData().newValue("Hey!"); Application.update();}); // not sure how to add params at this moment... maybe check a params thing? hm
        eventsMap.put("replaceText", () -> Application.update());
        eventsMap.put("crazyNumber", () -> {
            int rand = new Random().nextInt();
            Application.getGameData().newValue(Integer.toString(rand));
         Application.update();});
    }

    public void run(String animationTitle) {
        Animation animation = eventsMap.get(animationTitle.trim());
        if (animation != null) {
            animation.run();
        } // should throw an exception... but okay
        System.out.println(animationTitle);
    }

}
