package state;

import subject.*;

public class OperationalState implements State {
    Server server;

    public OperationalState(Server server) {
        this.server = server;
    }

    @Override
    public void changeToOperational() {

    }

    @Override
    public void changeToPartiallyDown() {
        server.setStateChange(StateChange.Operation1ToPartiallyDown);
        server.setState(server.getPartiallyDownState());
        server.notifyObservers();
    }

    @Override
    public void changeToFullyDown() {
        server.setStateChange(StateChange.Operation1ToFullyDown);
        server.setState(server.getFullyDownState());
        server.notifyObservers();
    }

}