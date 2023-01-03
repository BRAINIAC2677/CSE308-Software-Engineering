package subject;

import java.util.*;
import observer.Observer;
import state.*;

public class Server implements Subject {

    State operationalState;
    State partiallyDownState;
    State fullyDownState;
    State state;

    StateChange stateChange;

    private ArrayList<Observer> observers;

    public Server() {
        this.operationalState = new OperationalState(this);
        this.partiallyDownState = new PartiallyDownState(this);
        this.fullyDownState = new FullyDownState(this);
        this.state = operationalState;
        this.observers = new ArrayList<Observer>();
        this.stateChange = null;
    }

    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : this.observers) {
            o.update(this.stateChange);
        }
    }

    public void changeToOperational() {
        this.state.changeToOperational();
    }

    public void changeToPartiallyDown() {
        this.state.changeToPartiallyDown();
    }

    public void changeToFullyDown() {
        this.state.changeToFullyDown();
    }

    public State getOperationalState() {
        return operationalState;
    }

    public State getPartiallyDownState() {
        return partiallyDownState;
    }

    public State getFullyDownState() {
        return fullyDownState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setStateChange(StateChange stateChange) {
        this.stateChange = stateChange;
    }
}