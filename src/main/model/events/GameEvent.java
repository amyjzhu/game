package main.model.events;

import main.Application;
import main.model.Day;

import java.util.HashMap;
import java.util.Map;

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
    }

    public void run(String animationTitle) {
        Animation animation = eventsMap.get(animationTitle);
        animation.run();
    }

}
