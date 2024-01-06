package Objects;

import Enums.Gender;
import java.util.ArrayList;
import java.util.function.Consumer;

import Exceptions.CannotDoThisAction;
import Interfaces.Catchable;
public class WinnieThePooh extends Character implements Catchable {
    public WinnieThePooh() {
        super("Винни Пух", Gender.Male);
        setBodyParts();
    }
    public BodyPart Nose = new BodyPart("Нос"), Head = new BodyPart("Затылок"), Ear = new BodyPart("Ухо");
    public ArrayList<BodyPart> wannaScratch = new ArrayList<>();
    private void setBodyParts() {
        wannaScratch.add(Nose);
        wannaScratch.add(Head);
        wannaScratch.add(Ear);
    }
    private String getBodyParts() {
        final String[] result = {""};
        this.wannaScratch.forEach(new Consumer<BodyPart>() {
            @Override
            public void accept(BodyPart part) {
                result[0] += part.getName() + " ";
            }
        });
        return result[0];
    }
    public void scratch(BodyPart body_part) {
        if (body_part.getCondition() == Boolean.FALSE) {
            System.out.println(getName() + " почесал " + body_part.getName());
            this.wannaScratch.remove(body_part);
            body_part.is_scratched = Boolean.TRUE;
        } else {
            System.out.println("Эта часть тела у Винни Пуха уже почесана. Сейчас он хочет почесать следующие части тела: " + this.getBodyParts());
        }
    }
    @Override
    public void Catch(Character c, Trap trap) throws CannotDoThisAction {
        if (this.hp > 0) {
            System.out.println(this.getName() + " поймал " + c.getName() + " при помощи " + trap.getName() + "!");
        } else {
            throw new CannotDoThisAction();
        }
    }
    //Вложенный non-static
    private class BodyPart {
        private String name;
        private Boolean is_scratched;

        private BodyPart(String name) {
            this.name = name;
            this.is_scratched = Boolean.FALSE;
        }

        private String getName() {
            return this.name;
        }

        private Boolean getCondition() {
            return this.is_scratched;
        }
    }
}
