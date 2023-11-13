package lk.ijse.rentCar.service.custom;

import lk.ijse.rentCar.dto.CarDto;
import lk.ijse.rentCar.service.SupperService;

public interface CarService extends SupperService {
    void saveCars(CarDto carDto);

    void updateCars(CarDto carDto);

    CarDto searchCar(String carId);
}
