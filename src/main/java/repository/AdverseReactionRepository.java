package repository;

import model.AdverseReaction;
import model.Reporter;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface AdverseReactionRepository {

    List<AdverseReaction> getAll();
    void save(AdverseReaction advReact) throws SQLException;
    int getId(AdverseReaction advReaction);
    List<AdverseReaction> get(String suspectedDrug);
    List<AdverseReaction> getByFullName(String fullName);
    boolean update(AdverseReaction advReact) throws SQLException;
    boolean delete(Date reportDate, Reporter fullName) throws SQLException;
    AdverseReaction getById(int id);
    AdverseReaction getByName(String title);

}
