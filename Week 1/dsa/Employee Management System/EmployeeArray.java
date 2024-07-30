class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

public class EmployeeArray {
    private Employee[] employees;
    private int count;

    public EmployeeArray(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
        } else {
            System.out.println("Array is full");
        }
    }

    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].employeeId + ", " + employees[i].name + ", " + employees[i].position + ", "
                    + employees[i].salary);
        }
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                // Shift elements to the left
                System.arraycopy(employees, i + 1, employees, i, count - i - 1);
                count--;
                break;
            }
        }
    }

    public static void main(String[] args) {
        EmployeeArray employeeArray = new EmployeeArray(5);

        employeeArray.addEmployee(new Employee(1, "Sanskruti", "Manager", 50000));
        employeeArray.addEmployee(new Employee(2, "Khushi", "Developer", 40000));
        employeeArray.addEmployee(new Employee(3, "Anushka", "Tester", 35000));

        employeeArray.traverseEmployees();

        Employee foundEmployee = employeeArray.searchEmployeeById(2);
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee.name);
        } else {
            System.out.println("Employee not found");
        }

        employeeArray.deleteEmployee(2);
        employeeArray.traverseEmployees();
    }
}
