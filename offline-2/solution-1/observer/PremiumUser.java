package observer;

import java.io.*;
import subject.*;

public class PremiumUser implements Observer {
    private String name;
    private String serverName;
    private Subject server;

    public PremiumUser(String name, Subject server) {
        this.name = name;
        this.server = server;
        this.server.registerObserver(this);
        this.serverName = "ABC";
    }

    @Override
    public void update(StateChange stateChange) {
        Console console = System.console();
        System.out.println("From Premium User " + this.name + ": Premium user " + name
                + " received notification of " + stateChange + " state change from server");

        if (stateChange == StateChange.Operation1ToPartiallyDown) {
            String response = console
                    .readLine("From Premium User " + this.name + ": Do you want to use two servers? (y/n): ");
            if (response.equals("y")) {
                this.serverName = "ABC and DEF";
            } else {
                this.serverName = "DEF";
            }
        } else if (stateChange == StateChange.Operation1ToFullyDown) {
            System.out.println(
                    "From Premium User " + this.name + ": Service now Provided by the server our partner DEF company.");
        } else if (stateChange == StateChange.PartiallyDownToFullyDown) {
            if (this.serverName.equals("ABC and DEF")) {
                this.serverName = "DEF";
                System.out.println("From Premium User " + this.name
                        + ": Service now shifted to the server of our partner DEF company.");
            }
        }
    }
}