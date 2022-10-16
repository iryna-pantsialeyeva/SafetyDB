package mapper;

import model.AdverseReaction;
import model.User;

public interface AdverseReactionMapper {
    AdverseReaction fromDto(AdverseReaction dto);
    AdverseReaction fromFields(String description,
                               String suspectedDrug,
                               String outcome,
                               String criteria,
                               User user,
                               String supposedDrugOutcomeCriteria,
                               String dependsOnTime,
                               String dependsOnDrugCancellation,
                               String dependsOnDrugReturn,
                               String otherPossibleExplanation);
    AdverseReaction toDto(AdverseReaction dto);
}
