package test.api.forJob.test.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GarageDTO {

    Integer id;

    @NotNull(message = "name can't be null")
    @Length(min = 1)
    String name;
}
