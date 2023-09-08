package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Pessoa;
import br.edu.ifnmg.smrf.servicos.PessoaRepositorio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    // campos tabela
    @FXML
    private TableColumn<Pessoa, String> colActions;

    @FXML
    private TableColumn<Pessoa, LocalDateTime> colData;

    @FXML
    private TableColumn<Pessoa, String> colEmail;

    @FXML
    private TableColumn<Pessoa, String> colNome;

    @FXML
    private TableColumn<Pessoa, String> colTipo;

    @FXML
    private TableView<Pessoa> tableGerenciaUsr;

    // gerencia usr
    @FXML
    private Button deleteUsr;

    @FXML
    private Button procuraUsr;

    @FXML
    private Button criaUsr;

    public void initialize() {
        contextoSpring = AplicacaoSpring.getContextoSpring();
        
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colData.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoPessoa"));

        List<Pessoa> usuarios = pessoaRepositorio.Buscar();
        ObservableList<Pessoa> lista = FXCollections.observableArrayList(usuarios);
        tableGerenciaUsr.setItems(lista);
    }

    @FXML
    private void openNovoUserScreen(ActionEvent event) {
        try {
            trocarTela(gerenciaUsr, NovoUsuarioController.class, "novoUsr.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
