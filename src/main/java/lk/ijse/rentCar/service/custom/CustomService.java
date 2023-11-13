package lk.ijse.rentCar.service.custom;

import lk.ijse.rentCar.dto.CustomerDto;
import lk.ijse.rentCar.service.SupperService;

public interface CustomService extends SupperService {

      void save(CustomerDto customerDto);

      CustomerDto search(String custId);

      void update(CustomerDto customerDto);


      CustomerDto loadCustLabel(String custId);
}
