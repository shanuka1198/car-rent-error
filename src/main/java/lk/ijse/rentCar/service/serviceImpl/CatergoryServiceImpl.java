package lk.ijse.rentCar.service.serviceImpl;

import lk.ijse.rentCar.dao.CrudDao;
import lk.ijse.rentCar.dao.customDao.CategoryDao;
import lk.ijse.rentCar.dao.daoFactory.DaoType;
import lk.ijse.rentCar.dao.daoFactory.FactoryDao;
import lk.ijse.rentCar.dto.CategoryDto;
import lk.ijse.rentCar.entity.CatergoryEntity;
import lk.ijse.rentCar.service.custom.CategoryService;

public class CatergoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao= FactoryDao.getDao(DaoType.CATOGERY);
    @Override
    public void saveCategory(CategoryDto categoryDto) {
        CatergoryEntity catergoryEntity=new CatergoryEntity();

                catergoryEntity.setCategoId(categoryDto.getCategoId());
                catergoryEntity.setCatrgoName(categoryDto.getCatrgoName());

        categoryDao.save(catergoryEntity);

    }

    @Override
    public void updateCategory(CategoryDto categoryDto) {
        CatergoryEntity catergoryEntity=new CatergoryEntity();

                catergoryEntity.setCategoId(categoryDto.getCategoId());
                catergoryEntity.setCatrgoName(categoryDto.getCatrgoName());

        categoryDao.update(catergoryEntity);

    }

    @Override
    public CategoryDto searchCategory(String catagerId) {
        CatergoryEntity catergoryEntity=categoryDao.search(catagerId);

        return new CategoryDto(
                catergoryEntity.getCategoId(),
                catergoryEntity.getCatrgoName());

    }
}
