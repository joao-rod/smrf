package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.stereotype.Service;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
    private VBox menu;

    @FXML
    private Button ordemservico;

    @FXML
    private void openCarroScreen(ActionEvent event) {
        try {
            trocarTela(menu, CarroController.class, "carro.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@FXML
    //public void openMainScreen(ActionEvent event) {
      //  try {
            // FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
    //         Parent menuPane = loader.load();

    //         MenuController menuController = loader.getController();

    //         main.getScene().setRoot(menuPane);
    //     } catch (Exception e) {

    //         e.printStackTrace();
    //     }
    // }

    @FXML
    public void openAdmScreen(ActionEvent event) {
        try {
            trocarTela(menu, UsuarioController.class, "gerenciaUsr.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
