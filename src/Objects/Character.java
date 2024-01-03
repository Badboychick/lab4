package Objects;

import Enums.Gender;
import Enums.SpeechMode;

import Exceptions.*;
import Interfaces.Moveable;

import java.util.Objects;

public abstract class Character implements Moveable {
    protected final String name;
    private String name_ending;
    private final Gender gender;
    protected Integer hp;
    protected Integer karma;
    private Place location;
    public Character(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.karma = 0;
        this.hp = 100;
        makeNameEnding(gender);
    }

    public void setLocation(Place place) {
        this.location = place;
    }
    public void addKarmaPoints(int karma) throws CannotAddThisAmount {
        this.karma += karma;
        if (karma > 0) {
            System.out.println(this.getName() + "получает " + karma + " очков кармы. На данный момент у этого персонажа " + this.karma + "очков кармы.");
        }
        else if (karma < 0) {
            System.out.println(this.getName() + "теряет " + karma + " очков кармы. На данный момент у этого персонажа " + this.karma + "очков кармы.");
        }
        else{
            throw new CannotAddThisAmount();
        }
    }
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
        Character character = (Character) obj;
        return (Objects.equals(name, character.name) && Objects.equals(hp, character.hp) && Objects.equals(gender, character.gender) && Objects.equals(karma, character.karma));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name) * this.hp;
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
    public void die() throws CannotDieTwice {
        if (this.hp != 0) {
            this.hp = 0;
            System.out.println(this.name + " погибает.");
        }
        else {
            throw new CannotDieTwice();
        }
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
    public void hurt(Integer hp) throws CannotDieTwice {
        if (this.hp > 0) {
            System.out.println(getName() + " потерял" + name_ending + " " + hp + " очков здоровья");
            this.hp -= hp;
            if (this.hp <= 0) {
                die();
            }
        }
        else {
            throw new CannotDieTwice();
        }
    }
    public void move(Place place) throws CannotAddThisAmount, CannotMove {
        boolean b = (this.hp > 0);
        if (b) {
            System.out.println(this.getName() + " прогулялся и пришёл в " + place.getName());
            this.setLocation(place);
            place.addExploredScore(30);
        } else {
            throw new CannotMove();
        }
    }

    public void push_friend(Character c, Trap trap) throws CannotDieTwice, CannotAddThisAmount {
        System.out.println(this.name + " толкает " + c.getName() + " в " + trap.getName() + "!");
        this.addKarmaPoints(-40);
        if (karma <= -100) {
            System.out.println(this.name + " оказался подлецом и получил по заслугам");
            this.hurt(50);
        }
    }
}