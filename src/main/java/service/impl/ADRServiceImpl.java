package service.impl;

import model.AdverseReaction;
import repository.AdverseReactionRepository;
import repository.impl.AdverseReactionRepositoryImpl;
import service.ADRService;

import java.sql.SQLException;
import java.util.List;

public class ADRServiceImpl implements ADRService {

    private AdverseReactionRepository adverseReactionRepository;
    private ReporterService reporterService;
    private UserRepository userRepository;
    private ReporterRepository reporterRepository;

    public ADRServiceImpl() {
        adverseReactionRepository = new AdverseReactionRepositoryImpl();
        reporterService = new ReporterServiceImpl();
        userRepository = new UserRepositoryImpl();
        reporterRepository = new ReporterRepositoryImpl();
    }

    @Override
    public void save(AdverseReaction reaction) {
        try {
            adverseReactionRepository.save(reaction);
        } catch (SQLException e) {
//            logger.log("....");
            System.out.println("Something wrong");
        }
    }

    @Override
    public List<AdverseReaction> getAll() {
        return adverseReactionRepository.getAll();
    }
}
