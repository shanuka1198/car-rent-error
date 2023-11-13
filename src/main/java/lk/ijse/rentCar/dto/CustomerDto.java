package lk.ijse.rentCar.dto;


import lk.ijse.rentCar.entity.RentEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CustomerDto {

    private String id;
    private String uName;
    private String fName;
    private String lName;
    private String stret;
    private String city;
    private String disct;
    private String zip;
    private String email;
    private Long contact;


}
