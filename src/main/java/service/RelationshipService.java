package service;

import model.Relationship;
import model.RelationshipType;

public interface RelationshipService {
    Relationship save(String nameGivenByReporter, String timeRelationship, String withdrawalResult,
              String reintroductionResult, String otherExplanation);

    int getId(Relationship relationship);

    Relationship getById(int id);

    RelationshipType evaluate(Relationship relationship);

    void update(Relationship relationship);
}
