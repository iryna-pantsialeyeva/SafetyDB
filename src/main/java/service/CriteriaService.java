package service;

import model.Criteria;

public interface CriteriaService {

    void save(Criteria criteria);

    Criteria getByID(int id);

    int getId(Criteria criteria);
}
