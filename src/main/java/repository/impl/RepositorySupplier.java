package repository.impl;

import repository.ReporterRepository;
import repository.ReporterTypeRepository;
import repository.impl.AdverseReactionRepositoryImpl;

public class RepositorySupplier {

    private static AdverseReactionRepositoryImpl advReactRepos = new AdverseReactionRepositoryImpl();
    private static CriteriaRepositoryImpl criteriaRepos = new CriteriaRepositoryImpl();
    private static OutcomeRepositoryImpl outcomeRepos = new OutcomeRepositoryImpl();
    private static ReporterRepositoryImpl reporterRepos = new ReporterRepositoryImpl();
    private static ReporterTypeRepositoryImpl reporterTypeRepos = new ReporterTypeRepositoryImpl();

    public static AdverseReactionRepositoryImpl getAdverseReactionRepository() {
        return advReactRepos;
    }

    public static CriteriaRepositoryImpl getCriteriaRepository() {
        return criteriaRepos;
    }

    public static OutcomeRepositoryImpl getOutcomeRepository() {
        return outcomeRepos;
    }

    public static ReporterRepositoryImpl getReporterRepository() {
        return reporterRepos;
    }

    public static ReporterTypeRepositoryImpl getReporterTypeRepository() {
        return reporterTypeRepos;
    }

}
