import java.util.ArrayList;
import java.io.Console;
import component.*;
import decorator.*;

public class Main {

    public static void main(String[] args) {
        int polyjuice_cnt = 1;
        int felix_cnt = 1;
        int veritaserum_cnt = 1;
        int skele_gro_cnt = 1;

        // take input
        Console console = System.console();
        polyjuice_cnt = Integer.parseInt(console.readLine("Polyjuice potions: "));
        felix_cnt = Integer.parseInt(console.readLine("Felix felicis potions: "));
        veritaserum_cnt = Integer.parseInt(console.readLine("Veritaserum potions: "));
        skele_gro_cnt = Integer.parseInt(console.readLine("Skele-gro potions: "));

        ArrayList<Component> polyjuices = new ArrayList<Component>();
        ArrayList<Component> felixes = new ArrayList<Component>();
        ArrayList<Component> veritaserums = new ArrayList<Component>();
        ArrayList<Component> skele_gros = new ArrayList<Component>();

        System.out.println("\n\nPolyjuice potions:");
        for (int i = 0; i < polyjuice_cnt; i++) {
            Component ms = new MakerSolution();
            Component polyjuice = new PoisonIvy(ms);
            polyjuices.add(polyjuice);
            polyjuice.show();
        }

        System.out.println("\n\nFelix felicis potions:");
        for (int i = 0; i < felix_cnt; i++) {
            Component ms = new MakerSolution();
            Component felix = new UnicornHorn(ms);
            felixes.add(felix);
            felix.show();
        }

        System.out.println("\n\nVeritaserum potions:");
        for (int i = 0; i < veritaserum_cnt; i++) {
            Component ms = new MakerSolution();
            Component veritaserum = new DragonKidney(ms);
            veritaserums.add(veritaserum);
            veritaserum.show();
        }

        System.out.println("\n\nSkele-gro potions:");
        for (int i = 0; i < skele_gro_cnt; i++) {
            Component ms = new MakerSolution();
            Component skele_gro = new ChineseChomping(ms);
            skele_gros.add(skele_gro);
            skele_gro.show();
        }
    }
}