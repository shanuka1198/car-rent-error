package lk.ijse.rentCar.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.rentCar.dto.CategoryDto;
import lk.ijse.rentCar.service.custom.CategoryService;
import lk.ijse.rentCar.service.serviceFactory.FactoryType;
import lk.ijse.rentCar.service.serviceFactory.ServiceFactory;

public class CarCatogeryFormController {
    public TextField txtCatId;
    public TextField txtCatName;

    private CategoryService categoryService= ServiceFactory.getFact(FactoryType.CATERGORY);
    public void btnCarCatSearchOnAction(ActionEvent actionEvent) {

        txtCatIdSearchOnAction(actionEvent);
    }

    public void btnCarCatSaveOnAction(ActionEvent actionEvent) {
        String catagerId=txtCatId.getText();
        String catagerName=txtCatName.getText();

        CategoryDto categoryDto=new CategoryDto(catagerId,catagerName);

        try {
            categoryService.saveCategory(categoryDto);
            new Alert(Alert.AlertType.CONFIRMATION, "Saved Catergory").show();
            clear();

        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "Didn't save Catergory").show();
        }


    }

    public void btnCarCatUpdateOnAction(ActionEvent actionEvent) {
        String catagerId=txtCatId.getText();
        String catagerName=txtCatName.getText();

        CategoryDto categoryDto=new CategoryDto(catagerId,catagerName);
        try {
            categoryService.updateCategory(categoryDto);
            new Alert(Alert.AlertType.CONFIRMATION, "Update Catergory").show();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "Didn't Update Catergory").show();
        }

    }

    public void btnCarCatDeleteOnAction(ActionEvent actionEvent) {

    }

    public void txtCatIdSearchOnAction(ActionEvent actionEvent) {
        String catagerId=txtCatId.getText();
        CategoryDto categoryDto=categoryService.searchCategory(catagerId);
        if(categoryDto!=null){
            txtCatId.setText(categoryDto.getCategoId());
            txtCatName.setText(categoryDto.getCatrgoName());
        }
    }

    public void clear(){
        txtCatId.setText("");
        txtCatName.setText("");
    }
    public void btnCarCatClearOnAction(ActionEvent actionEvent) {
        clear();
    }
}
