package ru.fedusiv.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.fedusiv.entities.Group;
import ru.fedusiv.entities.Student;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;

@Component
public class TemplateJsonSerializer<T> extends StdSerializer<T> {

    protected TemplateJsonSerializer() {
        this(null);
    }

    public TemplateJsonSerializer(Class<T> t) {
        super(t);
    }

    private void serializeRec(T entity, JsonGenerator generator, SerializerProvider serializerProvider, int level)
            throws IOException, IllegalAccessException {

        generator.writeStartObject();
        Class<?> type = entity.getClass();

        for (Field field : type.getDeclaredFields()) {

            field.setAccessible(true);

            Class<?> fieldType = field.getType();

            if (fieldType.equals(String.class)) {
                generator.writeStringField(field.getName(), (String) field.get(entity));
            }

            else if (fieldType.equals(Long.class) || fieldType.equals(Integer.class)) {
                generator.writeStringField(field.getName(), String.valueOf(field.get(entity)));
            }

            else if (fieldType.equals(LocalDate.class)) {
                generator.writeStringField(field.getName(), field.get(entity).toString());
            }

            else if (fieldType.equals(Student.class) || fieldType.equals(Group.class)) {
                if (level <= 1) {
                    generator.writeFieldName(field.getName());
                    serializeRec( (T) field.get(entity), generator, serializerProvider, ++level);
                }
            }

            else if (fieldType.equals(List.class)) {
                if (level < 1) {
                    generator.writeFieldName(field.getName());
                    generator.writeStartArray();
                    for (T item : (List<T>) field.get(entity)) {
                        serializeRec(item, generator, serializerProvider, ++level);
                    }
                    generator.writeEndArray();
                }
            }

        }

        generator.writeEndObject();
    }

    @SneakyThrows
    @Override
    public void serialize(T entity, JsonGenerator generator, SerializerProvider serializerProvider) throws IOException {
        serializeRec(entity, generator, serializerProvider, 0);
    }

}
