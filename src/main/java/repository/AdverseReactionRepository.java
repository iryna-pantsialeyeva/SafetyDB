package repository;

import model.AdverseReaction;
import model.Reporter;

import java.sql.Date;
import java.util.List;

public interface AdverseReactionRepository {

    List<AdverseReaction> getAll();
    void save(AdverseReaction advReact);
    void update(AdverseReaction advReact);
    void delete(Date reportDate, Reporter fullName);
    AdverseReaction getById(int id);
    AdverseReaction getByName(String title);

}
