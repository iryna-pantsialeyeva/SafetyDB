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
        try {
            for (Outcome outcome : values()) {
                if (outcome.label.equals(label)) {
                    return outcome;
                }
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            System.out.println("The provided value does not exist in Outcome.");
        }
        return null;
    }
}
