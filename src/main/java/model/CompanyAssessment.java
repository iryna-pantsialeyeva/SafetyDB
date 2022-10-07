package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyAssessment {
    private int id;
    private RelationshipType nameGivenByCompany;
}
