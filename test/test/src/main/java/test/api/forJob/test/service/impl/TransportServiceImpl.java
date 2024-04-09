package test.api.forJob.test.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.api.forJob.test.api.dto.CarDTO;
import test.api.forJob.test.api.dto.GarageDTO;
import test.api.forJob.test.database.entities.CarEntity;
import test.api.forJob.test.database.entities.GarageEntity;
import test.api.forJob.test.exception.CarNotFoundException;
import test.api.forJob.test.exception.GarageNotFoundException;
import test.api.forJob.test.exception.GarageOverflowException;
import test.api.forJob.test.database.repository.CarsRepository;
import test.api.forJob.test.database.repository.GaragesRepository;
import test.api.forJob.test.service.TransportService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TransportServiceImpl implements TransportService {

    private final CarsRepository carsRepository;

    private final GaragesRepository garagesRepository;

    @Value("${garage.maxCars}")
    private Long maxCars;

    @Override
    public List<CarEntity> getAllCars() {
        return carsRepository.findAll();
    }

    @Override
    public List<GarageEntity> getAllGarages() {
        return garagesRepository.findAll();
    }

    @Override
    public GarageEntity getGarageById(Integer id) {
        return garagesRepository.findById(id)
                .orElseThrow(() -> new GarageNotFoundException(String.valueOf(id)));
    }

    @Override
    public CarEntity getCarById(Integer id) {// отошел от тз, решил сделать как с гаражом
        return carsRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(String.valueOf(id)));
    }

    @Override
    @Transactional(readOnly = false)
    public GarageEntity createGarage(GarageDTO dto) {
        return garagesRepository.saveAndFlush(
                GarageEntity
                        .builder()
                        .name(dto.getName())
                        .cars(new ArrayList<>())
                        .build()
        );
    }

    @Override
    @Transactional(readOnly = false)
    public CarEntity createCar(CarDTO carDTO) {
        GarageEntity garage = garagesRepository.findById(carDTO.getGarageId())
                .orElseThrow(() -> new GarageNotFoundException(String.valueOf(carDTO.getGarageId())));

        validateGarageBeforeSavingCar(garage);

        return carsRepository.saveAndFlush(
                CarEntity
                        .builder()
                        .brand(carDTO.getBrand())
                        .driverName(carDTO.getDriverName())
                        .garage(garage)
                        .build()
        );
    }

    private void validateGarageBeforeSavingCar(GarageEntity garage) {
        if (garage.getCars().size() > maxCars) {
            throw new GarageOverflowException(String.valueOf(maxCars));
        }
    }
}
