package hu.dpc.edu.employees;

/**
 *
 * @author IQJB
 */
public abstract class MyBusinessObject {

    private String alma = "ALMA";

    public MyBusinessObject() {
        System.out.println("MyBusinessObject.<init>()");
    }
    
    

    public String getAlma() {
        return alma;
    }

    public void setAlma(String alma) {
        this.alma = alma;
    }
    
    protected abstract String getInfo();

    @Override
    public final String toString() {
        return getClass().getSimpleName() + "{" + getInfo() + '}';
    }
}
