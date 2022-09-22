package service.impl;

import model.Criteria;
import service.CriteriaService;
import repository.*;
import service.ServiceException;

public class CriteriaServiceImpl implements CriteriaService {

    private CriteriaRepository criteriaRepository;

    public CriteriaServiceImpl() {
        criteriaRepository = new CriteriaRepositoryImpl();
    }

    @Override
    public Criteria save(String name) {
        Criteria criteria = null;
        if(getId(name) == 0) {
            criteria = new Criteria(name);
        }
        return criteria;
    }

    @Override
    public int getId(String name) {
        return criteriaRepository.getId(name);
    }
}
