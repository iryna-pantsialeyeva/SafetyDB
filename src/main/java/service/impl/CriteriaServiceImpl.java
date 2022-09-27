package service.impl;

import model.Criteria;
import service.CriteriaService;
import repository.*;

public class CriteriaServiceImpl implements CriteriaService {

    private CriteriaRepository criteriaRepository;

    public CriteriaServiceImpl() {
        criteriaRepository = new CriteriaRepositoryImpl();
    }

    @Override
    public void save(Criteria criteria) {
        if(getId(criteria) == 0) {
            criteriaRepository.add(criteria);
        }
    }

    @Override
    public Criteria getByID(int id) {
        return criteriaRepository.getByID(id);
    }

    @Override
    public int getId(Criteria criteria) {
        return criteriaRepository.getId(criteria.getName());
    }
}
