package lk.ijse.rentCar.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.rentCar.dao.daoFactory.DaoType;
import lk.ijse.rentCar.dao.daoFactory.FactoryDao;
import lk.ijse.rentCar.dto.CarDto;
import lk.ijse.rentCar.service.custom.CarService;
import lk.ijse.rentCar.service.serviceFactory.FactoryType;
import lk.ijse.rentCar.service.serviceFactory.ServiceFactory;
import lk.ijse.rentCar.service.serviceImpl.CarServiceImpl;

public class CarsFormController {
    public TextField txtCarId;
    public TextField txtVehicleNum;
    public TextField txtBrand;
    public TextField txtModel;
    public TextField txtYear;
    public TextField txtRate;

    private CarService carService= ServiceFactory.getFact(FactoryType.CARS);
    public void btnCarsSaveOnAction(ActionEvent actionEvent) {
        String carId=txtCarId.getText();
        String VehiNum=txtVehicleNum.getText();
        String carBrand=txtBrand.getText();
        String carModel=txtModel.getText();
        Long carYear= Long.valueOf(txtYear.getText());
        Long carRate= Long.valueOf(txtRate.getText());

        CarDto carDto=new CarDto(carId,VehiNum,carBrand,carModel,carYear,carRate);

        try {
            carService.saveCars(carDto);
            Clear();
            new Alert(Alert.AlertType.CONFIRMATION, "save Car").show();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "Didn't save car").show();
        }


    }

    public void btnCarClearOnAction(ActionEvent actionEvent) {
        Clear();
    }
    public void Clear(){
        txtCarId.setText("");
        txtVehicleNum.setText("");
        txtBrand.setText("");
        txtModel.setText("");
        txtYear.setText("");
        txtRate.setText("");
    }

    public void btnCarsUpdateOnAction(ActionEvent actionEvent) {
        String carId=txtCarId.getText();
        String VehiNum=txtVehicleNum.getText();
        String carBrand=txtBrand.getText();
        String carModel=txtModel.getText();
        Long carYear= Long.valueOf(txtYear.getText());
        Long carRate= Long.valueOf(txtRate.getText());

        CarDto carDto=new CarDto(carId,VehiNum,carBrand,carModel,carYear,carRate);
        try {
            carService.updateCars(carDto);
            Clear();
            new Alert(Alert.AlertType.CONFIRMATION, "Updated Car").show();
        }catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Didn't update car").show();

        }
    }

    public void btnTxtCatIdOnAction(ActionEvent actionEvent) {
        String carId=txtCarId.getText();

        CarDto carDto=carService.searchCar(carId);
        if(carDto!=null){
            txtCarId.setText(carDto.getCarId());
            txtVehicleNum.setText(carDto.getVehiNum());
            txtBrand.setText(carDto.getCarBrand());
            txtModel.setText(carDto.getCarModel());
            txtYear.setText(String.valueOf(carDto.getCarYear()));
            txtRate.setText(String.valueOf(carDto.getCarRate()));

        }
    }
}
