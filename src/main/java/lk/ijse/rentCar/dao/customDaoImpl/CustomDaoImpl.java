package lk.ijse.rentCar.dao.customDaoImpl;

import lk.ijse.rentCar.dao.customDao.CustomDao;
import lk.ijse.rentCar.entity.CustomerEntity;
import lk.ijse.rentCar.util.HibernetUtill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class CustomDaoImpl implements CustomDao {


    @Override
    public void save(CustomerEntity customerEntity) {
        Session session=HibernetUtill.getSessionFactory().openSession();
         Transaction transaction=session.beginTransaction();
        session.persist(customerEntity);
        transaction.commit();
    }




    @Override
    public void update(CustomerEntity customerEntity) {
        Session session=HibernetUtill.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.update(customerEntity);
        transaction.commit();

    }

    @Override
    public void delete(CustomerEntity customerEntity) {

    }


    @Override
    public CustomerEntity search(String id) {
        Session session=HibernetUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        CustomerEntity customerEntity=session.get(CustomerEntity.class, id);
        transaction.commit();
        return customerEntity;

    }

    @Override
    public List<CustomerEntity> getll() {
        return null;
    }

    @Override
    public CustomerEntity loadCustLabel(String custId) {

        Session session=HibernetUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        CustomerEntity customerEntity=session.get(CustomerEntity.class, custId);
        transaction.commit();
        return customerEntity;

    }
}
