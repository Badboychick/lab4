package Objects;

import Enums.Gender;

public class Piglet extends Animal{
    public Piglet() {
        super("Пятачок", Gender.Male);
    }
    public void freeze() {
        System.out.println(getName() + " замерзает");
        hurt(10);
    }
}