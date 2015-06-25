package hu.dpc.edu.zoo;

/**
 *
 * @author IQJB
 */
public class Zoo {
    public static void main(String[] args) {
        Cat c = new Cat("Lukrecia");
        Dog d = new Dog("Frakk");
        Spider s = new Spider();
        
        Animal a = c;
        
        Cat c2 = (Cat) a;
        
//        Dog d2 = (Dog) a;
        
        //Dog d3 = (Dog) c;
        Pet p = (Pet) s;
        
    }
}
