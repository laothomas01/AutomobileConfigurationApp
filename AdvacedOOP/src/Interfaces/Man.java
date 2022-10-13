package Interfaces;

public class Man implements Think, Learn, Apply, Climb {
    String name;
    int age;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void think() {
        System.out.println("I can think:" + this.getClass().getSimpleName());
    }

    public void learn() {
        System.out.println("I can learn:" + this.getClass().getSimpleName());
    }

    public void apply() {
        System.out.println("I can apply:" + this.getClass().getSimpleName());
    }

    public void climb() {
        System.out.println("I can climb:" + this.getClass().getSimpleName());
    }

    public String toString() {
        return "Man :" + name + ":Age:" + age;
    }
}
