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
    public void save(String name) {
        if(getId(name) == 0) {
            Criteria criteria = new Criteria(name);
        }
    }

    @Override
    public int getId(String name) {
        return criteriaRepository.getId(name);
    }
}
