package model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Reporter {
    private int id;
    @NonNull private String fullName;
    @NonNull private Type type;
    }
