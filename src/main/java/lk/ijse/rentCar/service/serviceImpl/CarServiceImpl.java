package lk.ijse.rentCar.service.serviceImpl;

import lk.ijse.rentCar.dao.customDao.CarDao;
import lk.ijse.rentCar.dao.daoFactory.DaoType;
import lk.ijse.rentCar.dao.daoFactory.FactoryDao;
import lk.ijse.rentCar.dto.CarDto;
import lk.ijse.rentCar.entity.CarsEntity;
import lk.ijse.rentCar.service.custom.CarService;

public class CarServiceImpl implements CarService {
    private CarDao carDao= FactoryDao.getDao(DaoType.CARS);
    @Override
    public void saveCars(CarDto carDto) {
        CarsEntity carsEntity=new CarsEntity();

                carsEntity.setCarId(carDto.getCarId());
                carsEntity.setVehiNum(carDto.getVehiNum());
                carsEntity.setCarBrand(carDto.getCarBrand());
                carsEntity.setCarModel(carDto.getCarModel());
                carsEntity.setCarYear(carDto.getCarYear());
                carsEntity.setCarRate(carDto.getCarRate());




        carDao.save(carsEntity);
    }

    @Override
    public void updateCars(CarDto carDto) {
        CarsEntity carsEntity=new CarsEntity();

        carsEntity.setCarId(carDto.getCarId());
        carsEntity.setVehiNum(carDto.getVehiNum());
        carsEntity.setCarBrand(carDto.getCarBrand());
        carsEntity.setCarModel(carDto.getCarModel());
        carsEntity.setCarYear(carDto.getCarYear());
        carsEntity.setCarRate(carDto.getCarRate());

        carDao.update(carsEntity);
    }

    @Override
    public CarDto searchCar(String carId) {
        CarsEntity carsEntity=carDao.search(carId);

        return new CarDto(
                carsEntity.getCarId(),
                carsEntity.getVehiNum(),
                carsEntity.getCarBrand(),
                carsEntity.getCarModel(),
                carsEntity.getCarYear(),
                carsEntity.getCarRate()
        );

    }
}
