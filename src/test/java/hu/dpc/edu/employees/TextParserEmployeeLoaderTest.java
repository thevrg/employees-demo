package hu.dpc.edu.employees;

import java.io.StringReader;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

/**
 *
 * @author IQJB
 */
public class TextParserEmployeeLoaderTest {

    private ReadableSource createMockSource(String testContent) {
        ReadableSource source = Mockito.mock(ReadableSource.class);
        when(source.createReader()).thenReturn(new StringReader(testContent));
        return source;
    }

    @Test
    public void testLoadEmployeesCreatesTheRightTypes() {
        //given
        ReadableSource source = createMockSource(
                "Secretary,102,Bela,1000\n"
                + "Employee,103,Jozsi,2000\n"
                + "Manager,104,Feri,3000,HR");
        TextParserEmployeeLoader parser = new TextParserEmployeeLoader(source);

        //when
        List<Employee> employees = parser.loadEmployees();

        //then
        assertEquals(3, employees.size());
        assertEquals(Secretary.class, employees.get(0).getClass());
        assertEquals(Employee.class, employees.get(1).getClass());
        assertEquals(Manager.class, employees.get(2).getClass());

    }

    @Test
    public void testLoadEmployeesSkipsRowsWithInvalidTypes() {
        //given
        ReadableSource source = createMockSource(
                "Secretary,102,Bela,1000\n"
                + "Employee2,103,Jozsi,2000\n"//invalid row
                + "Manager,104,Feri,3000,HR");
        TextParserEmployeeLoader parser = new TextParserEmployeeLoader(source);

        //when
        List<Employee> employees = parser.loadEmployees();

        //then
        assertEquals(2, employees.size());
        assertEquals(Secretary.class, employees.get(0).getClass());
        assertEquals(Manager.class, employees.get(1).getClass());

    }

    @Test
    public void testLoadEmployeesCreatesSecretaryWithTheRightData() {
        //given
        ReadableSource source = createMockSource("Secretary,102,Bela,1000");
        TextParserEmployeeLoader parser = new TextParserEmployeeLoader(source);

        //when
        List<Employee> employees = parser.loadEmployees();

        //then
        assertEquals(1, employees.size());
        assertEquals(Secretary.class, employees.get(0).getClass());
        Secretary sec = (Secretary) employees.get(0);
        assertEquals(102L, sec.getId());
        assertEquals("Bela", sec.getName());
        assertEquals(1000, sec.getSalary(), 0.00001);
    }

    @Test
    public void testLoadEmployeesCreatesManagerWithTheRightData() {
        //given
        ReadableSource source = createMockSource(
                "Manager,1021,Jozsi,10000,HR");
        TextParserEmployeeLoader parser = new TextParserEmployeeLoader(source);

        //when
        List<Employee> employees = parser.loadEmployees();

        //then
        assertEquals(1, employees.size());
        assertEquals(Manager.class, employees.get(0).getClass());
        Manager manager = (Manager) employees.get(0);
        assertEquals(1021L, manager.getId());
        assertEquals("Jozsi", manager.getName());
        assertEquals(10000, manager.getSalary(), 0.00001);
        assertEquals("HR", manager.getManagerOf().getName());
    }

}
