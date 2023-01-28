package component;

import java.util.ArrayList;

public abstract class Component {
    private String name;
    protected ArrayList<Component> children;

    public Component(String _name) {
        this.name = _name;
        this.children = new ArrayList<Component>();
    }

    public abstract void details();

    public String get_name() {
        return this.name;
    }

    public void hierarchy() {
        hierarchy(0);
    }

    public void hierarchy(int _depth) {
    }

    public boolean add(Component _child) {
        return false;
    }

    public boolean remove(Component _child) {
        return false;
    }

    public void remove_all() {
    }

    public Component get_child(String _name) {
        for (Component child : this.children) {
            if (child.get_name().equals(_name)) {
                return child;
            }
        }
        return null;
    }
}