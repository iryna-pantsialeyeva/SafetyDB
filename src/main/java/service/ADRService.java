package service;

import model.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface ADRService {

    AdverseReaction save(String reportDate, String description, String suspectedDrug, String outcome, String criteria, String type, String fullName) throws ParseException;

    List<AdverseReaction> get(String suspectedDrug) throws ServiceException;

    boolean delete(Date reportDate, Reporter fullName);

    boolean update(Date reportDate, String description, String suspectedDrug, Outcome outcome, Criteria criteria, Type type, Reporter fullName);

    int getId(AdverseReaction adverseReaction);
}
