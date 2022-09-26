package repository;

import model.AdverseReaction;
import model.Reporter;

import java.sql.Date;
import java.util.List;

public interface AdverseReactionRepository {

    List<AdverseReaction> getAll();
    void save(AdverseReaction advReact);
    int update(AdverseReaction advReact);
    int delete(Date reportDate, Reporter fullName);
    AdverseReaction getById(int id);
    AdverseReaction getByName(String title);

}
