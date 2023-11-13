package lk.ijse.rentCar.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.rentCar.dto.CustomerDto;
import lk.ijse.rentCar.service.SupperService;
import lk.ijse.rentCar.service.custom.CustomService;
import lk.ijse.rentCar.service.serviceFactory.FactoryType;
import lk.ijse.rentCar.service.serviceFactory.ServiceFactory;


public class CustomerFormController {
    public TextField txtCustId;
    public TextField txtUserName;
    public TextField txtFName;
    public TextField txtLName;
    public TextField txtStreet;
    public TextField txtCity;
    public TextField txtDistrict;
    public TextField txtPostCode;
    public TextField txtEmail;
    public TextField txtContact;
   private CustomService customService= ServiceFactory.getFact(FactoryType.CUSTOMER);
    public void btnCustIdSearchOnAction(ActionEvent actionEvent) {
    btnTxtCustIdOnAction(actionEvent);
    }

    public void btnCustSaveOnAction(ActionEvent actionEvent) {
        String custId = txtCustId.getText();
        String usName = txtUserName.getText();
        String firstName = txtFName.getText();
        String lastName = txtLName.getText();
        String street = txtStreet.getText();
        String city = txtCity.getText();
        String district = txtDistrict.getText();
        String zip = txtPostCode.getText();
        String email = txtEmail.getText();
        Long contact = Long.valueOf(txtContact.getText());

        CustomerDto customerDto = new CustomerDto(custId, usName, firstName, lastName, street, city, district, zip, email, contact);

        try {
            customService.save(customerDto);
            clear();
            new Alert(Alert.AlertType.CONFIRMATION, "Saved Customer").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Didn't save customer").show();
        }

    }
    public void clear() {
        txtCustId.setText("");
        txtUserName.setText("");
        txtFName.setText("");
        txtLName.setText("");
        txtStreet.setText("");
        txtCity.setText("");
        txtDistrict.setText("");
        txtPostCode.setText("");
        txtEmail.setText("");
        txtContact.setText("");
    }

    public void btnCustUpdateOnAction(ActionEvent actionEvent) {
        String custId = txtCustId.getText();
        String usName = txtUserName.getText();
        String firstName = txtFName.getText();
        String lastName = txtLName.getText();
        String street = txtStreet.getText();
        String city = txtCity.getText();
        String district = txtDistrict.getText();
        String zip = txtPostCode.getText();
        String email = txtEmail.getText();
        Long contact = Long.valueOf(txtContact.getText());

        CustomerDto customerDto = new CustomerDto(custId, usName, firstName, lastName, street, city, district, zip, email, contact);

        try {
            customService.update(customerDto);
            new Alert(Alert.AlertType.CONFIRMATION, "Updated Customer").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Didn't update customer").show();
        }

    }

    public void btnCustDelOnAction(ActionEvent actionEvent) {



        }



    public void btnTxtCustIdOnAction(ActionEvent actionEvent) {
        String custId=txtCustId.getText();

        CustomerDto dto=customService.search(custId);
       if(dto !=null) {
           txtCustId.setText(dto.getId());
           txtUserName.setText(dto.getUName());
           txtFName.setText(dto.getFName());
           txtLName.setText(dto.getLName());
           txtStreet.setText(dto.getStret());
           txtCity.setText(dto.getCity());
           txtDistrict.setText(dto.getDisct());
           txtPostCode.setText(dto.getZip());
           txtEmail.setText(dto.getEmail());
           txtContact.setText(String.valueOf(dto.getContact()));
       }

    }

    public void btnCustIClearOnAction(ActionEvent actionEvent) {

        clear();
    }
}
