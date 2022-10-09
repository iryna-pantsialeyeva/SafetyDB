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
        try {
            for (Criteria criteria : values()) {
                if (criteria.label.equals(label)) {
                    return criteria;
                }
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            System.out.println("The provided value does not exist in Criteria.");
        }
        return null;
    }
}
