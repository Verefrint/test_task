package test.api.forJob.test.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.api.forJob.test.database.entities.CarEntity;

public interface CarsRepository extends JpaRepository<CarEntity, Integer> {
}
