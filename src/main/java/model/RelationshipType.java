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
        try {
            for (RelationshipType relationshipType : values()) {
                if (relationshipType.label.equals(label)) {
                    return relationshipType;
                }
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            System.out.println("The provided value does not exist in RelationshipType.");
        }
        return null;
    }
}
