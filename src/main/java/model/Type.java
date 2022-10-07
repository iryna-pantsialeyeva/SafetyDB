package model;

import lombok.*;

@Deprecated
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Type {
     private int id;
    @NonNull private ReporterType name;
}
