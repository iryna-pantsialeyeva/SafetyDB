package model;

public enum ReporterType {
    HEALTH_PROFESSIONAL("health professional"),
    PATIENT("patient");

    private String label;

    ReporterType (String label) {
        this.label = label;
    }

    public static ReporterType getReporterTypeByLabel(String label) {
        try {
            for (ReporterType reporterType : values()) {
                if (reporterType.label.equals(label)) {
                    return reporterType;
                }
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            System.out.println("The provided value does not exist in ReporterType.");
        }
        return null;
    }
}
