package lk.ijse.rentCar.service.custom;

import lk.ijse.rentCar.dto.CustomerDto;
import lk.ijse.rentCar.dto.RentDto;

public interface RentService {
    void add(RentDto rentDto);


    CustomerDto search(String custId);
}
