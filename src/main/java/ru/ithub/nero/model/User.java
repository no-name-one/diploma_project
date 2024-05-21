package ru.ithub.nero.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Introspected
@Serdeable.Serializable
@Serdeable.Deserializable
public class User {
    private UUID id;
    private String name;
    private Integer age;
    private String email;
}

