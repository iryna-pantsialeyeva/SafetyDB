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
    private Reporter reporter;
    private Relationship relationship;
    private RelationshipType relationshipByCompany;

    public AdverseReaction(LocalDate reportDate, String description, String suspectedDrug, Outcome outcome,
                           Criteria criteria, User user, Reporter reporter, Relationship relationship,
                           RelationshipType relationshipByCompany) {
        this.reportDate = reportDate;
        this.description = description;
        this.suspectedDrug = suspectedDrug;
        this.outcome = outcome;
        this.criteria = criteria;
        this.user = user;
        this.reporter = reporter;
        this.relationship = relationship;
        this.relationshipByCompany = relationshipByCompany;
    }
}
