package lk.ijse.rentCar.dto;

import jakarta.persistence.Entity;
import lk.ijse.rentCar.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class RentDto {
    private String rentId;
    private String StaDate;
    private String EndDate;
    private Double AddvaPaye;
    private Double DepopPay;


}
