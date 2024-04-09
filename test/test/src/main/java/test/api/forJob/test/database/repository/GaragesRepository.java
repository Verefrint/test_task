package test.api.forJob.test.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.api.forJob.test.database.entities.GarageEntity;

public interface GaragesRepository extends JpaRepository<GarageEntity, Integer> {
}
