package com.example.ms_llbj.persistence;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.example.ms_llbj.domain.ObservationType;

@Converter(autoApply = false)
public class ObservationTypeConverter implements AttributeConverter<ObservationType, String> {

    @Override
    public String convertToDatabaseColumn(ObservationType attribute) {
        return attribute == null ? null : String.valueOf(attribute.getCode());
    }

    @Override
    public ObservationType convertToEntityAttribute(String dbData) {
        return dbData == null ? null : ObservationType.fromCode(Short.parseShort(dbData));
    }
}