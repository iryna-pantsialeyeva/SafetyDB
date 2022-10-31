package model.util;

import model.AnswerType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AnswerTypeConverter implements AttributeConverter<AnswerType, String> {

    @Override
    public String convertToDatabaseColumn(AnswerType attribute) {
        return attribute.getLabel();
    }

    @Override
    public AnswerType convertToEntityAttribute(String dbData) {
        return AnswerType.getAnswerTypeByLabel(dbData);
    }
}
