package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AdverseReaction {

    private int id;
    private Date reportDate;
    private String description;
    private String suspectedDrug;
    private Outcome outcome;
    private Criteria criteria;
    private Type type;
    private Reporter fullName;
}
