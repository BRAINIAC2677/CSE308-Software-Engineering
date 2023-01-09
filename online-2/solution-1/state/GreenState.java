package state;

import context.*;

public class GreenState implements State {

    TrafficContext trafficContext;

    public GreenState(TrafficContext trafficContext) {
        this.trafficContext = trafficContext;
    }

    @Override
    public void switchLight() {
        System.out.println("Green light.waiting for 10 seconds");
        try {
            Thread.sleep(10000, 0);
        } catch (Exception e) {
            System.out.println("Exception");
        }

        trafficContext.setState(trafficContext.getRedState());
    }
}