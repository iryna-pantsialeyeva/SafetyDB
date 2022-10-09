package model;

public enum AnswerType {
    YES("yes"),
    NO("no"),
    NA("na");

    private String label;

    AnswerType (String label) {
        this.label = label;
    }

    public static AnswerType getAnswerTypeByLabel(String label) {
        try {
            for (AnswerType answerType : values()) {
                if (answerType.label.equals(label)) {
                    return answerType;
                }
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            System.out.println("The provided value does not exist in AnswerType.");
        }
        return null;
    }
}
