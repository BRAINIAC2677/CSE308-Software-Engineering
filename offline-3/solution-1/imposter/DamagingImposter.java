package imposter;

public class DamagingImposter implements Imposter {
    private String name;

    public DamagingImposter(String _name) {
        this.name = _name;
    }

    @Override
    public void sabotage() {
        System.out.println(this.name + " is secretly damaging the spaceship.");
    }
}