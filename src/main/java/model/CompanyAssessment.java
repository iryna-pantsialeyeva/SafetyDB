package model;

import lombok.*;
import model.enums.RelationshipType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CompanyAssessment {
    private int id;
    @NonNull private RelationshipType nameGivenByCompany;
}
