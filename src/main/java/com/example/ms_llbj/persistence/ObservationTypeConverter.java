package com.example.ms_llbj.persistence;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.example.ms_llbj.domain.ObservationType;
@Converter(autoApply = false)
public class ObservationTypeConverter implements AttributeConverter<ObservationType, Short> {

    @Override
    public Short convertToDatabaseColumn(ObservationType attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public ObservationType convertToEntityAttribute(Short dbData) {
        return dbData == null ? null : ObservationType.fromCode(dbData);
    }
}
