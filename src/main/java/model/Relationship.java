package model;

import lombok.*;
import model.enums.AnswerType;
import model.enums.RelationshipType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Relationship {
    private int id;
    private RelationshipType nameGivenByReporter;
    private AnswerType timeRelationship;
    private AnswerType withdrawalResult;
    private AnswerType reintroductionResult;
    private AnswerType otherExplanation;
}
