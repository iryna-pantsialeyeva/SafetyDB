package model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Type {
     private int id;
    @NonNull
    private String name;
}
