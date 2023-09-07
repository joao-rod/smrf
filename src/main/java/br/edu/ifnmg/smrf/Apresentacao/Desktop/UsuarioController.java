package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.servicos.PessoaRepositorio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("gerenciaUsr.fxml")
public class UsuarioController extends Controller {
    @Autowired
    PessoaRepositorio pessoaRepositorio;

    // parents usr
    @FXML
    private StackPane gerenciaUsr;

    @FXML
    private StackPane novoUsr;

    // gerencia usr
    @FXML
    private Button deleteUsr;

    @FXML
    private Button procuraUsr;

    @FXML
    private Button criaUsr;

    @FXML
    private void openNovoUserScreen(ActionEvent event) {
        try {
            trocarTela(gerenciaUsr, NovoUsuarioController.class, "novoUsr.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
