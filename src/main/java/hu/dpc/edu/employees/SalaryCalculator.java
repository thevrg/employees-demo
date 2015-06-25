package hu.dpc.edu.employees;

/**
 *
 * @author IQJB
 */
public class SalaryCalculator {
    public double calculateSalarySummary(EmployeeIterator employees) {
        double sum = 0;
        while(employees.hasNext()) {
            Employee emp = employees.next();
            sum += emp.getSalary();
        }
        return sum;
    }
}
