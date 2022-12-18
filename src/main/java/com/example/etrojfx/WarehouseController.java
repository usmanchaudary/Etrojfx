package com.example.etrojfx;

import com.example.etrojfx.Globals.Global;
import com.example.etrojfx.HelperFunctions.Helpers;
import com.example.etrojfx.Models.Product;
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

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class WarehouseController implements Initializable {
    public TableView<Product> table;
    public TableColumn itemNo;
    public TableColumn Manufacturer;
    public TableColumn Size;
    public TableColumn Cost;
    public TableColumn Stock;
    public TableColumn Inventry;

    public Button homeBtn;
    public Button warehouseBtn;
    public Button salesOrderBtn;
    public Button supplierBtn;
    public Button logoutBtn;


    private ArrayList<Product> productsArray = new ArrayList<>(Arrays.asList(new Product("B24","Local",12.00,12.00,6.0,12000.00),
                    new Product("B24","Local",12.00,12.00,6.0,12000.00),
                    new Product("B24","Local",12.00,12.00,6.0,12000.00) ));


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
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        FileOutputStream file = null;
        try {
            file = new FileOutputStream(Global.DirectoryPath+"DataFiles\\Warehouse.txt",false);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(productsArray);
            out.flush();
            out.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        itemNo.setCellValueFactory(new PropertyValueFactory<>("ItemNo"));
        Manufacturer.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
        Size.setCellValueFactory(new PropertyValueFactory<>("Size"));
        Cost.setCellValueFactory(new PropertyValueFactory<>("CostPerItem"));
        Stock.setCellValueFactory(new PropertyValueFactory<>("StockQty"));
        Inventry.setCellValueFactory(new PropertyValueFactory<>("InventryValue"));
        ArrayList<Product> products = new ArrayList<>();
        ObservableList<Product> ProductModel = FXCollections.observableArrayList();
        try {
            FileInputStream inputfile = new FileInputStream(Global.DirectoryPath+"DataFiles\\Warehouse.txt");
            ObjectInputStream in = new ObjectInputStream(inputfile);
            products = (ArrayList<Product>) in.readObject();
            ProductModel = FXCollections.observableArrayList(products);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        // Method for deserialization of object
        table.setItems(ProductModel);
    }

}
