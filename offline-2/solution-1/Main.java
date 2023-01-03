import java.io.*;
import subject.*;
import observer.*;

public class Main {
    public static void main(String[] args) {

        Server ABCServer = new Server();
        PremiumUser asif = new PremiumUser("asif", ABCServer);
        RegularUser akash = new RegularUser("akash", ABCServer);

        Console console = System.console();
        String prompt = "\nPress '0': To simulate Operational State\nPress '1': To simulate Partially Down State\nPress '2': To simulate Fully Down State\nPress 'q': To exit\n";

        while (true) {
            String response = console.readLine(prompt);
            if (response.equals("0")) {
                ABCServer.changeToOperational();
                ;
            } else if (response.equals("1")) {
                ABCServer.changeToPartiallyDown();
            } else if (response.equals("2")) {
                ABCServer.changeToFullyDown();
            } else if (response.equals("q")) {
                break;
            }
        }

    }
}