package state;

import subject.*;

public class PartiallyDownState implements State {
    Server server;

    public PartiallyDownState(Server server) {
        this.server = server;
    }

    @Override
    public void changeToOperational() {
        server.setStateChange(StateChange.PartiallyDownToOperation1);
        server.setState(server.getOperationalState());
        server.notifyObservers();
    }

    @Override
    public void changeToPartiallyDown() {

    }

    @Override
    public void changeToFullyDown() {
        server.setStateChange(StateChange.PartiallyDownToFullyDown);
        server.setState(server.getFullyDownState());
        server.notifyObservers();
    }

}