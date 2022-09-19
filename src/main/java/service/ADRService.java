package service;

import model.*;

import java.util.Date;
import java.util.List;


public interface ADRService {

    AdverseReaction save(Date reportDate, String description, String suspectedDrug, Outcome outcome, Criteria criteria, Type type, Reporter fullName);

    List<AdverseReaction> get(String suspectedDrug);

    boolean delete(Date reportDate, Reporter fullName);

    boolean update(Date reportDate, String description, String suspectedDrug, Outcome outcome, Criteria criteria, Type type, Reporter fullName);
}
