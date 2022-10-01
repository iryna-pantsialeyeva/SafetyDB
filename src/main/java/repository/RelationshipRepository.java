package repository;

import model.Relationship;

public interface RelationshipRepository {

    void save(Relationship relationship);
    int getId(Relationship relationship);
    Relationship getByID(int id);
}
