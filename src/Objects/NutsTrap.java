package Objects;
import Enums.TrapType;
import Enums.ElephantCondition;
import Exceptions.CannotDieTwice;

public class NutsTrap extends Trap{
    public NutsTrap() {
        super("Горшок с мёдом", TrapType.Nuts, 25);
    }
    @Override
    public void Catch(Heffalump c) throws CannotDieTwice {
        c.hurt(this.damage);
        c.setCondition(ElephantCondition.InNutsTrap);
        System.out.println(c.getName() + " угодил в ореховую ловушку, Пятачку повезло!");
    }
}