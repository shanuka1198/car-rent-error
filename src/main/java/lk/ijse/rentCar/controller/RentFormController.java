package lk.ijse.rentCar.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.rentCar.dto.CustomerDto;
import lk.ijse.rentCar.dto.RentDto;
import lk.ijse.rentCar.entity.CustomerEntity;
import lk.ijse.rentCar.service.custom.CustomService;
import lk.ijse.rentCar.service.custom.RentService;
import lk.ijse.rentCar.service.serviceFactory.FactoryType;
import lk.ijse.rentCar.service.serviceFactory.ServiceFactory;
import lk.ijse.rentCar.service.serviceImpl.RentServiceImpl;

import java.io.IOException;

public class RentFormController {
    public TextField txtRentStartDate;
    public TextField txtRentEndDate;
    public TextField txtAdavancePay;
    public TextField txtDepositPay;
    public TextField txtRentId;

    public DatePicker datePicker;
    public TextField txtRentCustId;
    public TextField txtRentCarId;
    public Label labelCustId;
    public Label labelCarId;
    public AnchorPane rootRent;


    private RentService rentService= ServiceFactory.getFact(FactoryType.RENT);
    private CustomService customService=ServiceFactory.getFact(FactoryType.CUSTOMER);
    private CustIdViewController custIdViewController;




    public void btnAddRentOnAction(ActionEvent actionEvent) {
        String rentId=txtRentId.getText();
        String SDate= txtRentStartDate.getText();
        String EDate=txtRentEndDate.getText();
        Double AddPaye= Double.parseDouble(txtAdavancePay.getText());
        Double DepPay= Double.parseDouble(txtDepositPay.getText());


        RentDto rentDto=new RentDto(rentId,SDate,EDate,AddPaye,DepPay);
        try {
            rentService.add(rentDto);
            new Alert(Alert.AlertType.CONFIRMATION,"Rent Details added").show();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Can't Rent Details added").show();
        }



    }


    public void btnRentCustSearchOnAction(ActionEvent actionEvent) throws IOException {

        Parent root=FXMLLoader.load(this.getClass().getResource("/view/CustId_View.fxml"));

        Scene scene=new Scene(root);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Customer ID Details");
        primaryStage.show();

        String custId=txtRentCustId.getText();


        CustomerDto customerDto=customService.loadCustLabel(custId);
        if(customerDto!=null){
            custIdViewController.lblCustId.setText(customerDto.getId());
            custIdViewController.lblUserName.setText(customerDto.getUName());
            custIdViewController.lblFName.setText(customerDto.getFName());
            custIdViewController.lblLName.setText(customerDto.getLName());
            custIdViewController.lblStreet.setText(customerDto.getStret());
            custIdViewController.lblCity.setText(customerDto.getCity());
            custIdViewController.lblDistrict.setText(customerDto.getDisct());
            custIdViewController.lblPostCode.setText(customerDto.getZip());
            custIdViewController.lblEmail.setText(customerDto.getEmail());
            custIdViewController.lblContact.setText(String.valueOf(customerDto.getContact()));

        }
    }







    public void btnRentCarIdOnAction(ActionEvent actionEvent) {
    }
}
