package hu.dpc.edu.employees;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;



/**
 *
 * @author IQJB
 */
public class Employee extends MyBusinessObject implements NatualPerson, Serializable, Externalizable {
    
    private final static long serialVersionUID = 123L;
    
    private final static double DEFAULT_SALARY = 1000;
    private final static String DEFAULT_NAME = "Name not set";
    private transient long id = 99;
    private String name;
    protected double salary;
    
//    private void writeObject(ObjectOutputStream out) throws IOException {
//        System.out.println("writeObject called");
//        out.writeLong(id);
//        out.writeUTF(name);
//        out.writeDouble(salary);
//        out.writeUTF(getAlma());
//    }
//    
//    private void readObject(ObjectInputStream in) throws IOException {
//        System.out.println("readObject called");
//        id = in.readLong();
//        name = in.readUTF();
//        salary = in.readDouble();
//        setAlma(in.readUTF());
//    }

    public Employee() {
        this(DEFAULT_NAME);
    }

    public Employee(String name) {
        this(name, DEFAULT_SALARY);
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        System.out.println("Employee.<init>(name, salary)");
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    protected String getInfo() {
        return ", name=" + name + ", salary=" + salary + ", id=" + this.id;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
