package component;

public class EmployeeComponent extends Component {
    private Role role;
    private String current_project;

    public EmployeeComponent(String _name, Role _role, String _current_project) {
        super(_name);
        this.role = _role;
        this.current_project = _current_project;
    }

    @Override
    public void details() {
        System.out.println(
                "Name: " + this.get_name() + "\nRole: " + this.role + "\nCurrent Project: " + this.current_project
                        + "\nNumber of Supervisees: " + this.get_subordinates_count());
    }

    @Override
    public void hierarchy(int _depth) {
        for (int i = 0; i < _depth; i++) {
            System.out.print("  ");
        }
        if (this.role == Role.Project_manager) {
            System.out.println("- " + this.get_name() + " (" + this.current_project + ")");
        } else {
            System.out.println("- " + this.get_name());
        }
        for (Component child : this.children) {
            child.hierarchy(_depth + 1);
        }
    }

    @Override
    public boolean add(Component _child) {
        if ((!this.children.contains(_child)) && (this.role == Role.Project_manager)
                && (_child instanceof EmployeeComponent)) {
            if (((EmployeeComponent) _child).role == Role.Developer) {
                this.children.add(_child);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Component _child) {
        if (this.children.contains(_child)) {
            _child.remove_all();
            this.children.remove(_child);
            return true;
        }
        return false;
    }

    @Override
    public void remove_all() {
        for (Component child : this.children) {
            child.remove_all();
        }
        this.children.clear();
    }

    public int get_subordinates_count() {
        return this.children.size();
    }

    public Role get_role() {
        return this.role;
    }

    public String get_current_project() {
        return this.current_project;
    }

    public void set_current_project(String _current_project) {
        this.current_project = _current_project;
    }
}