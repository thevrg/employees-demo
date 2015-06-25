package hu.dpc.edu.employees;

import java.io.Serializable;

/**
 *
 * @author IQJB
 */
public class MyBelaRecruiter extends BelaRecruiter implements Serializable {

    @Override
    public Employee getEmployee() {
        final Employee employee = super.getEmployee();
        employee.setSalary(10000);
        return employee;
    }
    
}
