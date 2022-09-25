package model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private int id;
    @NonNull private String email;
    @NonNull private String password;
    @NonNull private Reporter reporter;
    @NonNull private boolean isActive;
}
