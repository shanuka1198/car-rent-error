package lk.ijse.rentCar.dao;

import lk.ijse.rentCar.entity.CustomerEntity;

import java.util.List;

public interface CrudDao<T,ID> extends SupperDao{
     void save(T t);

    void update(T t);

    void delete(T t);

   T search (ID id);

    List<T>getll();



}
