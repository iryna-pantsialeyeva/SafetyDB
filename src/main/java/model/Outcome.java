package model;

public enum Outcome {
    DEATH("death"),
    RECOVERED("recovered"),
    NOT_RECOVERED("not recovered"),
    UNKNOWN("unknown");

    private String label;

    Outcome (String label) {
        this.label = label;
    }

    public static Outcome getOutcomeByLabel(String label) {
        for (Outcome outcome : Outcome.values()) {
                if (outcome.label.equalsIgnoreCase(label)) {
                    return outcome;
                }
            }
        return null;
    }

    public String getLabel() {
        return label;
    }
}
