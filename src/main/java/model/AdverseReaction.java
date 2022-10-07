package model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class AdverseReaction {

    private int id;
    private Date reportDate;
    private String description;
    private String suspectedDrug;
    private Outcome outcome;
    private Criteria criteria;
    private User user;
    private Reporter reporter;
    private Relationship relationship;
    private RelationshipType relationshipByCompany;
}
