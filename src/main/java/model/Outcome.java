package model;

import lombok.*;
import model.enums.OutcomeType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Outcome {
    private int id;
    private OutcomeType name;
}
