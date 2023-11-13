package lk.ijse.rentCar.dao.customDaoImpl;

import lk.ijse.rentCar.dao.customDao.CategoryDao;
import lk.ijse.rentCar.entity.CatergoryEntity;
import lk.ijse.rentCar.entity.CustomerEntity;
import lk.ijse.rentCar.util.HibernetUtill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CatergoryDaoImpl implements CategoryDao {


    @Override
    public void save(CatergoryEntity catergoryEntity) {
        Session session= HibernetUtill.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.persist(catergoryEntity);
        transaction.commit();
    }

    @Override
    public void update(CatergoryEntity catergoryEntity) {
        Session session=HibernetUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.update(catergoryEntity);
        transaction.commit();

    }

    @Override
    public void delete(CatergoryEntity catergoryEntity) {

    }

    @Override
    public CatergoryEntity search(String id) {
        Session session=HibernetUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        CatergoryEntity catergoryEntity=session.get(CatergoryEntity.class, id);
        transaction.commit();
        return catergoryEntity;

    }

    @Override
    public List<CatergoryEntity> getll() {
        return null;
    }
}
