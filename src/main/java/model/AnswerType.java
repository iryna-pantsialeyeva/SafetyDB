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
        for (AnswerType answerType : AnswerType.values()) {
                if (answerType.label.equalsIgnoreCase(label)) {
                    return answerType;
                }
            }
        return null;
        }
    }

