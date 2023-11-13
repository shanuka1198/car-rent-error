package lk.ijse.rentCar.service.serviceImpl;

import lk.ijse.rentCar.dao.CrudDao;
import lk.ijse.rentCar.dao.customDao.CustomDao;

import lk.ijse.rentCar.dao.daoFactory.DaoType;
import lk.ijse.rentCar.dao.daoFactory.FactoryDao;
import lk.ijse.rentCar.dto.CustomerDto;
import lk.ijse.rentCar.entity.CarsEntity;
import lk.ijse.rentCar.entity.CustomerEntity;
import lk.ijse.rentCar.service.custom.CustomService;

import java.util.List;


public class CustomServiceImpl implements CustomService {
    private CustomDao customDao = FactoryDao.getDao(DaoType.CUSTOMER);

    @Override
    public void save(CustomerDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId(customerDto.getId());
        customerEntity.setUName(customerDto.getUName());
        customerEntity.setFName(customerDto.getFName());
        customerEntity.setLName(customerDto.getLName());
        customerEntity.setStret(customerDto.getStret());
        customerEntity.setCity(customerDto.getCity());
        customerEntity.setDisct(customerDto.getDisct());
        customerEntity.setZip(customerDto.getZip());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setContact(customerDto.getContact());

        customDao.save(customerEntity);
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



    @Override
    public void update(CustomerDto customerDto) {
        CustomerEntity customerEntity=new CustomerEntity();

        customerEntity.setId(customerDto.getId());
        customerEntity.setUName(customerDto.getUName());
        customerEntity.setFName(customerDto.getFName());
        customerEntity.setLName(customerDto.getLName());
        customerEntity.setStret(customerDto.getStret());
        customerEntity.setCity(customerDto.getCity());
        customerEntity.setDisct(customerDto.getDisct());
        customerEntity.setZip(customerDto.getZip());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setContact(customerDto.getContact());


        customDao.update(customerEntity);
    }

    @Override
    public CustomerDto loadCustLabel(String custId) {
        CustomerEntity customerEntity = customDao.loadCustLabel(custId);

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
