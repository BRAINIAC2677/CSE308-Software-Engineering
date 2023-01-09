package context;

import state.*;

public class TrafficContext {

    State state;
    State redState, greenState, yellowState;

    public TrafficContext() {
        redState = new RedState(this);
        greenState = new GreenState(this);
        yellowState = new YellowState(this);
        state = redState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public State getRedState() {
        return redState;
    }

    public State getGreenState() {
        return greenState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public void startTrafficLight() {
        while (true) {
            state.switchLight();
        }
    }

}