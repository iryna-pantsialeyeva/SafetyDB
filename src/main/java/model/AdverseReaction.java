package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import model.util.AnswerTypeConverter;
import model.util.CriteriaConverter;
import model.util.OutcomeConverter;
import model.util.RelationshipTypeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "adverse_reactions")
@Data
@NoArgsConstructor
public class AdverseReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "report_date")
    private LocalDate reportDate;

    private String description;

    @Column(name = "suspected_drug")
    private String suspectedDrug;

    @Column(name="outcome_name")
    @Convert(converter = OutcomeConverter.class)
    private Outcome outcome;

    @Column(name="criteria_name")
    @Convert(converter = CriteriaConverter.class)
    private Criteria criteria;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name="causal_relationship_company")
    @Convert(converter = RelationshipTypeConverter.class)
    private RelationshipType relationshipByCompany;

    @Column(name = "causal_relationship_reporter")
    @Convert(converter = RelationshipTypeConverter.class)
    private RelationshipType nameGivenByReporter;

    @Column(name = "time_relationship")
    @Convert(converter = AnswerTypeConverter.class)
    private AnswerType timeRelationship;

    @Column(name = "withdrawal_result")
    @Convert(converter = AnswerTypeConverter.class)
    private AnswerType withdrawalResult;

    @Column(name = "reintroduction_result")
    @Convert(converter = AnswerTypeConverter.class)
    private AnswerType reintroductionResult;

    @Column(name = "other_explanation")
    @Convert(converter = AnswerTypeConverter.class)
    private AnswerType otherExplanation;


    public AdverseReaction(String description,
                           String suspectedDrug,
                           Outcome outcome,
                           Criteria criteria,
                           User user,
                           RelationshipType nameGivenByReporter,
                           AnswerType timeRelationship,
                           AnswerType withdrawalResult,
                           AnswerType reintroductionResult,
                           AnswerType otherExplanation) {
        this.reportDate = LocalDate.now();
        this.description = description;
        this.suspectedDrug = suspectedDrug;
        this.outcome = outcome;
        this.criteria = criteria;
        this.user = user;
        this.nameGivenByReporter = nameGivenByReporter;
        this.relationshipByCompany = RelationshipType.CERTAIN;
        this.timeRelationship = timeRelationship;
        this.withdrawalResult = withdrawalResult;
        this.reintroductionResult = reintroductionResult;
        this.otherExplanation = otherExplanation;
    }
}
