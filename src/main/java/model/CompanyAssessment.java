package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import model.enums.RelationshipType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyAssessment {
    private int id;
    private RelationshipType nameGivenByCompany;
}
