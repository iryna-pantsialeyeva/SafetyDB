package utils;

import model.AdverseReaction;
import model.RelationshipType;

public class RelationshipCalculator {

    public static void calculateRElationship(AdverseReaction reaction) {
        reaction.setRelationshipByCompany(RelationshipType.CONDITIONAL);
    }

}
