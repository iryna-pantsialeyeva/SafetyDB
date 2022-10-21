package repository;

import model.AdverseReaction;
import java.sql.SQLException;
import java.util.List;

public interface AdverseReactionRepository {

    List<AdverseReaction> getAll();
    void save(AdverseReaction advReact) throws SQLException;
    void update(AdverseReaction advReact) throws SQLException;
    void delete(int id) throws SQLException;
    AdverseReaction getById(int id);
}
