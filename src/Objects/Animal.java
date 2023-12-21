package Objects;

import Enums.Distance;
import Enums.Gender;
import Enums.Place;

import java.util.Objects;

public abstract class Animal {
    protected final String name;
    private String name_ending;
    private final Gender gender;
    private Integer hp;
    public void makeNameEnding(Gender gender) {
        switch (gender) {
            case Male:
                name_ending = "";
                break;
            case Female:
                name_ending = "а";
                break;
            case Third:
                name_ending = "о";
                break;
            case Plural:
                name_ending = "и";
        }
    }
    public Animal(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.hp = 100;
        makeNameEnding(gender);
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
        return (Objects.equals(name, animal.name) && Objects.equals(hp, animal.hp) && Objects.equals(gender, animal.gender));
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
    public void die() {
        this.hp = 0;
        System.out.println(this.name + " погибает.");
    }
    public void look(Place place) {
        System.out.print(this.name + " посмотрел на " + place.getName());
    }
    public void say(String line, String mode) {
        switch (mode) {
            case "Name":
                System.out.println(getName() + " сказал" + name_ending + " " + line);
                break;
            case "NamePrefix":
                System.out.println(getName() + " сказал" + name_ending + ", что "+ line);
                break;
            case "Prefix":
                System.out.println(" сказал" + name_ending + ", что "+ line);
                break;
            case "":
                System.out.println(" сказал" + name_ending + line);
                break;
            case "WithoutSay":
                System.out.println(line);
                break;
        }
    }
    public void hurt(Integer hp) {
        System.out.println(getName() + " потерял" + name_ending + " "+ hp + " очков здоровья");
        this.hp -= hp;
        if (this.hp <= 0) {
            die();
        }
    }
    public void noticed(Place place) {
        System.out.println(this.name + " замечает " + place.getName());
    }
    public void warn(Place place, Distance distance) {
        System.out.println(this.name + " предупреждает: " + place.getName() + " " + distance.getName() + "!");
    }
    public void shine() {
        System.out.println(getName() + " просиял" + name_ending);
    }
}