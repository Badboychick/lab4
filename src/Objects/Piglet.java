package Objects;

import Enums.Gender;
import Exceptions.CannotDieTwice;

public class Piglet extends Character {
    public Piglet() {
        super("Пятачок", Gender.Male);
    }
    public void freeze() throws CannotDieTwice {
        System.out.println(getName() + " замерзает");
        hurt(10);
    }
    public void warn(Trap trap) {
        System.out.println(this.name + " предупреждает: " + trap.getName() + "!");
        this.karma += 10;
    }
}