package service;

import model.Criteria;

public interface CriteriaService {

    Criteria save(String name);

    int getId(String name);
}
