package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.stereotype.Service;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("homepage.fxml")
public class HomepageController extends Controller {

    @FXML
    private StackPane homepage;

    public void initialize() {
        contextoSpring = AplicacaoSpring.getContextoSpring();
    }

    public HomepageController() {
        
    }

}
