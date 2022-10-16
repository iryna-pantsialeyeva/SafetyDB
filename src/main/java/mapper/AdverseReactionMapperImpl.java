package mapper;

import model.*;
import utils.RelationshipCalculator;

public class AdverseReactionMapperImpl implements AdverseReactionMapper {
    @Override
    public AdverseReaction fromDto(AdverseReaction dto) {
        return null;
    }

    @Override
    public AdverseReaction fromFields(
            String description,
            String suspectedDrug,
            String outcome,
            String criteria,
            User user,
            String supposedDrugOutcomeCriteria,
            String dependsOnTime,
            String dependsOnDrugCancellation,
            String dependsOnDrugReturn,
            String otherPossibleExplanation) {

        AdverseReaction reaction = new AdverseReaction(description, suspectedDrug, Outcome.getOutcomeByLabel(outcome),
                Criteria.getCriteriaByLabel(criteria),
                new User(0), RelationshipType.getRelationshipTypeByLabel(supposedDrugOutcomeCriteria),
                AnswerType.getAnswerTypeByLabel(dependsOnTime),
                AnswerType.getAnswerTypeByLabel(dependsOnDrugCancellation),
                AnswerType.getAnswerTypeByLabel(dependsOnDrugReturn),
                AnswerType.getAnswerTypeByLabel(otherPossibleExplanation));
        RelationshipCalculator.calculateRElationship(reaction);
        return reaction;
    }

    @Override
    public AdverseReaction toDto(AdverseReaction dto) {
        return new AdverseReaction(dto.getDescription(), dto.getSuspectedDrug(), dto.getOutcome(), dto.getCriteria(), null, dto.getNameGivenByReporter(),
                dto.getTimeRelationship(), dto.getWithdrawalResult(), dto.getReintroductionResult(), dto.getOtherExplanation());
    }
}
