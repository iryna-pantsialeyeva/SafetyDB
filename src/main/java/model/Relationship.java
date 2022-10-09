package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Relationship {
    @NonNull
    private int id;
    private RelationshipType nameGivenByReporter;
    private AnswerType timeRelationship;
    private AnswerType withdrawalResult;
    private AnswerType reintroductionResult;
    private AnswerType otherExplanation;

    public Relationship(RelationshipType nameGivenByReporter, AnswerType timeRelationship, AnswerType withdrawalResult,
                        AnswerType reintroductionResult, AnswerType otherExplanation) {
        this.nameGivenByReporter = nameGivenByReporter;
        this.timeRelationship = timeRelationship;
        this.withdrawalResult = withdrawalResult;
        this.reintroductionResult = reintroductionResult;
        this.otherExplanation = otherExplanation;
    }
}


