package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.servicos.AutenticacaoServico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lombok.NoArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("template.fxml")
@NoArgsConstructor
public class TemplateController extends Controller {
    @Autowired
    AutenticacaoServico atutenticar;
    
    @FXML
    private VBox menu;

    // public void initialize() {
    //     username.setText(atutenticar.getUsuario().getNome());
    // }

    @FXML
    private Label username;

    public void initialize() {
        contextoSpring = AplicacaoSpring.getContextoSpring();
    }

    @FXML
    public void openMainScreen(ActionEvent event) { // Tela principal
        try {
            trocarTela(menu, HomepageController.class, "homepage.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openCarroScreen(ActionEvent event) { // Frota
        try {
            trocarTela(menu, CarroController.class, "carro.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openViagemScreen(ActionEvent event) { // Viagem
        try {
            trocarTela(menu, CarroController.class, "carro.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openAdmScreen(ActionEvent event) { // RH
        try {
            trocarTela(menu, UsuarioController.class, "gerenciaUsr.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void logout(ActionEvent event) { // Logout
        try {
            trocarTela(menu, LoginController.class, "login.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
