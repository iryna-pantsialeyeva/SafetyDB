package model.util;

import model.Criteria;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CriteriaConverter implements AttributeConverter<Criteria, String> {

    @Override
    public String convertToDatabaseColumn(Criteria attribute) {
        return attribute.getLabel();
    }

    @Override
    public Criteria convertToEntityAttribute(String dbData) {
        return Criteria.getCriteriaByLabel(dbData);
    }
}
