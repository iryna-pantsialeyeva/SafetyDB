package repository;

import model.AdverseReaction;

import java.util.List;

public interface AdverseReactionRepository {

    List<AdverseReaction> getAll();
    void save(AdverseReaction advReact);
    void update(AdverseReaction advReact);
    void delete(int id);
    AdverseReaction getById(int id);
    AdverseReaction getByName(String title);

}
