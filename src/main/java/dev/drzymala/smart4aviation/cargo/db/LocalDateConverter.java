package dev.drzymala.smart4aviation.cargo.db;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.util.Date;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<Instant, Date> {

    @Override
    public Date convertToDatabaseColumn(Instant entityValue) {
        return Date.from(entityValue);
    }

    @Override
    public Instant convertToEntityAttribute(Date databaseValue) {
        Instant instant = databaseValue.toInstant();
        return instant;
    }
}
