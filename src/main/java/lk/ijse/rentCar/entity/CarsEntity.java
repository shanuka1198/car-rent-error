package lk.ijse.rentCar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="cars")
public class CarsEntity {
    @Id
    @Column(name = "carId")
    private String carId;
    @Column(name = "vehi_number",nullable = false)
    private String VehiNum;
    @Column(name = "car_brand",nullable = false)
    private String carBrand;
    @Column(name = "car_model",nullable = false)
    private String carModel;
    @Column(name = "car_year",nullable = false)
    private Long carYear;
    @Column(name = "car_rate",nullable = false)
    private Long carRate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RentId",nullable = false)
    private RentEntity rentEntity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "car_catergory",
    joinColumns = {@JoinColumn(name = "carId")},
    inverseJoinColumns = {@JoinColumn(name = "catergory_id")})
    List<CatergoryEntity>catergoryEntities;
}
