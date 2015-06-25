package hu.dpc.edu.employees;



/**
 *
 * @author IQJB
 */
public class Manager extends Employee {
    private Department managerOf;

    public Manager() {
    }
    
    public Manager(Department managerOf) {
        this.managerOf = managerOf;
    }

    public Manager(Department managerOf, String name) {
        super(name);
        this.managerOf = managerOf;
    }

    public Manager(Department managerOf, String name, double salary) {
        super(name, salary);
        this.managerOf = managerOf;
    }

    public Department getManagerOf() {
        return managerOf;
    }

    public void setManagerOf(Department managerOf) {
        this.managerOf = managerOf;
    }
    
    @Override
    protected String getInfo() {
        return super.getInfo() + ", managerOf=" + managerOf; 
    }

}
