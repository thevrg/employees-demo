package hu.dpc.edu.employees;

/**
 *
 * @author IQJB
 */
public class BelaRecruiter implements Recruiter {

    @Override
    public Employee getEmployee() {
        return new Employee("Bela");
    }

    @Override
    public String getName() {
        return "Bela Recruiter";
    }

}
