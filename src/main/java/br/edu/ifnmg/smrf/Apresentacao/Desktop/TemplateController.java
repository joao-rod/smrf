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
}
