package service;

import model.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface ADRService {

    boolean save(AdverseReaction adverseReaction) throws ParseException;

    List<AdverseReaction> get(String suspectedDrug) throws ServiceException;

    List<AdverseReaction> getByFullName(String fullName) throws ServiceException;

    boolean delete(Date reportDate, Reporter fullName) throws ServiceException;

    public boolean update(int id, String description, String suspectedDrug, Outcome outcome, Criteria criteria)
            throws ServiceException;

    int getId(AdverseReaction adverseReaction);
}
