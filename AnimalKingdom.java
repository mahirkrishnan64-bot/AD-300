import java.util.ArrayList;

abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public abstract void makeSound();
}

interface Flyable {
    void fly();
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println(name + " happily munches on dog food.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }

    public void fetch() {
        System.out.println(name + " is fetching a ball.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Special Behavior: Fetches objects.");
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }

    public void scratch() {
        System.out.println(name + " is scratching the post.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Special Behavior: Scratches the post.");
    }
}

class Bird extends Animal implements Flyable {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Chirp!");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying in the sky.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Special Behavior: Flies through the air.");
    }
}

class Fish extends Animal {
    public Fish(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Glub!");
    }

    public void swim() {
        System.out.println(name + " is swimming in the water.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Special Behavior: Swims in water.");
    }
}

class AnimalKingdom {
    void main() {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Buddy", 3));
        animals.add(new Cat("Whiskers", 2));
        animals.add(new Bird("Sky", 1));
        animals.add(new Fish("Bubbles", 1));

        for (Animal animal : animals) {
            animal.displayInfo();
            animal.eat();
            animal.sleep();
            animal.makeSound();

            switch (animal) {
                case Dog dog -> dog.fetch();
                case Cat cat -> cat.scratch();
                case Bird bird -> bird.fly();
                case Fish fish -> fish.swim();
                default -> { }
            }

            System.out.println("----------------------------");
        }
    }
}