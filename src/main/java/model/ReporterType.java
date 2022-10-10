package model;

public enum ReporterType {
    HEALTH_PROFESSIONAL("health professional"),
    PATIENT("patient");

    private String label;

    ReporterType (String label) {
        this.label = label;
    }

    public static ReporterType getReporterTypeByLabel(String label) {
        for (ReporterType reporterType : ReporterType.values()) {
                if (reporterType.label.equalsIgnoreCase(label)) {
                    return reporterType;
                }
            }
        return null;
    }
}
