package service;


import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ADRServiceImpl implements ADRService {

    private ReporterService reporter;
    private CriteriaService criteria;
    private OutcomeService outcome;
    private TypeService type;

    @Override
    public AdverseReaction save(String reportDate, String description, String suspectedDrug, String outcome,
                                String criteria, String type, String fullName) throws ParseException {
        AdverseReaction adverseReaction;
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(reportDate);
        Outcome outcomeFromDB = this.outcome.save(outcome);
        Criteria criteriaFromDB = this.criteria.save(criteria);
        Type typeFromDB = this.type.save(type);
        Reporter reporterFromDB = this.reporter.add(fullName);

        if (outcomeFromDB == null) {
            outcomeFromDB = new Outcome(outcome);
        }

        if (criteriaFromDB == null) {
            criteriaFromDB = new Criteria(criteria);
        }

        if (typeFromDB == null) {
            typeFromDB = new Type(type);
        }
        if (reporterFromDB == null) {
            reporterFromDB = new Reporter(fullName);
        }

        adverseReaction = new AdverseReaction(date, description, suspectedDrug, outcomeFromDB, criteriaFromDB,
                typeFromDB, reporterFromDB);

        if (isPresent(adverseReaction)) {
            adverseReaction = null;
        }
        return adverseReaction;
    }

    @Override
    public List<AdverseReaction> get(String suspectedDrug) {
        return null;
    }

    @Override
    public boolean delete(Date reportDate, Reporter fullName) {
        return false;
    }

    @Override
    public boolean update(Date reportDate, String description, String suspectedDrug, Outcome outcome, Criteria criteria, Type type, Reporter fullName) {
        return false;
    }

    @Override
    public boolean isPresent(AdverseReaction adverseReaction) {
        if (getId(adverseReaction) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int getId(AdverseReaction adverseReaction) {
        // TODO: 20.09.2022 add method after Repository layer method implementation
        return 0;
    }
}
