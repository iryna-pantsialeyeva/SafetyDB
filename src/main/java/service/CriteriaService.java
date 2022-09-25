package service;

import model.Criteria;
import model.enums.CriteriaType;

public interface CriteriaService {

    void save(CriteriaType name);

    int getId(CriteriaType name);
}
