abstract public class Animal {
    private String name;

    public Animal(String name) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void sound(); // declare a method, leave implementation for child class.
    // enforces a contract to enable POLYMORPHISM

}

