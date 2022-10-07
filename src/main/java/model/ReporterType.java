package model;

public enum ReporterType {
    HEALTH_PROFESSIONAL("health_professional"),
    PATIENT("patient");

    private String name;

    ReporterType (String name) {
        this.name = name;
    }
}
