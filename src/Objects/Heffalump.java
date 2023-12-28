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
    public void push_elephant(Place place) {
        System.out.println(this.name + " внезапно решает столкнуть себя в " + place.getName() + "!\nЧто за сумасшедший поступок!?");
        this.hp -= 50;
    }
}