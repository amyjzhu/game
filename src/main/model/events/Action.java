package main.model.events;

import java.lang.reflect.Method;

/**
 * Created by gijin on 2017-12-09.
 */
public class Action {

    private Method call;
    private Object[] args;

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Action(Method call) {
        this.call = call;
    }

    public Method getCall() {
        return call;
    }

    public void setCall(Method call) {
        this.call = call;
    }
}
