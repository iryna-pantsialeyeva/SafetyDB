package model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Outcome {
    private int id;
    @NonNull
    private String name;
}
