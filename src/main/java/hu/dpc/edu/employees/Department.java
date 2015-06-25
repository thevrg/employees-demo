package hu.dpc.edu.employees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author IQJB
 */
public class Department implements Iterable<Employee> {

    private Recruiter recruiter;

    String name;
    private List<Employee> employeeList = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }
    public Department(Recruiter employeeFactory, String name) {
        this.recruiter = employeeFactory;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

    public void hireEmployee() {
        addEmployee(recruiter.getEmployee());
    }

    public Employee getEmployee(int index) {
        try {
            return employeeList.get(index);
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("Invalid employee index", ex);
        }
    }

    public Employee removeEmployee(int index) {
        try {
            return employeeList.remove(index);
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("Invalid employee index", ex);
        }
    }

    public int getNumberOfEmployees() {
        return employeeList.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Department)) {
            return false;
        }
        Department other = (Department) obj;
        return name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Department{" + "name=" + name + '}';
    }

    @Override
    public Iterator<Employee> iterator() {
        return employeeList.iterator();
    }

}
