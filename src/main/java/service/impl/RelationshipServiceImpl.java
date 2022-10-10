package service.impl;

import model.AnswerType;
import model.Relationship;
import model.RelationshipType;
import repository.RelationshipRepository;
import repository.impl.RelationshipRepositoryImpl;
import service.RelationshipService;

public class RelationshipServiceImpl implements RelationshipService {

    private RelationshipRepository relationshipRepository;

    public RelationshipServiceImpl() {
        relationshipRepository = new RelationshipRepositoryImpl();
    }

    @Override
    public Relationship save(String nameGivenByReporter, String timeRelationship,
                     String withdrawalResult, String reintroductionResult, String otherExplanation) {
        Relationship relationship = new Relationship();
        relationship.setNameGivenByReporter(RelationshipType.getRelationshipTypeByLabel(nameGivenByReporter));
        relationship.setTimeRelationship(AnswerType.getAnswerTypeByLabel(timeRelationship));
        relationship.setWithdrawalResult(AnswerType.getAnswerTypeByLabel(withdrawalResult));
        relationship.setReintroductionResult(AnswerType.getAnswerTypeByLabel(reintroductionResult));
        relationship.setOtherExplanation(AnswerType.getAnswerTypeByLabel(otherExplanation));
        relationshipRepository.save(relationship);
        return relationship;
    }

    @Override
    public int getId(Relationship relationship) {
        return relationshipRepository.getId(relationship);
    }

    @Override
    public Relationship getById(int id) {
        return relationshipRepository.getById(id);
    }

    //WHO-UMC system assessment
    @Override
    public RelationshipType evaluate(Relationship relationship) {
        RelationshipType relationshipByCompany;
        AnswerType timeRelationship = relationship.getTimeRelationship();
        AnswerType withdrawalResult = relationship.getWithdrawalResult();
        AnswerType reintroductionResult = relationship.getReintroductionResult();
        AnswerType otherExplanation = relationship.getOtherExplanation();

        if(timeRelationship == AnswerType.YES && withdrawalResult == AnswerType.YES &&
                otherExplanation == AnswerType.NO) {
            if(reintroductionResult == AnswerType.YES) {
                relationshipByCompany = RelationshipType.CERTAIN;
            } else {
                relationshipByCompany = RelationshipType.PROBABLE;
            }
        } else if (timeRelationship == AnswerType.YES && withdrawalResult != AnswerType.YES &&
                reintroductionResult != AnswerType.YES && otherExplanation == AnswerType.YES) {
            relationshipByCompany = RelationshipType.POSSIBLE;
        } else if (timeRelationship == AnswerType.NO && otherExplanation == AnswerType.YES) {
            relationshipByCompany = RelationshipType.UNLIKELY;
        } else if (timeRelationship == AnswerType.NA && otherExplanation == AnswerType.NA) {
            relationshipByCompany = RelationshipType.CONDITIONAL;
        } else {
            relationshipByCompany = RelationshipType.UNCLASSIFIABLE;
        }
        return relationshipByCompany;
    }
}
