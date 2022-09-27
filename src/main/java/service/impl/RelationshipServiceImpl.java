package service.impl;

import model.Relationship;
import service.RelationshipService;
import repository.*;

public class RelationshipServiceImpl implements RelationshipService {

    private RelationshipRepository relationshipRepository;

    public RelationshipServiceImpl() {
        relationshipRepository = new RelationshipRepositoryImpl();
    }

    @Override
    public void save(Relationship relationship) {
        relationshipRepository.save(relationship);
    }

    @Override
    public int getId(Relationship relationship) {
        return relationshipRepository.getId(relationship);
    }

    @Override
    public Relationship getByID(int id) {
        return relationshipRepository.getByID(id);
    }
}
