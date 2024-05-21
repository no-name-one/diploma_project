package ru.ithub.nero.model.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
@Serdeable.Serializable
@Serdeable.Deserializable
public class CreateUserDto {

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 60, message = "Name should be between 2 and 40 characters")
    private String name;

    @Min(value = 0, message = "Age should be grater than 0")
    @Max(value = 200, message = "Age should be between 0 and 200")
    private Integer age;

    @NotEmpty(message = "Email should not be empty")
    @Size(min = 11, max = 255, message = "Email should be between 11 and 255 characters")
    private String email;

    @FutureOrPresent(message = "Date should be present or future")
    @NotEmpty(message = "Date should not be empty")
    private LocalDate date;
}
