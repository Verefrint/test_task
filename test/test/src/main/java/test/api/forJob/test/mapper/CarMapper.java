package test.api.forJob.test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import test.api.forJob.test.api.dto.CarDTO;
import test.api.forJob.test.database.entities.CarEntity;

import java.util.List;

@Component
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CarMapper {

    @Mapping(target = "garageId", source = "garage.id")
    public abstract CarDTO map(CarEntity entity);

    @Mapping(target = "garage.id", source = "garageId")
    public abstract CarEntity map(CarDTO carDTO);

    public abstract List<CarDTO> mapList(List<CarEntity> list);
}
