package model;

public enum Outcome {
    DEATH("death"),
    RECOVERED("recovered"),
    NOT_RECOVERED("not_recovered"),
    UNKNOWN("unknown");

    private String name;

    Outcome (String name) {
        this.name = name;
    }
}
