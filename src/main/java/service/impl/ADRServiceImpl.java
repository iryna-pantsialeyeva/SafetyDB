package service.impl;

import model.AdverseReaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.AdverseReactionRepository;
import repository.impl.AdverseReactionRepositoryImpl;
import service.ADRService;
import service.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class ADRServiceImpl implements ADRService {

    private AdverseReactionRepository adverseReactionRepository;
    private static final Logger logger = LogManager.getLogger(ADRServiceImpl.class);

    public ADRServiceImpl() {
        adverseReactionRepository = new AdverseReactionRepositoryImpl();
    }

    @Override
    public void save(AdverseReaction adverseReaction) throws ServiceException {
        try {
            adverseReactionRepository.save(adverseReaction);
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<AdverseReaction> getAll() {
        List<AdverseReaction> adverseReactions = adverseReactionRepository.getAll();
        return adverseReactions;
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            adverseReactionRepository.delete(id);
        } catch (SQLException e) {
            logger.error("DELETING ERROR", e);
            throw new ServiceException("Something went wrong during deleting.", e);
        }
    }

    @Override
    public void update(AdverseReaction adverseReaction) throws ServiceException {
        try {
            logger.info("UPDATE STARTED");
            adverseReactionRepository.update(adverseReaction);
        } catch (SQLException e) {
            logger.error("UPDATING ERROR", e);
            throw new ServiceException("Something went wrong during updating", e);
        }
        logger.info("UPDATE FINISHED");
    }

    @Override
    public AdverseReaction getByID(int id) {
        return adverseReactionRepository.getById(id);
    }
}
