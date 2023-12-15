package Objects;

import Enums.Gender;
import Enums.Place;
import Interfaces.CanFall;

public class Heffalump extends Animal implements CanFall {
    public Heffalump() {
        super("Слонопотам", Gender.Male);
    }
    @Override
    public void fall(Place place) {
        System.out.println(this.name + " упал в " + place.getName());
    }
    @Override
    public void die() {
        System.out.println(this.name + " погибает.");
    }
    @Override
    public void noticed() {
        System.out.println(this.name + " замечает яму и обходит её.");
    }
}