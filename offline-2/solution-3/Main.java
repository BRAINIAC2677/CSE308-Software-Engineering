import java.io.Console;

import state.*;
import vendingmachine.*;

public class Main {
    public static void main(String[] args) {

        Console console = System.console();
        int quantity = Integer.parseInt(console.readLine("Enter product quantity: "));
        int price = Integer.parseInt(console.readLine("Enter product price: "));

        VendingMachine vendingMachine = new VendingMachine(quantity, price);

        String prompt = "\n\nPay amount(press 'q' to quit):";
        while (true) {
            String input = console.readLine(prompt);
            if (input.equalsIgnoreCase("q") && (vendingMachine.getState() instanceof InitialState
                    || vendingMachine.getState() instanceof StockoutState)) {
                break;
            }
            int amount = Integer.parseInt(input);
            vendingMachine.pay(amount);
        }
    }
}
