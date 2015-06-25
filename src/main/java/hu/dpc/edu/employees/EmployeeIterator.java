package hu.dpc.edu.employees;

/**
 *
 * @author IQJB
 */
public interface EmployeeIterator {
    
    public boolean hasNext();
    /**
     * 
     * @return
     * @throws IllegalStateException If no more elements
     */
    public Employee next() throws IllegalStateException;
}
