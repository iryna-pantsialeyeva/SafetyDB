package service.impl;


import model.*;
import service.*;

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
        AdverseReaction adverseReaction = null;
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(reportDate);
        Outcome outcomeToAdd = this.outcome.save(outcome);
        Criteria criteriaToAdd = this.criteria.save(criteria);
        Type typeToAdd = this.type.save(type);
        Reporter reporterToAdd = this.reporter.add(fullName);

        if (outcomeToAdd == null) {
            outcomeToAdd = new Outcome(outcome);
        }

        if (criteriaToAdd == null) {
            criteriaToAdd = new Criteria(criteria);
        }

        if (typeToAdd == null) {
            typeToAdd = new Type(type);
        }
        if (reporterToAdd == null) {
            reporterToAdd = new Reporter(fullName);
        }

        if (getId(adverseReaction) == 0) {
            adverseReaction = new AdverseReaction(date, description, suspectedDrug, outcomeToAdd, criteriaToAdd,
                    typeToAdd, reporterToAdd);
        }
        return adverseReaction;
    }

    @Override
    public List<AdverseReaction> get(String suspectedDrug) {
        //return RepositorySupplier.getAdverseReactionRepository().get(suspectedDrug);
        // TODO: 21.09.2022 change after Repository layer method get implementation in AdverseReactionRepositoryImpl class
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
    public int getId(AdverseReaction adverseReaction) {
        // TODO: 20.09.2022 add method after Repository layer method implementation
        return 0;
    }
}
