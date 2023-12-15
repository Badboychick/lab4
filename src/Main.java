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
        piglet.say(", но что, если пойдёт дождь?", "-say");
        int rain_enabled = rand.nextInt(2);
        puh.scratch("свой нос");
        puh.notthink();
        int elephant_attentiveness = rand.nextInt(101);
        if (rain_enabled == 1) {
            rain.started();
            puh.shine();
            puh.say("""
                    "Слонопотам, посмотри на небо!"
                    """, "Name");
            elephant.look(Place.Sky);
            int rainfallStop = rand.nextInt(101);
            if (rainfallStop == 0) {
                elephant.say(": Дождь не закончится, мы обречены", "");
            }
            if (rainfallStop >= 0 && rainfallStop < 50) {
                elephant.say(": Дождь будет идти ещё долго", "");
            }
            if (rainfallStop >= 50 && rainfallStop <=99) {
                elephant.say(": Дождь скоро закончится", "");
            }
            if (rainfallStop > 99) {
                elephant.say(": Дождь уже закончился", "");
            }
            piglet.say(Place.Hole.getName() + " " + Distance.Near.getName() + ". Слонопотам, осторожно!", "NamePrefix");
            if (elephant_attentiveness == 0) {
                elephant.die();
            }
            else if (elephant_attentiveness >= 50) {
                elephant.noticed();
            }
            else if (elephant_attentiveness < 50) {
                elephant.fall(Place.Hole);
            }
        }
        else {
            elephant.say("дождя нет, жизнь прекрасна!", "NamePrefix");
        }
    }
}