package service;

import model.Criteria;

public class CriteriaServiceImpl implements CriteriaService {


    @Override
    public Criteria save(String name) {
        Criteria criteria = null;
        if(!isPresent(name)) {
            criteria = new Criteria(name);
        }
        return criteria;
    }

    @Override
    public boolean isPresent(String name) {
        if (getId(name) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int getId(String name) {
        // TODO: 19.09.2022 add method after Repository layer method implementation 
        return 0;
    }
}
