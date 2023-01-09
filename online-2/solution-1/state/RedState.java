package state;

import context.*;

public class RedState implements State {

    TrafficContext trafficContext;

    public RedState(TrafficContext trafficContext) {
        this.trafficContext = trafficContext;
    }

    @Override
    public void switchLight() {
        System.out.println("Red light.Waiting for 5 seconds");
        try {
            Thread.sleep(5000, 0);
        } catch (Exception e) {
            System.out.println("Exception");
        }
        trafficContext.setState(trafficContext.getYellowState());
    }
}