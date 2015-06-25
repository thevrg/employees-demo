package hu.dpc.edu.employees;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IQJB
 */
public class DepartmentTest {

    private Employee emp1;
    private Employee emp2;

    public DepartmentTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private Department createTestDepartmentWithTwoEmployees() {
        BelaRecruiter belaFactory = new MyBelaRecruiter();
        Department d = new Department(belaFactory, "X");
        emp1 = new Employee("Test Emp");
        emp2 = new Employee("Test Emp2");
        d.addEmployee(emp1);
        d.addEmployee(emp2);
        return d;
    }

    @Test
    public void testAddEmployeeIncreasesNumberOfEmployees() {
        //given
        Department tested = createTestDepartmentWithTwoEmployees();
        Employee emp3 = new Employee("Test Emp3");

        //when
        tested.addEmployee(emp3);

        //then
        assertEquals(3, tested.getNumberOfEmployees());
    }

    /**
     * Test of getEmployee method, of class Department.
     */
    @Test
    public void testGetEmployeeShouldReturnFirstEmployeeWhenIndexEqualsToZero() {
        //given
        Department tested = createTestDepartmentWithTwoEmployees();

        //when
        Employee returned = tested.getEmployee(0);

        //then
        assertSame(emp1, returned);
    }

    /**
     * Test of getEmployee method, of class Department.
     */
    @Test
    public void testGetEmployeeShouldReturnSecondEmployeeWhenIndexEqualsToOne() {
        //given
        Department tested = createTestDepartmentWithTwoEmployees();

        //when
        Employee returned = tested.getEmployee(1);

        //then
        assertSame(emp2, returned);
    }

    /**
     * Test of getEmployee method, of class Department.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEmployeeShouldThrowIllegalArgumentExceptionForNegativeIndexes() {
        //given
        Department tested = createTestDepartmentWithTwoEmployees();

        //when
        tested.getEmployee(-1);
    }

    /**
     * Test of getEmployee method, of class Department.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEmployeeShouldThrowIllegalArgumentExceptionWhenIndexEqualsToNumberOfEmployees() {
        //given
        Department tested = createTestDepartmentWithTwoEmployees();

        //when
        tested.getEmployee(2);

        //then IllegalArgumentException is expected
    }

    /**
     * Test of getEmployee method, of class Department.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEmployeeShouldReturnNullWhenIndexGreaterThanNumberOfEmployees() {
        //given
        Department tested = createTestDepartmentWithTwoEmployees();

        //when
        tested.getEmployee(3);

        //then IllegalArgumentException is expected
    }

    @Test
    public void testIterator() {
        //given
        Department tested = createTestDepartmentWithTwoEmployees();

        //when
        Iterator<Employee> iterator = tested.iterator();
        boolean hasNext1 = iterator.hasNext();
        Employee next1 = iterator.next();
        boolean hasNext2 = iterator.hasNext();
        Employee next2 = iterator.next();
        boolean hasNext3 = iterator.hasNext();
        try {
            iterator.next();
            fail("should throw NoSuchElementException");
        } catch (NoSuchElementException ex){
            // this is the expected exception
        }

        //then
        assertEquals(true, hasNext1);
        assertSame(this.emp1, next1);
        assertEquals(true, hasNext2);
        assertSame(this.emp2, next2);
        assertEquals(false, hasNext3);
        
    }
}
