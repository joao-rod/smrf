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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("login.fxml")
public class LoginController extends Controller {

    @Autowired
    private AutenticacaoServico autenticacao;

    // @Autowired
    // private LogServico logs;

    @FXML
    private Button close;

    @FXML
    private TextField inpLoginEmail;

    @FXML
    private PasswordField inpLoginSenha;

    @FXML
    private Button loginBtn;

    @FXML
    private StackPane menu;

    public LoginController() {

    }

    @FXML
    public void autenticar(Event e) {
        String login = inpLoginEmail.getText();
        String senha = inpLoginSenha.getText();

        if (autenticacao.autenticar(login, senha)) {
           // carregarScene(menu, MenuController.class);

            Alert alert = new Alert(AlertType.INFORMATION, "deu certo", ButtonType.OK);
             alert.showAndWait();

            //logs.registrar(LogNivel.Informacao, "Login", txtLogin.getText());

             //carregarScene(menu, MenuController.class);

             alert.showAndWait();
        } else {
            // logs.registrar(LogNivel.Erro, "Login", txtLogin.getText());
            // Alert alert = new Alert(AlertType.CONFIRMATION, "Erro ao acessar o sistema.
            // Deseja sair?", ButtonType.NO, ButtonType.NO);
            // alert.showAndWait();

            Alert alert = new Alert(
                AlertType.WARNING,
                "Não foi possível acessar o sistema. Verifique se os dados informados estão corretos.",
                ButtonType.OK)
            ;
            alert.showAndWait();

        }
    }

    //@FXML
   // public void irParaMenu(Event e) {
    //    //carregarScene(painelNovoUsuario, NovoUsuarioController.class);
   // }
}