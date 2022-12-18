package com.example.etrojfx;

import com.example.etrojfx.Models.SalesOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SalesOrderController implements Initializable {
    public Button homeBtn;
    public Button warehouseBtn;
    public Button salesOrderBtn;
    public Button supplierBtn;
    public Button logoutBtn;
    public TableView salesOrderTable;
    public TableColumn itemNo;
    public TableColumn Size;
    public TableColumn Quantity;
    public TableColumn Price;
    public TableColumn Address;


    @FXML
    protected void NavigateToWarehouse(ActionEvent event) throws IOException {
        Stage stage = null;
        Parent myNewScene = null;

        if (event.getSource() == homeBtn){
            stage = (Stage) homeBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("Home.fxml"));
            System.out.println("home");
        } else if (event.getSource() == warehouseBtn){
            stage = (Stage) warehouseBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("Warehouse.fxml"));
            System.out.println("warehouse");
        } else if (event.getSource() == salesOrderBtn) {
            stage=(Stage) salesOrderBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("SalesOrder.fxml"));
            System.out.println("saleorder");
        }
        else if (event.getSource() == supplierBtn) {
            stage=(Stage) supplierBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("SupplierContact.fxml"));
            System.out.println("supplier");
        }
        else if (event.getSource() == logoutBtn) {
            stage = (Stage) logoutBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("Login.fxml"));
            System.out.println("Logout");
        }

        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("My New Scene");
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemNo.setCellValueFactory(new PropertyValueFactory<>("ItemNo"));
        Size.setCellValueFactory(new PropertyValueFactory<>("Size"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        salesOrderTable.setItems(SalesOrderModel);
    }
    private ObservableList<com.example.etrojfx.Models.SalesOrder> SalesOrderModel = FXCollections.observableArrayList(
            new SalesOrder("3434",12.0,12.3,1200,"lahore"),
            new SalesOrder("3434",12.0,12.3,1200,"lahore"),
            new SalesOrder("3434",12.0,12.3,1200,"lahore"));
}
