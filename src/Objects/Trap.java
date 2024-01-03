package Objects;
import Enums.TrapType;
import Enums.Distance;
import Exceptions.CannotDieTwice;

public abstract class Trap {
    private final String name;
    private final TrapType trapType;
    Integer damage;
    Distance distance;
    public Trap(String name, TrapType trapType, Integer damage) {
        this.name = name;
        this.trapType = trapType;
        this.damage = damage;
    }
    public String getName() {
        if (distance != null) {
            return this.name + ", которая находится " + this.distance;
        }
        else {
            return this.name;
        }
    }
    public void setDistance(Distance distance) {
        this.distance = distance;
    }
    public TrapType getType() {
        return this.trapType;
    }

    public abstract void Catch(Heffalump c) throws CannotDieTwice;
}
