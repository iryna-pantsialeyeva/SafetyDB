package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "adverse_reactions")
public class AdverseReaction {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "report_date")
    private LocalDate reportDate;
    @Column(name = "description")
    private String description;
    @Column(name = "suspected_drug")
    private String suspectedDrug;
    @Column(name = "outcome_name")
    private Outcome outcome;
    @Column(name = "criteria_name")
    private Criteria criteria;
    @Column(name = "causal_relationship_company")
    private RelationshipType relationshipByCompany;
    @Column(name = "causal_relationship_reporter")
    private RelationshipType nameGivenByReporter;
    @Column(name = "time_relationship")
    private AnswerType timeRelationship;
    @Column(name = "withdrawal_result")
    private AnswerType withdrawalResult;
    @Column(name = "reintroduction_result")
    private AnswerType reintroductionResult;
    @Column(name = "other_explanation")
    private AnswerType otherExplanation;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    boolean isVerified = false;

    @Override
    public String toString() {
        return "Adverse Reaction{" +
                "id=" + id +
                ", report date=" + reportDate +
                ", description=" + description +
                ", suspected drug=" + suspectedDrug +
                ", outcome=" + outcome +
                ", criteria=" + criteria +
                ", causal relationship company=" + relationshipByCompany +
                ", causal relationship reporter=" + nameGivenByReporter +
                ", time relationship=" + timeRelationship +
                ", withdrawal result=" + withdrawalResult +
                ", reintroduction result=" + reintroductionResult +
                ", other explanation=" + otherExplanation +
                "}";
    }
}
