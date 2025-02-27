package Controles;

import aplicacion.BaseDatos.BaseDatos;
import aplicacion.application.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class UsuarioController {

    BaseDatos baseDatos = new BaseDatos();

    @FXML
    private TableView<AltaPlantasController.Planta> tablePlantas;

    @FXML
    private TableColumn<AltaPlantasController.Planta, String> colNombrePlanta;

    @FXML
    private TableColumn<AltaPlantasController.Planta, String> colDescripcionPlanta;

    @FXML
    private TableColumn<AltaPlantasController.Planta, String> colNombreCientifico;

    @FXML
    private TableColumn<AltaPlantasController.Planta, String> colPropiedades;

    @FXML
    private TableColumn<AltaPlantasController.Planta, String> colEfectosSecundarios;

    @FXML
    private ObservableList<AltaPlantasController.Planta> plantasList;

    @FXML
    public void initialize() {
        plantasList = FXCollections.observableArrayList();
        colNombrePlanta.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcionPlanta.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colNombreCientifico.setCellValueFactory(new PropertyValueFactory<>("nombreCientifico"));
        colPropiedades.setCellValueFactory(new PropertyValueFactory<>("propiedades"));
        colEfectosSecundarios.setCellValueFactory(new PropertyValueFactory<>("efectosSecundarios"));
        tablePlantas.setItems(plantasList);
        obtenerPlantas();
    }

    @FXML
    void handleCerrarSesion(ActionEvent event){
        openLoginWindow();
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    private void openLoginWindow() {
        try{
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            AnchorPane pane = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(pane));
            stage.show();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void obtenerPlantas() {
        plantasList.clear();
        ArrayList<AltaPlantasController.Planta> plantas = baseDatos.obtenerPlantas();
        if (plantas != null){
            plantasList.addAll(plantas);
        }
    }

    /*@FXML
    void handleBuscar(ActionEvent event){
        String busqueda = txtBusqueda.getText();
        busquedaPlantas();
    }

    @FXML
    public void obtenerPlantasBusqueda(){
    plantasList.clear()

    if (
    }*/

}