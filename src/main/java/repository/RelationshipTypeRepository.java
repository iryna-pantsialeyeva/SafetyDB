package repository;

import model.Criteria;
import model.enums.RelationshipType;

public interface RelationshipTypeRepository {

    RelationshipType getById(int id);
}
