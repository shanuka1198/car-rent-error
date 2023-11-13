package lk.ijse.rentCar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Rent")
public class RentEntity {
    @Id
    @Column(name = "RentId")
    private String rentId;
    @Column(name = "Start_Date",nullable = false)
    private String StaDate;
    @Column(name = "End_Date",nullable = false)
    private String EndDate;
    @Column(name = "Addavance_pay",nullable = false)
    private Double AddvaPaye;
    @Column(name = "Deposit_pay",nullable = false)
    private Double DepopPay;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "custId",nullable = false)
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "rentEntity",targetEntity = CarsEntity.class)
    List<CarsEntity>carsEntities;
}
