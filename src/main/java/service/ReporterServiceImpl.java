package service;

import model.Reporter;

public class ReporterServiceImpl implements ReporterService {
    @Override
    public Reporter add(String fullName) {
       Reporter reporter = null;
       if(!isPresent(fullName)) {
           reporter = new Reporter(fullName);
       }
        return reporter;
    }

    @Override
    public boolean isPresent(String fullName) {
        if(getId(fullName) > 0){
            return true;
        }
        return false;
    }

    @Override
    public int getId(String fullName) {
        // TODO: 19.09.2022 add method after Repository layer method implementation
        return 0;
    }
}
