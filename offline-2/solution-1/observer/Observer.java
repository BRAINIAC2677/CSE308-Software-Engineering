package observer;

import subject.*;

public interface Observer {
    public void update(StateChange stateChange);
}