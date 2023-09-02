package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import javafx.fxml.Initializable;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifnmg.smrf.servicos.AutenticacaoServico;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("carro.fxml")
public class CarroController extends Controller {

    //novo carro
    @FXML
    private Button adm;

    @FXML
    private Button cadastraCarro;

    @FXML
    private Button cancelaCarro;

    @FXML
    private Button fleet;

    @FXML
    private Button logout;

    @FXML
    private Button retorno;

    @FXML
    private Button main;

    @FXML
    private Button ordemservico;

    @FXML
    private AnchorPane contentPane;

    //reserva de carro

    @FXML
    private Button escolhecondutor;

    @FXML
    private Button escolhemodelo;

    public CarroController(){


    }

    @FXML
    private void openMainScreen(ActionEvent event) {
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
    public void openCarroScreen(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("carro.fxml"));
        AnchorPane carroPane = loader.load();

        
        CarroController carroController = loader.getController();
        
        //se alguém mexer aki EU MATO ass: Proenca
        
        //fleet.getChildren().clear();
       // fleet.getChildren().add(carroPane);
    } catch (Exception e) {
        
        e.printStackTrace();
        }
    }

    @FXML
    private void openRetornoScreen(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("registraRetorno.fxml"));
            Parent registraRetornoPane = loader.load();
            //AnchorPane registraRetornoPane = loader.load();
           
            //CarroController carroController = loader.getController();

            retorno.getScene().setRoot(registraRetornoPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}