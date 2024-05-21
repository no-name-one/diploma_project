package ru.ithub.nero.model.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Introspected
@Serdeable.Serializable
@Serdeable.Deserializable
public class UserDto {
    private UUID uuid;
    private String name;
    private Integer age;
    private String email;
}
