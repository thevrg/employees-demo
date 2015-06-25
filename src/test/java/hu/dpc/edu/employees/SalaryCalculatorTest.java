package hu.dpc.edu.employees;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.mockito.internal.verification.VerificationModeFactory;

/**
 *
 * @author IQJB
 */
public class SalaryCalculatorTest {
    
    public SalaryCalculatorTest() {
    }

    @Test
    public void testCalculateSalarySummary() {
        //given
        Employee emp1 = mock(Employee.class);
        when(emp1.getSalary()).thenReturn(1000D);
        
        Employee emp2 = mock(Employee.class);
        when(emp2.getSalary()).thenReturn(2000D);
        
        EmployeeIterator empIterator = mock(EmployeeIterator.class);
        
        when(empIterator.hasNext())
                .thenReturn(true, true, false);
        
        when(empIterator.next())
                .thenReturn(emp1, emp2)
                .thenThrow(IllegalStateException.class);
        
        SalaryCalculator calc = new SalaryCalculator();
        
        //when
        double sum = calc.calculateSalarySummary(empIterator);
        
        //then
        
        verify(empIterator, VerificationModeFactory.times(2)).next();
        verify(empIterator, VerificationModeFactory.times(3)).hasNext();
        verify(emp1).getSalary();
        verify(emp2).getSalary();
        
        Assert.assertEquals(3000D, sum, 0.0001);
        
    }
    
}
