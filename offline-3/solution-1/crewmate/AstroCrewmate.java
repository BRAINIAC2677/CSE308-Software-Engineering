package crewmate;

public class AstroCrewmate implements Crewmate {
    private String name;

    public AstroCrewmate(String _name) {
        this.name = _name;
    }

    @Override
    public void contribute() {
        System.out.println(this.name + " is studying intersteller objects.");
    }
}