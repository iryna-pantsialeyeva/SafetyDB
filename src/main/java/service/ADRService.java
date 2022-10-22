package service;

import model.AdverseReaction;
import java.util.List;

public interface ADRService {

    void save(AdverseReaction reaction) throws ServiceException;

    List<AdverseReaction> getAll();

    void delete(int id) throws ServiceException;

    void update(AdverseReaction adverseReaction) throws ServiceException;

    AdverseReaction getByID(int id);
}
