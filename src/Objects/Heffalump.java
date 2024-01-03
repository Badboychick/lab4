package Objects;

import Enums.Gender;
import Enums.ElephantCondition;
import Enums.TrapType;
import Exceptions.CannotAddThisAmount;
import Exceptions.CannotDieTwice;
import Exceptions.CannotMove;

public class Heffalump extends Character {
    ElephantCondition condition;
    public Heffalump() {
        super("Слонопотам", Gender.Male);
    }
    public void setCondition(ElephantCondition elephantCondition) {
        this.condition = elephantCondition;
        System.out.println(this.getName() + " теперь " + elephantCondition);
    }
    public void getCondition() {
        System.out.println(this.getName() + condition.getName());
    }
    public void fall(Trap trap) throws CannotDieTwice {
        System.out.println(this.name + " упал в " + trap.getName());
        this.hurt(30);
        switch (trap.getType()) {
            case Honey -> this.setCondition(ElephantCondition.InHoneyTrap);
            case Nuts -> this.setCondition(ElephantCondition.InNutsTrap);
        }
    }
    @Override
    public void move(Place place) throws CannotAddThisAmount, CannotMove {
        boolean b = (this.condition == ElephantCondition.NeedHelp) || (this.condition == ElephantCondition.InHoneyTrap);
        if (b) {
            throw new CannotMove();
        } else {
            System.out.println(this.getName() + " прогулялся и пришёл в " + place.getName());
            this.setLocation(place);
            place.addExploredScore(30);
        }
    }
}