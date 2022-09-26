package repository;

public interface RelationshipRepository {

    void save(Relationship relationship);
    int getId(Relationship relationship);
    Relationship getByID(int id);
}
