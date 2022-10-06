package model;

public enum Criteria {
    DEATH("death"),
    HOSPITALISATION("hospitalisation"),
    DISABILITY_OR_INCAPACITY("disability_or_incapacity"),
    LIFE_THREATENING("life_threatening"),
    CONGENITAL_ANOMALY("congenital_anomaly"),
    MEDICALLY_IMPORTANT("medically_important");

    private String name;

    Criteria(String name) {
        this.name = name;
    }


}
