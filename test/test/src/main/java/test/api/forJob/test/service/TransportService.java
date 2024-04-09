package test.api.forJob.test.service;

import test.api.forJob.test.api.dto.CarDTO;
import test.api.forJob.test.api.dto.GarageDTO;
import test.api.forJob.test.database.entities.CarEntity;
import test.api.forJob.test.database.entities.GarageEntity;

import java.util.List;
import java.util.Optional;

public interface TransportService {

    /*
    * Получить список всех машин из таблицы cars
    *
    * @return list всех кортеежей
     */
    List<CarEntity> getAllCars();

    /*
     * Получить список всех гаражей из таблицы garages
     *
     * @return list всех кортеежей из таблицы
     */
    List<GarageEntity> getAllGarages();

    /*
     * Получить гараж по id
     *
     * @param id - id гаража в таблицу
     * @return list всех кортеежей из таблицы
     */
    GarageEntity getGarageById(Integer id);

    /*
     * Получить список всех гаражей из таблицы garages
     *
     * @param id - id машины в таблице
     * @return кортеж из таблицы в случае, если такая запись есть, иначе null
     */
    CarEntity getCarById(Integer id);

    /*
     * Получить список всех гаражей из таблицы garages
     *
     * @param name - имя гаража
     * @return новый кортеж из отношения garages, заполнены все поля
     */
    GarageEntity createGarage(GarageDTO name);

    /*
     * Получить список всех гаражей из таблицы garages
     *
     * @param CarDTO - дто машины(без id)
     * @return новый кортеж из отношения cars, заполнены все поля
     */
    CarEntity createCar(CarDTO carDTO);
}
