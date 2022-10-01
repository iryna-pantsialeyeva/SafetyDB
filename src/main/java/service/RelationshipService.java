package service;

import model.Relationship;

public interface RelationshipService {
    void save(Relationship relationship);

    int getId(Relationship relationship);

    Relationship getById(int id);
}
