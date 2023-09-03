package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import java.io.IOException;

import org.springframework.stereotype.Service;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("gerenciaUsr.fxml")
public class UsuarioController extends Controller {

//GERENCIA USR

    @FXML
    private TextField CargoUsr;

    @FXML
    private DatePicker dataDataNascimento;

    @FXML
    private TextField idUsr;

    @FXML
    private TextField inpContatoUsuario;

    @FXML
    private TextField inpContatoUsuario1;

    @FXML
    private TextField inpCpfCnpjUsuario;

    @FXML
    private TextField inpNomeUsuario;

    @FXML
    private TextField inpRGUsuario;

    @FXML
    private TextField inpRuUsuario;

    @FXML
    private TextField inpSobrenomeUsuario;

    @FXML
    private Button deleteUsr;

    @FXML
    private Button procuraUsr;

    @FXML
    private Button criaUsr;


    //BOTÕES DA NAV BAR


    @FXML
    private Button adm;

    @FXML
    private Button fleet;

    @FXML
    private Button main;

    @FXML
    private Button ordemservico;

    @FXML
    private Button logout;

    public UsuarioController(){


    }

    @FXML
    public void openMainScreen(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent menuPane = loader.load();

        
        MenuController menuController = loader.getController();
        

        
        main.getScene().setRoot(menuPane);
    } catch (Exception e) {
        
        e.printStackTrace();
        }
    }

    @FXML
    public void openAdmScreen(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gerenciaUsr.fxml"));
            Parent gerenciaUsrPane = loader.load();
            
            main.getScene().setRoot(gerenciaUsrPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void openNovoUserScreen(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("novoUsr.fxml"));
            Parent novoUsrPane = loader.load();
            
            criaUsr.getScene().setRoot(novoUsrPane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openCarroScreen(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("carro.fxml"));
            Parent carroPane = loader.load();
            
            main.getScene().setRoot(carroPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
