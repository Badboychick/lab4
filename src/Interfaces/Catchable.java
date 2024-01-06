package Interfaces;

import Objects.Character;
import Objects.Trap;

public interface Catchable {
    void Catch(Character c, Trap trap);
    //локальный класс
    default void activateTrap(Trap trap) {
        class Activator {
            public void activate(Trap trap) {
                trap.isActive = !trap.isActive;
                if (trap.isActive) {
                    System.out.println("Ловушка " + trap.getName() + " активирована");
                } else {
                    System.out.println("Ловушка " + trap.getName() + " активирована");
                }
            }
        }
    }
}
