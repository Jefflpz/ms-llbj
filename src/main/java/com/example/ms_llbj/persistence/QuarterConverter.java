package com.example.ms_llbj.persistence;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.example.ms_llbj.domain.Quarter;
@Converter(autoApply = false)
public class QuarterConverter implements AttributeConverter<Quarter, Short> {

    @Override
    public Short convertToDatabaseColumn(Quarter attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public Quarter convertToEntityAttribute(Short dbData) {
        return dbData == null ? null : Quarter.fromCode(dbData);
    }
}