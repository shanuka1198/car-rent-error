package lk.ijse.rentCar.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CarDto {
    private String carId;
    private String VehiNum;
    private String carBrand;
    private String carModel;
    private Long carYear;
    private Long carRate;

}
