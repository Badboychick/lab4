import Enums.BodyPart;
import Enums.Distance;
import Enums.Place;
import Enums.SpeechMode;
import Objects.WinnieThePooh;
import Objects.Heffalump;
import Objects.Piglet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        WinnieThePooh puh = new WinnieThePooh();
        Piglet piglet = new Piglet();
        Heffalump elephant = new Heffalump();
        Random rand = new Random();

        piglet.say("это, конечно, очень хорошая " + Place.Trap.getName() + ", но что, если пойдёт дождь?", SpeechMode.NamePrefix);
        int rain_enabled = rand.nextInt(2);
        puh.scratch(BodyPart.Nose);
        puh.notthink();
        int elephant_attentiveness = rand.nextInt(101);
        if (rain_enabled == 1) {
            puh.shine();
            puh.say("""
                    : "Слонопотам, посмотри на небо!"
                    """, SpeechMode.Name);
            elephant.look(Place.Sky);
            int rainfallStop = rand.nextInt(2);
            if (rainfallStop == 0) {
                elephant.say(": Дождь будет идти ещё долго", SpeechMode.None);
                piglet.push_elephant(Place.Trap);
            }
            else if (rainfallStop == 1) {
                elephant.say(": Дождь скоро закончится", SpeechMode.None);
            }
            piglet.warn(Place.Hole, Distance.Near);
            if (elephant_attentiveness >= 50) {
                elephant.noticed(Place.Hole);
            }
            else if (elephant_attentiveness < 50) {
                elephant.fall(Place.Hole);
                elephant.hurt(20);
            }
        }
        else {
            elephant.say("дождя нет, жизнь прекрасна!", SpeechMode.NamePrefix);
            piglet.say("тут становится довольно холодно", SpeechMode.NamePrefix);
            piglet.freeze();
            puh.push_elephant(Place.Trap);
        }
    }
}