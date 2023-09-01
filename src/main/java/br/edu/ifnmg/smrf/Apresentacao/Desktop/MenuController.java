package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import javafx.fxml.Initializable;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifnmg.smrf.servicos.AutenticacaoServico;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.event.Event;
import javafx.fxml.FXML;
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
@FxmlView("menu.fxml")

public class MenuController extends Controller {

    @FXML
    private Button adm;

    @FXML
    private Button fleet;

    @FXML
    private Button logout;

    @FXML
    private Button main;

    @FXML
    private StackPane menu;

    @FXML
    private Button ordemservico;

   @Autowired
   private CarroController CarroController;

    @FXML
    private void openCarroScreen(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("carro.fxml"));
        AnchorPane carroPane = loader.load();

        // Configurar qualquer coisa no controlador da tela Carro
        CarroController carroController = loader.getController();
        

        
        menu.getChildren().clear();
        menu.getChildren().add(carroPane);
    } catch (Exception e) {
        // Tratar possíveis erros ao carregar a tela Carro
        e.printStackTrace();
    }
    }
}


