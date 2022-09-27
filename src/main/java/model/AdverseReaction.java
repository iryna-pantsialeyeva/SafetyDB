package model;


import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class AdverseReaction {

    private int id;
    @NonNull private Date reportDate;
    @NonNull private String description;
    @NonNull private String suspectedDrug;
    @NonNull private Outcome outcome;
    @NonNull private Criteria criteria;
    private User user;
    @NonNull private Reporter reporter;
    @NonNull private Relationship relationship;
    @Setter CompanyAssessment relationshipByCompany;
}
