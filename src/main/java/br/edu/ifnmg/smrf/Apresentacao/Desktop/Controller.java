package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.context.ConfigurableApplicationContext;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;

public class Controller {
    protected ConfigurableApplicationContext contextoSpring;

    public void initialize() {
        contextoSpring = AplicacaoSpring.getContextoSpring();
    }

    public void trocarTela(Node parent, Class<?> controller, String fxmlPath) {

        Stage stage = (Stage) parent.getScene().getWindow();
        FxWeaver fxWeaver = contextoSpring.getBean(FxWeaver.class);
        Parent root = (Parent) fxWeaver.loadView(controller, fxmlPath);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void trocarScene(Node parentName, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent parent = loader.load();

            parentName.getScene().setRoot(parent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
