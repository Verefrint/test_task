package test.api.forJob.test.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.api.forJob.test.api.dto.CarDTO;
import test.api.forJob.test.api.dto.GarageDTO;
import test.api.forJob.test.mapper.CarMapper;
import test.api.forJob.test.mapper.GarageMapper;
import test.api.forJob.test.service.TransportService;

import java.util.List;

@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("test/v1/api")
@Tag(name = "Transport Controller")
// можно разбить на 2 контроллера и 2 сервиса, но я бы сделал это позже в рефакторинге, если колличество ручек вырастет
//не сильо заполнял свагер, немного лень для тестового, также как тесты написать
public class TransportController {

    private final TransportService service;

    private final CarMapper carMapper;

    private final GarageMapper garageMapper;

    @Operation(summary = "Get all cars")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved cars"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping("car")
    public List<CarDTO> getAllCars() {
        return carMapper.mapList(service.getAllCars());
    }

    @Operation(summary = "Get all garages")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved garages"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping("garage")
    public List<GarageDTO> getAllGarages() {
        return garageMapper.mapList(service.getAllGarages());
    }

    @Operation(summary = "Get a garage by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved garage"),
            @ApiResponse(responseCode = "400", description = "Garage with this id doesn't exists: paramId")
    })
    @GetMapping("garage/{id}")
    public GarageDTO getGarageById(@PathVariable Integer id) {
        log.info("call getGarageById with params: {}", id);
        return garageMapper.map(service.getGarageById(id));
    }

    @Operation(summary = "Get a car by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved car"),
            @ApiResponse(responseCode = "400", description = "Car with this id doesn't exists: paramId")
    })
    @GetMapping("car/{id}")
    public CarDTO getCarById(@PathVariable Integer id) {
        log.info("call getCarById with params: {}", id);
        return carMapper.map(service.getCarById(id));
    }

    @Operation(summary = "Create a new garage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New garage created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping("garage")
    public GarageDTO createGarage(@RequestBody GarageDTO dto) {
        log.info("call createGarage with params: {}", dto);
        return garageMapper.map(service.createGarage(dto));
    }

    @Operation(summary = "Create a new car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "400", description = "Garage overflow max car value is: garageMaxSize")
    })
    @PostMapping("car")
    public CarDTO createCar(@RequestBody CarDTO dto) {
        log.info("call createCar with params: {}", dto);
        return carMapper.map(service.createCar(dto));
    }
}