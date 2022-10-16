package service;

import model.Relationship;
import model.RelationshipType;

public interface RelationshipService {
    Relationship save(String nameGivenByReporter, String timeRelationship, String withdrawalResult,
              String reintroductionResult, String otherExplanation);

    Relationship getById(int id);

    public RelationshipType evaluate(Relationship relationship);
}
