package hu.dpc.edu.employees;

import java.io.Serializable;

/**
 *
 * @author IQJB
 */
public interface Recruiter extends EmployeeFactory, Serializable {
    public String getName();
}
