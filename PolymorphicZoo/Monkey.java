package zoo;

public class Monkey extends Animal {
    public Monkey(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Ooh Ooh Aah Aah");
    }
}