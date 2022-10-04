package service.impl;

import model.Criteria;
import repository.impl.CriteriaRepositoryImpl;
import service.CriteriaService;
import repository.*;

import java.util.ArrayList;
import java.util.List;

public class CriteriaServiceImpl implements CriteriaService {

    private CriteriaRepository criteriaRepository;

    private final List<Criteria> cachedCriteria = new ArrayList<>();

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
    @Override
    public Criteria getById(int id) {
        if(cachedCriteria.stre)
        return criteriaRepository.getById(id);
    }
//
//    @Override
//    public int getId(Criteria criteria) {
//        return criteriaRepository.getId(criteria.getName());
//    }
}