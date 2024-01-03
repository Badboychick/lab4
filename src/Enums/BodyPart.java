package Enums;

public enum BodyPart {
    Head("голова"),
    Nose("нос"),
    Ear("ухо");
    private final String bodyPart;
    BodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }
    public String getName() {
        return bodyPart;
    }
}
