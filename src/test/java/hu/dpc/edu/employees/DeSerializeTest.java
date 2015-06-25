
package hu.dpc.edu.employees;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author IQJB
 */
public class DeSerializeTest {
    @Test
    public void testDeSerialization() throws IOException, ClassNotFoundException {
        
        Employee emp = null;
        
        try(ObjectInputStream out = new ObjectInputStream(new FileInputStream("output.ser"));) {
            emp = (Employee) out.readObject();
            System.out.println("emp: " + emp);
            assertEquals("Bela", emp.getName());
            assertEquals("ALMA", emp.getAlma());
            assertEquals(0L, emp.getId());
        } 
    }
}
