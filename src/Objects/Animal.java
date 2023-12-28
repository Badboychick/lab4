package Objects;

import Enums.Distance;
import Enums.Gender;
import Enums.Place;
import Enums.SpeechMode;

import java.util.Objects;

public abstract class Animal {
    protected final String name;
    private String name_ending;
    private final Gender gender;
    protected Integer hp;
    protected Integer karma;
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
        this.karma = 0;
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
        return (Objects.equals(name, animal.name) && Objects.equals(hp, animal.hp) && Objects.equals(gender, animal.gender) && Objects.equals(karma, animal.karma));
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
                "karma='" + karma + '\'' +
                "hp='" + hp + '\'' +
                '}';
    }
    public void die() {
        this.hp = 0;
        System.out.println(this.name + " погибает.");
    }
    public void look(Place place) {
        System.out.print(this.name + " посмотрел на " + place.getName());
    }
    public void say(String line, SpeechMode mode) {
        switch (mode) {
            case Name:
                System.out.println(getName() + " сказал" + name_ending + " " + line);
                break;
            case NamePrefix:
                System.out.println(getName() + " сказал" + name_ending + ", что "+ line);
                break;
            case Prefix:
                System.out.println(" сказал" + name_ending + ", что "+ line);
                break;
            case None:
                System.out.println(" сказал" + name_ending + line);
                break;
            case WithoutSay:
                System.out.println(line);
                break;
        }
    }
    public void hurt(Integer hp) {
        System.out.println(getName() + " потерял" + name_ending + " " + hp + " очков здоровья");
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
        this.karma += 10;
    }
    public void push_elephant(Place place) {
        System.out.println(this.name + " толкает Слонопотама в " + place.getName() + "!");
        this.karma -= 40;
        if (karma <= -100) {
            System.out.println(this.name + " теряет 50 единиц здоровья.\n" + this.name + " оказался подлецом и получил по заслугам");
            this.hp -= 50;
        }
    }
    public void shine() {
        System.out.println(getName() + " просиял" + name_ending);
    }
}