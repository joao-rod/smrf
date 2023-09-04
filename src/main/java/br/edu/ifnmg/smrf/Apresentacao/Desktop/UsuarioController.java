package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.stereotype.Service;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("gerenciaUsr.fxml")
public class UsuarioController extends Controller {

    // parents usr
    @FXML
    private StackPane gerenciaUsr;

    @FXML
    private StackPane novoUsr;

    // GERENCIA USR
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

    @FXML
    private void openNovoUserScreen(ActionEvent event) {
        try {
            trocarTela(gerenciaUsr, UsuarioController.class, "novoUsr.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
