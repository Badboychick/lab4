package Objects;

import Enums.Gender;
import Enums.Place;

import java.util.Objects;

public abstract class Animal {
    protected String name;
    private String ending;
    private Gender gender;
    protected Place place = null;
    public Animal(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        switch (gender) {
            case Male:
                this.ending = "";
                break;
            case Female:
                this.ending = "а";
                break;
            case Third:
                this.ending = "о";
                break;
            case Plural:
                this.ending = "и";
                break;
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Animal animal = (Animal) obj;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Objects.Animal{" +
                ", sex=" + gender + '\'' +
                "name='" + name + '\'' +
                '}';
    }
    public void look(Place place) {
        System.out.print(this.name + " посмотрел на " + place.getName());
    }
    public void say(String line, String mode) {
        switch (mode) {
            case "Name":
                System.out.println(getName() + " сказал" + ending + " " + line);
                break;
            case "NamePrefix":
                System.out.println(getName() + " сказал" + ending + ", что "+ line);
                break;
            case "Prefix":
                System.out.println(" сказал" + ending + ", что "+ line);
                break;
            case "":
                System.out.println(" сказал" + ending + line);
                break;
            case "-say":
                System.out.println(line);
                break;
        }
    }
    public void shine() {
        System.out.println(getName() + " просиял" + ending);
    }
}