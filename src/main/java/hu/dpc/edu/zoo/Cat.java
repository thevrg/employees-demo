package hu.dpc.edu.zoo;

/**
 *
 * @author IQJB
 */
public class Cat extends Animal implements Pet {
    
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" + "name=" + name + '}';
    }
    
}
