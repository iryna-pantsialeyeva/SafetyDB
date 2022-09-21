package service.impl;

import model.Reporter;
import service.ReporterService;

public class ReporterServiceImpl implements ReporterService {
    @Override
    public Reporter add(String fullName) {
       Reporter reporter = null;
       if(getId(fullName) == 0) {
           reporter = new Reporter(fullName);
       }
        return reporter;
    }

    @Override
    public int getId(String fullName) {
        // TODO: 19.09.2022 add method after Repository layer method implementation
        return 0;
    }
}
