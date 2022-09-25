package service.impl;

import model.Criteria;
import model.enums.CriteriaType;
import service.CriteriaService;
import repository.*;
import service.ServiceException;

public class CriteriaServiceImpl implements CriteriaService {

    private CriteriaRepository criteriaRepository;

    public CriteriaServiceImpl() {
        criteriaRepository = new CriteriaRepositoryImpl();
    }

    @Override
    public void save(CriteriaType name) {
        if(getId(name) == 0) {
            Criteria criteria = new Criteria(name);
            criteriaRepository.add(criteria);
        }
    }

    @Override
    public int getId(CriteriaType name) {
        return criteriaRepository.getId(name);
    }
}
