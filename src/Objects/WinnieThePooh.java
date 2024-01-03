package Objects;

import Enums.BodyPart;
import Enums.Gender;
import Interfaces.CanScratch;
import Interfaces.Catchable;

public class WinnieThePooh extends Character implements CanScratch, Catchable {
    public WinnieThePooh() {
        super("Винни Пух", Gender.Male);
    }
    @Override
    public void scratch(BodyPart body_part) {
        System.out.println(getName() + " почесал " + body_part.getName());
    }
    @Override
    public void Catch(Character c, Trap trap) {
        System.out.println(this.getName() + "поймал " + c.getName() + "при помощи" + trap.getName() + "!");
    }
}
