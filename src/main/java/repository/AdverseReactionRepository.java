package repository;

import model.AdverseReaction;
import model.Reporter;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface AdverseReactionRepository {

    List<AdverseReaction> getAll();
    void save(AdverseReaction advReact) throws SQLException;
    void update(AdverseReaction advReact);
    void delete(int id);
    AdverseReaction getById(int id);

}
