package Objects;
import Enums.TrapType;
import Enums.ElephantCondition;
import Exceptions.CannotDieTwice;

public class HoneyTrap extends Trap{
    public HoneyTrap() {
        super("Горшок с мёдом", TrapType.Honey, 15);
    }
    @Override
    public void Catch(Heffalump c) throws CannotDieTwice {
        c.hurt(this.damage);
        c.setCondition(ElephantCondition.InHoneyTrap);
        System.out.println(c.getName() + " угодил в медовую ловушку, Пуху повезло!");
    }
}
