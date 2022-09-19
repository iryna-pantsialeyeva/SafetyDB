package model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Criteria {
    private int id;
    @NonNull
    private String name;
}
