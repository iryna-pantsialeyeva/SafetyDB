package utils;

import model.AdverseReaction;
import model.RelationshipType;

public class RelationshipCalculator {

    public static void calculateRelationship(AdverseReaction reaction) {
        reaction.setRelationshipByCompany(RelationshipType.CONDITIONAL);
    }

}
