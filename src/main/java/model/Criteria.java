package model;

import lombok.*;
import model.enums.CriteriaType;

public enum Criteria {
    DEATH("death_result"),
    HOSPITALISATION("bad_feeling");

    private String name;

    Criteria(String name) {
        this.name = name;
    }


}
