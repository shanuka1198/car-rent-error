package lk.ijse.rentCar.dao.customDaoImpl;

import lk.ijse.rentCar.controller.CustIdViewController;
import lk.ijse.rentCar.controller.RentFormController;
import lk.ijse.rentCar.dao.customDao.RentDao;
import lk.ijse.rentCar.dto.CustomerDto;
import lk.ijse.rentCar.entity.CustomerEntity;
import lk.ijse.rentCar.entity.RentEntity;
import lk.ijse.rentCar.util.HibernetUtill;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RentDaoImpl implements RentDao {
    @Override
    public void save(RentEntity rentEntity) {
        Session session=HibernetUtill.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.save(rentEntity);
        transaction.commit();
    }


    @Override
    public void update(RentEntity rentEntity) {

    }

    @Override
    public void delete(RentEntity rentEntity) {

    }

    @Override
    public RentEntity search(String id) {

     return null;
    }



    @Override
    public List<RentEntity> getll() {
        return null;
    }
}
