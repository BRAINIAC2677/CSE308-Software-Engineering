import adapter.*;
import crewmate.*;
import imposter.*;

public class Main {
    public static void main(String[] args) {
        Crewmate crewmate1 = new AstroCrewmate("Neil Armstrong");
        Crewmate crewmate2 = new EngineerCrewmate("Elon Musk");

        Imposter imposter1 = new KillerImposter("Jack the Ripper");
        Imposter imposter2 = new DamagingImposter("The Joker");

        crewmate1.contribute();
        crewmate2.contribute();

        imposter1.sabotage();
        imposter2.sabotage();

        Crewmate imposter1_as_crewmate = new ImposterAdapter(imposter1);
        Crewmate imposter2_as_crewmate = new ImposterAdapter(imposter2);

        imposter1_as_crewmate.contribute();
        imposter2_as_crewmate.contribute();
    }
}