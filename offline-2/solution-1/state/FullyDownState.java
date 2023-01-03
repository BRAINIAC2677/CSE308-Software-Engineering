package state;

import subject.*;

public class FullyDownState implements State {
    Server server;

    public FullyDownState(Server server) {
        this.server = server;
    }

    @Override
    public void changeToOperational() {
        server.setStateChange(StateChange.FullyDownToOperation1);
        server.setState(server.getOperationalState());
        server.notifyObservers();
    }

    @Override
    public void changeToPartiallyDown() {
        server.setStateChange(StateChange.FullyDownToPartiallyDown);
        server.setState(server.getPartiallyDownState());
        server.notifyObservers();
    }

    @Override
    public void changeToFullyDown() {

    }

}