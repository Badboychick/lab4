package Objects;

import Enums.Gender;
import Interfaces.CanScratch;

public class WinnieThePooh extends Animal implements CanScratch {
    public WinnieThePooh() {
        super("Винни Пух", Gender.Male);
    }
    public void notthink() {
        System.out.println(getName() + " об этом не подумал.");
    }
    @Override
    public void scratch(String body_part) {
        System.out.println(getName() + " почесал " + body_part);
    }
}
