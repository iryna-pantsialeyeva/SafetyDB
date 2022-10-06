package model.enums;

public enum AnswerType {
    YES("yes"),
    NO("no"),
    NA("na");

    private String name;

    AnswerType (String name) {
        this.name = name;
    }
}
