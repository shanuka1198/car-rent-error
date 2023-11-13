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
@Table(name = "catergory")

public class CatergoryEntity {
    @Id
    @Column(name = "catergory_id")
    private String categoId;
    @Column(name = "catergory_name", nullable = false)
    private String catrgoName;

    @ManyToMany(mappedBy = "catergoryEntities",targetEntity = CarsEntity.class)
    List<CarsEntity>carsEntities;
}
