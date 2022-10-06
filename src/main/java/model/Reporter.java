package model;


import lombok.*;
import model.enums.ReporterType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Reporter {
    private int id;
    private String fullName;
    private ReporterType type;
    }
