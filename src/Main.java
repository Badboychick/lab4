import Enums.BodyPart;
import Enums.Distance;
import Enums.Place;
import Objects.Weather;
import Objects.WinnieThePooh;
import Objects.Heffalump;
import Objects.Piglet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        WinnieThePooh puh = new WinnieThePooh();
        Piglet piglet = new Piglet();
        Heffalump elephant = new Heffalump();
        Weather rain = new Weather("дождик");
        Random rand = new Random();

        piglet.say("это, конечно, очень хорошая ", "NamePrefix");
        System.out.print(Place.Trap.getName());
        piglet.say(", но что, если пойдёт дождь?", "WithoutSay");
        int rain_enabled = rand.nextInt(2);
        puh.scratch(BodyPart.Nose);
        puh.notthink();
        int elephant_attentiveness = rand.nextInt(101);
        if (rain_enabled == 1) {
            rain.started();
            puh.shine();
            puh.say("""
                    : "Слонопотам, посмотри на небо!"
                    """, "Name");
            elephant.look(Place.Sky);
            int rainfallStop = rand.nextInt(2);
            if (rainfallStop == 0) {
                elephant.say(": Дождь будет идти ещё долго", "");
            }
            if (rainfallStop == 1) {
                elephant.say(": Дождь скоро закончится", "");
            }
            piglet.warn(Place.Hole, Distance.Near);
            if (elephant_attentiveness == 0) {
                elephant.fall(Place.Hole);
                elephant.hurt(80);
            }
            else if (elephant_attentiveness >= 50) {
                elephant.noticed(Place.Hole);
            }
            else if (elephant_attentiveness < 50) {
                elephant.fall(Place.Hole);
                elephant.hurt(20);
            }
        }
        else {
            elephant.say("дождя нет, жизнь прекрасна!", "NamePrefix");
        }
    }
}