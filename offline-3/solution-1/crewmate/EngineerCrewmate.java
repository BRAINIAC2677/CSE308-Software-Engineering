package crewmate;

public class EngineerCrewmate implements Crewmate {
    private String name;

    public EngineerCrewmate(String _name) {
        this.name = _name;
    }

    @Override
    public void contribute() {
        System.out.println(this.name + " is fixing the spaceship.");
    }
}