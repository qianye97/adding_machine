package main.model;

import main.service.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * 导线
 */
public class Wire {
    private int signal;
    private List<Action> actions;
    private String name;

    public Wire() {
        signal = 0;
        actions = new ArrayList<>();
    }

    public Wire(String name) {
        signal = 0;
        actions = new ArrayList<>();
        this.name = name;
    }
    public void acceptAction(Action action) {
        actions.add(action);
    }

    public Integer getSignal() {
        return signal;
    }

    public void setSignal(int signal)  {
        this.signal = signal;
        //consume all action
        for(Action action : actions) {
            action.action();
        }
    }

    public String getName() {
        return this.name;
    }
}
