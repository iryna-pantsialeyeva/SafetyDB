package model;

public enum RelationshipType {
    UNCLASSIFIABLE("unclassifiable"),
    UNLIKELY("unlikely"),
    CONDITIONAL("conditional"),
    POSSIBLE("possible"),
    PROBABLE("probable"),
    CERTAIN("certain");

    private String name;

    RelationshipType (String name) {
        this.name = name;
    }
}
