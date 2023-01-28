package component;

import java.util.ArrayList;

public class CompanyComponent extends Component {
    private int current_project_count;

    public CompanyComponent(String _name) {
        super(_name);
        this.current_project_count = 0;
    }

    @Override
    public void details() {
        System.out.println("Name: " + this.get_name() + "\nProject Count: " + this.current_project_count);
    }

    @Override
    public void hierarchy(int _depth) {
        for (int i = 0; i < _depth; i++) {
            System.out.print("  ");
        }
        System.out.println("- " + this.get_name());
        for (Component child : this.children) {
            child.hierarchy(_depth + 1);
        }
    }

    @Override
    public boolean add(Component _child) {
        if (this.children.contains(_child)) {
            return false;
        }
        if (_child instanceof CompanyComponent) {
            this.children.add(_child);
            this.current_project_count += ((CompanyComponent) _child).get_current_project_count();
            return true;
        }
        if (_child instanceof EmployeeComponent) {
            if (((EmployeeComponent) _child).get_role() == Role.Project_manager) {
                this.children.add(_child);
                this.current_project_count++;
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

    public int get_current_project_count() {
        return this.current_project_count;
    }

    public ArrayList<String> get_current_project_names() {
        ArrayList<String> project_names = new ArrayList<String>();
        for (Component child : this.children) {
            if (child instanceof CompanyComponent) {
                project_names.addAll(((CompanyComponent) child).get_current_project_names());
            } else {
                project_names.add(((EmployeeComponent) child).get_current_project());
            }
        }
        return project_names;
    }
}