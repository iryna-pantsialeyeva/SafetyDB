package service.impl;

import model.AdverseReaction;
import repository.AdverseReactionRepository;
import repository.impl.AdverseReactionRepositoryImpl;
import service.ADRService;
import service.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class ADRServiceImpl implements ADRService {

    private AdverseReactionRepository adverseReactionRepository;

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
            throw new ServiceException("St went wrong during deleting.", e);
        }
    }

    @Override
    public void update(AdverseReaction adverseReaction) throws ServiceException {
        try {
            adverseReactionRepository.update(adverseReaction);
        } catch (SQLException e) {
            throw new ServiceException("Something went wrong during updating", e);
        }
    }

    @Override
    public AdverseReaction getByID(int id) {
        return adverseReactionRepository.getById(id);
    }
}
