package repository;

import model.Criteria;

public interface CriteriaRepository {

    Criteria getByID(int id);
    Criteria getByName(String name);
    Criteria add(Criteria criteria);
}
