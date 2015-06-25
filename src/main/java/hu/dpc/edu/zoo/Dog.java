package hu.dpc.edu.zoo;

/**
 *
 * @author IQJB
 */
public class Dog extends Animal implements Pet {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog{" + "name=" + name + '}';
    }

}
