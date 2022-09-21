package service.impl;

import model.Criteria;
import service.CriteriaService;

public class CriteriaServiceImpl implements CriteriaService {


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
        // TODO: 19.09.2022 add method after Repository layer method implementation 
        return 0;
    }
}
