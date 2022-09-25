package service;

import model.AdverseReaction;
import model.Relationship;
import model.enums.AnswerType;
import model.enums.OutcomeType;
import model.enums.RelationshipType;

public interface RelationshipService {
    void save(Relationship relationship);

    int getId(Relationship nameGivenByReporter);

    Relationship getByID(int id);
}
