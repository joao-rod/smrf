package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("login.fxml")
public class LoginController extends Controller {

    // @Autowired
    // private AutenticacaoServico autenticacao;

    // @Autowired
    // private LogServico logs;

    @FXML
    private TextField inpLoginEmail;

    @FXML
    private PasswordField inpLoginSenha;

    @FXML
    TitledPane viewLogin;

    public LoginController() {

    }


    @FXML
    public void autenticar(Event e){
        String login = inpLoginEmail.getText();
        String senha = inpLoginSenha.getText();

        // if(autenticacao.autenticar(login, senha)){

        //     logs.registrar(LogNivel.Informacao, "Login", txtLogin.getText());
            
         //     carregarScene(viewLogin, TelaPrincipalController.class);
            
         //     //Alert alert = new Alert(AlertType.INFORMATION, "Bem vindo ao sistema! ", ButtonType.OK);
        //     //alert.showAndWait();
        // } else {
        //     logs.registrar(LogNivel.Erro, "Login", txtLogin.getText());
         //     Alert alert = new Alert(AlertType.CONFIRMATION, "Erro ao acessar o sistema. Deseja sair?", ButtonType.NO, ButtonType.NO);
         //     alert.showAndWait();

         //     if (alert.getResult() == ButtonType.YES) {
        //         Platform.exit();
         //     }
            
         // }
     }
}