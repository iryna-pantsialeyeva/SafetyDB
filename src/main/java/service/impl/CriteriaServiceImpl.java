package service.impl;

import model.Criteria;
import repository.impl.CriteriaRepositoryImpl;
import service.CriteriaService;
import repository.*;

public class CriteriaServiceImpl implements CriteriaService {

    private CriteriaRepository criteriaRepository;

    public CriteriaServiceImpl() {
        criteriaRepository = new CriteriaRepositoryImpl();
    }
//
//    @Override
//    public void save(Criteria criteria) {
//        if(getId(criteria) == 0) {
//            criteriaRepository.add(criteria);
//        }
//    }
//
//    @Override
//    public Criteria getById(int id) {
//        return criteriaRepository.getById(id);
//    }
//
//    @Override
//    public int getId(Criteria criteria) {
//        return criteriaRepository.getId(criteria.getName());
//    }
}