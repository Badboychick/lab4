package Enums;

public enum BodyPart {
    Head("голову"),
    Nose("нос"),
    Ear("за ухом");
    private final String bodyPart;
    BodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }
    public String getName() {
        return bodyPart;
    }
}
