package Enums;

public enum ElephantCondition {
    PrettyHurted("довольно сильно пострадавший"),
    NoDifference("чувствует себя без изменений"),
    InHoneyTrap("находится в медовой ловушке, не может выбраться"),
    InNutsTrap("находится в ореховой ловушке, не может выбраться"),
    NeedHelp("нуждается в медицинской помощи");
    private final String condition;
    ElephantCondition(String condition) {
        this.condition = condition;
    }
    public String getName() {
        return condition;
    }
}
