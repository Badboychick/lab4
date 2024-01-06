package Objects;

import Enums.Gender;
import Exceptions.CannotDieTwice;
import Exceptions.CannotDoThisAction;
import Interfaces.Catchable;

public class Piglet extends Character implements Catchable {
    public Piglet() {
        super("Пятачок", Gender.Male);
    }
    public void freeze() throws CannotDieTwice, CannotDoThisAction {
        if (this.hp > 0) {
            System.out.println(getName() + " замерзает");
            hurt(10);
        } else {
            throw new CannotDoThisAction();
        }
    }
    public void warn(Trap trap) throws CannotDoThisAction {
        if (this.hp > 0){
            System.out.println(this.name + " предупреждает: ловушка " + trap.getName() + "!");
            this.karma += 10;
        } else {
            throw new CannotDoThisAction();
        }
    }
    @Override
    public void Catch(Character c, Trap trap) throws CannotDoThisAction{
        if (this.hp > 0) {
            System.out.println(this.getName() + " поймал " + c.getName() + " при помощи " + trap.getName() + "!");
        } else {
            throw new CannotDoThisAction();
        }
    }
}