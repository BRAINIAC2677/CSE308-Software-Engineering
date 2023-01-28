import java.io.Console;

import coffe.*;
import coffe_factory.*;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        order.take_order();
    }
}

class Order {
    CoffeFactory coffeFactory;
    private int[] ordered_coffe_count;
    private CoffeVariant[] coffeVariants;

    public Order() {
        coffeFactory = new CoffeFactory();
        ordered_coffe_count = new int[4];
        coffeVariants = new CoffeVariant[] { CoffeVariant.Americano, CoffeVariant.Espresso, CoffeVariant.Cappuccino,
                CoffeVariant.Mocha };
    }

    public void take_order() {
        Console console = System.console();
        String prompt = "Press 1: Americano\n"
                + "Press 2: Espresso\n"
                + "Press 3: Cappuccino\n"
                + "Press 4: Mocha\n"
                + "Press 5: Place Order\n"
                + "Press 6: Quit\n";
        while (true) {
            // print current order
            System.out.println("Current Order:");
            System.out.println("Americano: " + ordered_coffe_count[0]);
            System.out.println("Espresso: " + ordered_coffe_count[1]);
            System.out.println("Cappuccino: " + ordered_coffe_count[2]);
            System.out.println("Mocha: " + ordered_coffe_count[3]);

            // take order
            String order_code = console.readLine(prompt);
            if (order_code.equals("1")) {
                ordered_coffe_count[0]++;
            } else if (order_code.equals("2")) {
                ordered_coffe_count[1]++;
            } else if (order_code.equals("3")) {
                ordered_coffe_count[2]++;
            } else if (order_code.equals("4")) {
                ordered_coffe_count[3]++;
            } else if (order_code.equals("5")) {
                place_order();
            } else if (order_code.equals("6")) {
                break;
            } else {
                System.out.println("Invalid order code");
            }
            System.out.println();
        }
    }

    public void place_order() {
        System.out.println("====================================");
        System.out.println("Order Placed. Here is your order and bill\n");
        int total_cost = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < ordered_coffe_count[i]; j++) {
                Coffe coffe = coffeFactory.make_coffe(coffeVariants[i]);
                System.out.println(coffeVariants[i] + " coffe ingredients:");
                coffe.print_ingredients();
                System.out.println("Cost: " + coffe.get_cost() + " taka\n");
                total_cost += coffe.get_cost();
            }
            ordered_coffe_count[i] = 0;
        }
        System.out.println("Total Cost: " + total_cost + " taka");
        System.out.println("====================================");
    }
}