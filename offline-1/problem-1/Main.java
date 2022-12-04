
import java.util.List;
import java.util.ArrayList;
import java.io.Console;

import personalcomputer.*;
import director.*;
import builder.*;
import component.ram.*;
import component.graphicscard.*;

class PCBuildOrderingRun {

    Console console;
    private List<PersonalComputer> built_pcs;
    private Director director;
    private PCBuilder current_pcbuilder;

    public PCBuildOrderingRun() {
        current_pcbuilder = null;
        console = System.console();
        built_pcs = new ArrayList<PersonalComputer>();
        director = new Director();
    }

    public void takeOrder() {
        String prompt = "Welcome to the PC Builder!\n"
                + "Type 'O': Order a new PC\n"
                + "Type 'R': Add RAM\n"
                + "Type 'G': Add Graphics Card\n"
                + "Type 'E': End Current Order\n"
                + "Type 'Q': Quit\n";

        while (true) {
            String order_code = console.readLine(prompt);
            if (order_code.equals("O")) {
                if (current_pcbuilder != null) {
                    System.out.println("Sorry. Finish building current PC.");
                } else {
                    orderNew();
                }
            }

            else if (order_code.equals("R")) {
                if (current_pcbuilder != null) {
                    orderRAM();
                } else {
                    System.out.println("No PC is being built.");
                }
            }

            else if (order_code.equals("G")) {
                if (current_pcbuilder != null) {
                    orderGraphicsCard();
                } else {
                    System.out.println("No PC is being built.");
                }
            }

            else if (order_code.equals("E")) {
                if (current_pcbuilder != null) {
                    endOrder();
                } else {
                    System.out.println("No PC is being built.");
                }
            }

            else if (order_code.equals("Q")) {
                if (current_pcbuilder != null) {
                    System.out.println("Sorry. Finish building current PC.");
                } else {
                    break;
                }
            }

            else {
                System.out.println("Invalid order code");
            }
            System.out.println();
        }
    }

    public void orderNew() {
        String prompt = "What kind of PC do you want to build?\n"
                + "Type 1: Gaming PC\n"
                + "Type 2: Second Type PC\n"
                + "Type 3: Third Type PC\n"
                + "Type 4: Fourth Type PC\n";
        String pc_code = console.readLine(prompt);
        if (pc_code.equals("1")) {
            current_pcbuilder = new GamingPCBuilder();
        } else if (pc_code.equals("2")) {
            current_pcbuilder = new TypeOnePCBuilder();
        } else if (pc_code.equals("3")) {
            current_pcbuilder = new TypeTwoPCBuilder();
        } else if (pc_code.equals("4")) {
            current_pcbuilder = new TypeThreePCBuilder();
        } else {
            System.out.println("Invalid PC code. Try again.");
        }
    }

    public void orderRAM() {
        String prompt = "What kind of RAM do you want to add?\n"
                + "Type 1: 2666 MHz 8GB DDR4\n"
                + "Type 2: 3200 MHz 9GB DDR4\n";

        String ram_code = console.readLine(prompt);

        if (ram_code.equals("1")) {
            current_pcbuilder.addRAM(new RAM2666());
        }

        else if (ram_code.equals("2")) {
            current_pcbuilder.addRAM(new RAM3200());
        }

        else {
            System.out.println("Invalid RAM code. Try again.");
        }
    }

    public void orderGraphicsCard() {
        String prompt = "What kind of Graphics Card do you want to add?\n"
                + "Type 1: 2GB Graphics Card\n"
                + "Type 2: 4GB Graphics Card\n";
        String graphics_card_code = console.readLine(prompt);

        if (graphics_card_code.equals("1")) {
            current_pcbuilder.addGraphicsCard(new GraphicsCardM2());
        }

        else if (graphics_card_code.equals("2")) {
            current_pcbuilder.addGraphicsCard(new GraphicsCardM4());
        }

        else {
            System.out.println("Invalid Graphics Card code. Try again.");
        }
    }

    public void endOrder() {
        String prompt = "Congratulations! Your PC is ready.\n";
        console.printf("%s", prompt);

        director.construct(current_pcbuilder);
        built_pcs.add(current_pcbuilder.getPersonalComputer());
        current_pcbuilder = null;
    }

    public void showBuiltPCs() {
        for (PersonalComputer pc : built_pcs) {
            String divider = "----------------------------------------";
            System.out.println(divider);
            pc.show();
            System.out.println();
        }
    }

}

public class Main {
    public static void main(String[] args) {
        PCBuildOrderingRun build_order = new PCBuildOrderingRun();
        build_order.takeOrder();
        build_order.showBuiltPCs();
    }
}