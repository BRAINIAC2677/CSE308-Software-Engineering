package imposter;

public class KillerImposter implements Imposter {
    private String name;

    public KillerImposter(String _name) {
        this.name = _name;
    }

    @Override
    public void sabotage() {
        System.out.println(this.name + " is plotting to poison crewmates.");
    }
}