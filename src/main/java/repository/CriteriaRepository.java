package repository;

import model.Criteria;
import model.CriteriaType;

public interface CriteriaRepository {

    Criteria getById(int id);
    Criteria getByName(String name);
    Criteria add(Criteria criteria);
    int getId(CriteriaType criteriaType);

}
