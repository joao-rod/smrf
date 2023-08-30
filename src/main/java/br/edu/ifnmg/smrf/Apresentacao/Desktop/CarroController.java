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
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("NovoCarro.fxml")
public class CarroController extends Controller {

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

    public CarroController(){


    }

}
