package model;

import lombok.*;
import model.enums.ReporterType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Type {
     private int id;
    @NonNull private ReporterType name;
}
