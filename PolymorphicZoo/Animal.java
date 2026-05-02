package zoo;

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public void makeSound(int times) {
        if (times <= 0) {
            System.out.println(name + " makes no sound.");
            return;
        }

        for (int i = 0; i < times; i++) {
            makeSound();
        }
    }

    public String getName() {
        return name;
    }
}