package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.servicos.AutenticacaoServico;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("login.fxml")
public class LoginController extends Controller {

    @Autowired
    private AutenticacaoServico autenticacao;

    @FXML
    private TextField inpLoginEmail;

    @FXML
    private PasswordField inpLoginSenha;

    @FXML
    private Button loginBtn;

    @FXML
    private StackPane login;

    @FXML
    public void autenticar(Event e) {
        String username = inpLoginEmail.getText();
        String senha = inpLoginSenha.getText();

        if (autenticacao.autenticar(username, senha)) {
            carregarScene(login, MenuController.class);
        } else {
            Alert alert = new Alert(
                    AlertType.WARNING,
                    "Não foi possível acessar o sistema. Verifique se os dados informados estão corretos.",
                    ButtonType.OK);

            alert.showAndWait();

        }
    }
}