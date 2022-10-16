package model;

public enum RelationshipType {
    UNCLASSIFIABLE("unclassifiable"),
    UNLIKELY("unlikely"),
    CONDITIONAL("conditional"),
    POSSIBLE("possible"),
    PROBABLE("probable"),
    CERTAIN("certain");

    private String label;

    RelationshipType (String label) {
        this.label = label;
    }

    public static RelationshipType getRelationshipTypeByLabel(String label) {
        for (RelationshipType relationshipType : RelationshipType.values()) {
                if (relationshipType.label.equalsIgnoreCase(label)) {
                    return relationshipType;
                }
            }
        return null;
    }
}
