package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.stereotype.Service;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("template.fxml")

public class TemplateController extends Controller {

    @FXML
    private Button adm;

    @FXML
    private Button fleet;

    @FXML
    private Button logout;

    @FXML
    private Button main;

    @FXML
    private VBox menu;

    public TemplateController(){
        
    }

    @FXML
    public void openMainScreen(ActionEvent event) {
        try {
            trocarTela(menu, HomepageController.class, "homepage.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openCarroScreen(ActionEvent event) {
        try {
            trocarTela(menu, CarroController.class, "carro.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openRetornoScreen(ActionEvent event) {
        try {
            trocarTela(menu, CarroController.class, "registraRetorno.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openNovaReservaScreen(ActionEvent event) {
        try {
            trocarTela(menu, CarroController.class, "reservaCarro.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openAdmScreen(ActionEvent event) {
        try {
            trocarTela(menu, UsuarioController.class, "gerenciaUsr.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void logout(ActionEvent event) {
        try {
            trocarTela(menu, LoginController.class, "login.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
