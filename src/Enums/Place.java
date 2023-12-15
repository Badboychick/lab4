package Enums;

public enum Place {
    Trap("Западня"),
    Hole("Очень Глубокая Яма"),
    Sky("небо");
    private final String place;
    Place(String place) {
        this.place = place;
    }
    public String getName() {
        return place;
    }
}
