package state;

import context.*;

public class YellowState implements State {

    TrafficContext trafficContext;

    public YellowState(TrafficContext trafficContext) {
        this.trafficContext = trafficContext;
    }

    @Override
    public void switchLight() {
        System.out.println("Yellow light.Waiting for 2 seconds");
        try {
            Thread.sleep(2000, 0);
        } catch (Exception e) {
            System.out.println("Exception");
        }

        trafficContext.setState(trafficContext.getGreenState());
    }
}