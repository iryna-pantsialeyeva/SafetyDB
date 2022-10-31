package model.util;

import model.Outcome;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OutcomeConverter implements AttributeConverter<Outcome, String> {

    @Override
    public String convertToDatabaseColumn(Outcome attribute) {
        return attribute.getLabel();
    }

    @Override
    public Outcome convertToEntityAttribute(String dbData) {
        return Outcome.getOutcomeByLabel(dbData);
    }
}
