package model;

import lombok.*;
import model.enums.CriteriaType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Criteria {
    private int id;
    @NonNull private CriteriaType name;
}
