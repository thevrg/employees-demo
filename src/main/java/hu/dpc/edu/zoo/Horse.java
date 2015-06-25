package hu.dpc.edu.zoo;

/**
 *
 * @author IQJB
 */
public class Horse extends Animal implements Pet {
    private String name;

    public Horse(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Horse{" + "name=" + name + '}';
    }
    
}
