package model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class AdverseReaction {

    private int id;
    private LocalDate reportDate;
    private String description;
    private String suspectedDrug;
    private Outcome outcome;
    private Criteria criteria;
    private User user;
    private RelationshipType relationshipByCompany;

    private RelationshipType nameGivenByReporter;
    private AnswerType timeRelationship;
    private AnswerType withdrawalResult;
    private AnswerType reintroductionResult;
    private AnswerType otherExplanation;

    boolean isVerified = false;

    public AdverseReaction(String description, String suspectedDrug, Outcome outcome,
                           Criteria criteria, User user, RelationshipType nameGivenByReporter,
                           AnswerType timeRelationship, AnswerType withdrawalResult, AnswerType reintroductionResult, AnswerType otherExplanation) {
        this.reportDate = LocalDate.now();
        this.description = description;
        this.suspectedDrug = suspectedDrug;
        this.outcome = outcome;
        this.criteria = criteria;
        this.user = user;
        this.nameGivenByReporter = nameGivenByReporter;
        this.timeRelationship = timeRelationship;
        this.withdrawalResult = withdrawalResult;
        this.reintroductionResult = reintroductionResult;
        this.otherExplanation = otherExplanation;
    }
}
