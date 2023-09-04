package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.stereotype.Service;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import lombok.NoArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("template.fxml")
@NoArgsConstructor
public class TemplateController extends Controller {

    @FXML
    private VBox menu;

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
