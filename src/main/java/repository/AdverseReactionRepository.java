package repository;

import model.AdverseReaction;
import model.Reporter;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface AdverseReactionRepository {

    List<AdverseReaction> getAll() throws RepositoryException;
    void save(AdverseReaction advReact) throws SQLException, RepositoryException;
    int getId(AdverseReaction advReaction);
    List<AdverseReaction> get(String suspectedDrug);
    List<AdverseReaction> getByFullName(String fullName);
    void update(AdverseReaction advReact) throws RepositoryException;
    void delete(int id) throws RepositoryException;
    AdverseReaction getById(int id);
    AdverseReaction getByName(String title);

}
