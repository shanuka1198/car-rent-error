package lk.ijse.rentCar.dao.customDaoImpl;

import lk.ijse.rentCar.dao.customDao.CarDao;
import lk.ijse.rentCar.entity.CarsEntity;
import lk.ijse.rentCar.entity.CustomerEntity;
import lk.ijse.rentCar.util.HibernetUtill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CarDaoImpl implements CarDao {


    @Override
    public void save(CarsEntity carsEntity) {
        Session session= HibernetUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.persist(carsEntity);
        transaction.commit();
    }

    @Override
    public void update(CarsEntity carsEntity) {
        Session session=HibernetUtill.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.update(carsEntity);
        transaction.commit();

    }

    @Override
    public void delete(CarsEntity carsEntity) {

    }

    @Override
    public CarsEntity search(String id) {

        Session session=HibernetUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        CarsEntity carEntity=session.get(CarsEntity.class, id);
        transaction.commit();
        return carEntity;

    }

    @Override
    public List<CarsEntity> getll() {
        return null;
    }
}
