package main.model;

import main.Application;

/**
 * Created by gijin on 2017-12-06.
 */
public class Day {

    static int today;
    static Day day;

    private Day() {
        day = this;
    }

    public static Day getInstance() {
        if (day == null) {
            day = new Day();
        }
        return day;
    }

    public static void run() {
        getInstance().runDay();
    }


    public void runDay() {
        Application.getGameData().newValue(Integer.toString(today++));
        Application.update();
    }
}
