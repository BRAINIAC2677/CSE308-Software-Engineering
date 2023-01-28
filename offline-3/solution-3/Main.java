import java.io.Console;
import java.util.ArrayList;

import component.*;

public class Main {
    public static void main(String[] args) {
        TestCompositePattern test = new TestCompositePattern();
        test.test();
    }
}

class TestCompositePattern {
    private ArrayList<Component> root_components;
    private ArrayList<Component> all_components;

    public TestCompositePattern() {
        this.root_components = new ArrayList<Component>();
        this.all_components = new ArrayList<Component>();
    }

    public void test() {
        String prompt = "\nPress 1: Create company\nPress 2: Add project manager to a company\nPress 3: Add developer to a project manager\nPress 4: Remove Component\nPress 5: Print hierarchy\nPress 6: Print details\nPress 7: Exit\n";
        Console console = System.console();

        while (true) {
            String test_code = console.readLine(prompt);
            if (test_code.equals("1")) {
                String company_name = console.readLine("Enter company name: ");
                while (check_duplicate_name(company_name)) {
                    company_name = console.readLine("Duplicate name. Enter company name: ");
                }
                CompanyComponent company = new CompanyComponent(company_name);
                this.root_components.add(company);
                this.all_components.add(company);
            } else if (test_code.equals("2")) {
                String company_name = console.readLine("Enter company name: ");
                String project_manager_name = console.readLine("Enter project manager name: ");
                while (check_duplicate_name(project_manager_name)) {
                    project_manager_name = console.readLine("Duplicate name. Enter project manager name: ");
                }
                String current_project = console.readLine("Enter current project: ");
                EmployeeComponent project_manager = new EmployeeComponent(project_manager_name, Role.Project_manager,
                        current_project);
                boolean found = false;
                for (Component component : this.root_components) {
                    if (component.get_name().equals(company_name)) {
                        component.add(project_manager);
                        this.all_components.add(project_manager);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Company not found.");
                }
            } else if (test_code.equals("3")) {
                String project_manager_name = console.readLine("Enter project manager name: ");
                String developer_name = console.readLine("Enter developer name: ");
                while (check_duplicate_name(developer_name)) {
                    developer_name = console.readLine("Duplicate name. Enter developer name: ");
                }
                EmployeeComponent developer = new EmployeeComponent(developer_name, Role.Developer, "");
                boolean found = false;
                for (Component component : this.all_components) {
                    if ((component instanceof EmployeeComponent)
                            && (component.get_name().equals(project_manager_name))) {
                        if (((EmployeeComponent) component).get_role() != Role.Project_manager) {
                            System.out.println("Not a project manager.");
                            break;
                        }
                        developer.set_current_project(((EmployeeComponent) component).get_current_project());
                        component.add(developer);
                        this.all_components.add(developer);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Project manager not found.");
                }
            } else if (test_code.equals("4")) {
                String name = console.readLine("Enter name: ");
                boolean found = false;
                for (Component component : this.all_components) {
                    if (component.get_child(name) != null) {
                        component.remove(component.get_child(name));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Component not found.");
                }
            } else if (test_code.equals("5")) {
                for (Component component : this.root_components) {
                    // print divider
                    System.out.println("--------------------------------------------------");
                    component.hierarchy();
                    System.out.println("--------------------------------------------------");
                }
            } else if (test_code.equals("6")) {
                String name = console.readLine("Enter name: ");
                boolean found = false;
                for (Component component : this.all_components) {
                    // print divider
                    if (component.get_name().equals(name)) {
                        System.out.println("==================================================");
                        component.details();
                        System.out.println("==================================================");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Component not found.");
                }
            } else if (test_code.equals("7")) {
                break;
            } else {
                System.out.println("Invalid input.");
            }

        }
    }

    // check for duplicate name
    private boolean check_duplicate_name(String _name) {
        for (Component component : this.all_components) {
            if (component.get_name().equals(_name)) {
                return true;
            }
        }
        return false;
    }
}