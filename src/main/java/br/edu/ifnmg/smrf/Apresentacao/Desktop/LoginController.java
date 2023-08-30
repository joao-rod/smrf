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

<<<<<<< HEAD
        if (autenticacao.autenticar(login, senha)) {
           // carregarScene(menu, MenuController.class);

            Alert alert = new Alert(AlertType.INFORMATION, "deu certo", ButtonType.OK);
             alert.showAndWait();

            //logs.registrar(LogNivel.Informacao, "Login", txtLogin.getText());

             //carregarScene(menu, MenuController.class);

             alert.showAndWait();
=======
        if (autenticacao.autenticar(username, senha)) {
            carregarScene(login, MenuController.class);
>>>>>>> 25aa6a6078dab2ef26135a47fae2064aa5ccf5a0
        } else {
            Alert alert = new Alert(
                    AlertType.WARNING,
                    "Não foi possível acessar o sistema. Verifique se os dados informados estão corretos.",
                    ButtonType.OK);

            alert.showAndWait();

        }
    }
}