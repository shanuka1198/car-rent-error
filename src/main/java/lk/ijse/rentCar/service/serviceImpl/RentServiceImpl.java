package lk.ijse.rentCar.service.serviceImpl;

import lk.ijse.rentCar.dao.customDao.CustomDao;
import lk.ijse.rentCar.dao.customDao.RentDao;
import lk.ijse.rentCar.dao.customDaoImpl.RentDaoImpl;
import lk.ijse.rentCar.dao.daoFactory.DaoType;
import lk.ijse.rentCar.dao.daoFactory.FactoryDao;
import lk.ijse.rentCar.dto.CustomerDto;
import lk.ijse.rentCar.dto.RentDto;
import lk.ijse.rentCar.entity.CustomerEntity;
import lk.ijse.rentCar.entity.RentEntity;
import lk.ijse.rentCar.service.custom.RentService;

public class RentServiceImpl implements RentService {
    private RentDao rentDao= FactoryDao.getDao(DaoType.RENT);

    private CustomDao customDao=FactoryDao.getDao(DaoType.CUSTOMER);
    @Override
    public void add(RentDto rentDto) {
        RentEntity rentEntity=new RentEntity();

        rentEntity.setRentId(rentDto.getRentId());
        rentEntity.setStaDate(rentDto.getStaDate());
        rentEntity.setEndDate(rentDto.getEndDate());
        rentEntity.setAddvaPaye(rentDto.getAddvaPaye());
        rentEntity.setDepopPay(rentDto.getDepopPay());


        rentDao.save(rentEntity);
    }

    @Override
    public CustomerDto search(String custId) {
        CustomerEntity customerEntity = customDao.search(custId);

        return new CustomerDto(
                customerEntity.getId(),
                customerEntity.getUName(),
                customerEntity.getFName(),
                customerEntity.getLName(),
                customerEntity.getStret(),
                customerEntity.getCity(),
                customerEntity.getDisct(),
                customerEntity.getZip(),
                customerEntity.getEmail(),
                customerEntity.getContact());

    }


}
