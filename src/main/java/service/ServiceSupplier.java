package service;

import lombok.Getter;
import service.impl.*;

public class ServiceSupplier {

    @Getter private static ADRService adrService = new ADRServiceImpl();
    @Getter private static CriteriaService criteriaService = new CriteriaServiceImpl();
    @Getter private static OutcomeService outcomeService = new OutcomeServiceImpl();
    @Getter private static TypeService typeService = new TypeServiceImpl();
    @Getter private static ReporterService reporterService = new ReporterServiceImpl();
}
