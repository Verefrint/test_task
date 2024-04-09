package test.api.forJob.test.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarDTO {

    Integer id;

    @NotNull(message = "driverName can't be null")
    @Length(min = 1, message = "driverName must be at least 1 character long")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "driverName can only contain letters")
    String driverName;

    @NotNull(message = "brand can't be null")
    @Length(min = 1, message = "brand must be at least 1 character long")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "brand can only contain letters")
    String brand;

    @NotNull(message = "car must have a garage")
    Integer garageId;
}