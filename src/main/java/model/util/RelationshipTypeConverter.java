package model.util;

import model.RelationshipType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RelationshipTypeConverter implements AttributeConverter<RelationshipType, String> {

    @Override
    public String convertToDatabaseColumn(RelationshipType attribute) {
        return attribute.getLabel();
    }

    @Override
    public RelationshipType convertToEntityAttribute(String dbData) {
        return RelationshipType.getRelationshipTypeByLabel(dbData);
    }
}
