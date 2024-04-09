package test.api.forJob.test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import test.api.forJob.test.api.dto.GarageDTO;
import test.api.forJob.test.database.entities.GarageEntity;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class GarageMapper {

    public abstract GarageEntity map(GarageDTO dto);

    public abstract GarageDTO map(GarageEntity garageEntity);

    public abstract List<GarageDTO> mapList(List<GarageEntity> list);
}
