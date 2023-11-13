package lk.ijse.rentCar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer")

public class CustomerEntity  {

    @Id
    @Column(name = "custId")

    private String id;
    @Column(name = "user_name",nullable = false)
    private String uName;
    @Column(name = "first_name",nullable = false)
    private String fName;
    @Column(name = "last_name",nullable = false)
    private String lName;
    @Column(name = "street",nullable = false)
    private String stret;
    @Column(name = "city",nullable = false)
    private String city;
    @Column(name = "district",nullable = false)
    private String disct;
    @Column(name = "zip",nullable = false)
    private String zip;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "contact",nullable = false)
    private Long contact;

    @OneToMany(mappedBy = "customerEntity",targetEntity = RentEntity.class)
     List<RentEntity>rentEntities;
}
