
package hu.dpc.edu.employees;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import org.junit.Test;

/**
 *
 * @author IQJB
 */
public class SerializeTest {
    @Test
    public void testSerialization() throws IOException {
        
        Employee emp = new Employee("Bela", 66);
        emp.setId(65);
        emp.setAlma("XXX");
        
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("output.ser"));) {
            out.writeObject(emp);
        } 
    }
}
