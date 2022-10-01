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
    @NonNull private RelationshipType nameGivenByReporter;
    @NonNull private AnswerType timeRelationship;
    @NonNull private AnswerType withdrawalResult;
    @NonNull private AnswerType reintroductionResult;
    @NonNull private AnswerType otherExplanation;
}
