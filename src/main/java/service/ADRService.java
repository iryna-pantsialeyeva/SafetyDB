package service;

import model.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface ADRService {

//    boolean save(AdverseReaction adverseReaction) throws ServiceException;
//
//    List<AdverseReaction> get(String suspectedDrug) throws ServiceException;

    List<AdverseReaction> getAll();

//    AdverseReaction getByID(int id);
//
//    List<AdverseReaction> getByFullName(Reporter reporter) throws ServiceException;
//
//    boolean delete(Date reportDate, Reporter reporter) throws ServiceException;
//
//    public boolean update(int id, String description, String suspectedDrug, Outcome outcome, Criteria criteria)
//            throws ServiceException;
//
//    int getId(AdverseReaction adverseReaction);
}
