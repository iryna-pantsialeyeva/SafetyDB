package service.impl;

import model.Relationship;
import model.Reporter;
import model.enums.AnswerType;
import model.enums.RelationshipType;
import service.RelationshipService;
import repository.*;

public class RelationshipServiceImpl implements RelationshipService {

    private RelationshipRepository relationshipRepository;

    public RelationshipServiceImpl() {
        relationshipRepository = new RelationshipRepositoryImpl();
    }

    public void save(Relationship relationship) {
        relationshipRepository.save(relationship);
    }

    public int getId(Relationship relationship) {
        return relationshipRepository.getId(relationship);
    }

    public Relationship getByID(int id) {
        return relationshipRepository.getByID(id);
    }
}
