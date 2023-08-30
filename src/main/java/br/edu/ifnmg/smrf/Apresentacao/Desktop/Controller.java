package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;

public class Controller {
    private ConfigurableApplicationContext contextoSpring;

    private Node ancora;

    @FXML
    public void initialize() {
        String[] args = new String[0];

        this.contextoSpring = new SpringApplicationBuilder()
                .sources(AplicacaoSpring.class)
                .run(args);
    }

    public void carregarScene(Node parent, Class controller) {

        Stage stage = (Stage) parent.getScene().getWindow();
        FxWeaver fxWeaver = contextoSpring.getBean(FxWeaver.class);
        Parent root = (Parent) fxWeaver.loadView(controller);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    // public void trocarTela(Node parent, Class controller, String fxmlPath) {
        
    //     Stage stage = (Stage) parent.getScene().getWindow();
    //     FxWeaver fxWeaver = contextoSpring.getBean(FxWeaver.class);
    //     Parent root = (Parent) fxWeaver.loadView(controller, fxmlPath);
    //     Scene scene = new Scene(root);
        
    //     stage.setScene(scene);
    //     stage.show();
    // }

    public ConfigurableApplicationContext getContextoSpring() {
        return contextoSpring;
    }

    public Node getAncora() {
        return ancora;
    }

    public void setAncora(Node ancora) {
        this.ancora = ancora;
    }
}
