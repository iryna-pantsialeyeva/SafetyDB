package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Deprecated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyAssessment {
    private int id;
    private RelationshipType nameGivenByCompany;

    public CompanyAssessment(RelationshipType nameGivenByCompany) {
        this.nameGivenByCompany = nameGivenByCompany;
    }
}
