package observer;

import java.io.Console;
import subject.*;

public class RegularUser implements Observer {
    private String name;
    private Server server;
    private boolean hasTemporaryUpgrade;

    public RegularUser(String name, Server server) {
        this.name = name;
        this.server = server;
        this.server.registerObserver(this);
        this.hasTemporaryUpgrade = false;
    }

    @Override
    public void update(StateChange stateChange) {
        Console console = System.console();

        System.out.println("From Regular User " + this.name + ": Regular user " + name
                + " received notification of " + stateChange + " state change from server");

        if (stateChange == StateChange.Operation1ToPartiallyDown || stateChange == StateChange.Operation1ToFullyDown) {
            String response = console.readLine("From Regular User " + this.name
                    + ": Do you want to take service from DEF server($20 per hour)? (y/n): ");
            if (response.equals("y")) {
                this.hasTemporaryUpgrade = true;
                System.out.println("From Regular User " + this.name + ": Data copied to DEF server.");
            }
        } else if (stateChange == StateChange.PartiallyDownToOperation1
                || stateChange == StateChange.FullyDownToOperation1) {
            if (hasTemporaryUpgrade) {
                System.out.println("From Regular User " + this.name + ": Your bill is $x for temporary upgrade.");
                this.hasTemporaryUpgrade = false;
            }
        }
    }
}