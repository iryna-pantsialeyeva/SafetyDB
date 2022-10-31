package model;

public enum Criteria {
    DEATH("death"),
    HOSPITALISATION("hospitalisation"),
    DISABILITY_OR_INCAPACITY("disability or incapacity"),
    LIFE_THREATENING("life threatening"),
    CONGENITAL_ANOMALY("congenital anomaly"),
    MEDICALLY_IMPORTANT("medically important");

    private String label;

    Criteria(String label) {
        this.label = label;
    }

    public static Criteria getCriteriaByLabel(String label) {
        for (Criteria criteria : Criteria.values()) {
                if (criteria.label.equalsIgnoreCase(label)) {
                    return criteria;
                }
            }
        return null;
    }

    public String getLabel() {
        return label;
    }
}
