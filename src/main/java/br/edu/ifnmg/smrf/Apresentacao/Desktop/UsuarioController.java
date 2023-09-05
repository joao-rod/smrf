package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Pessoa;
import br.edu.ifnmg.smrf.entidades.TipoPessoa;
import br.edu.ifnmg.smrf.servicos.PessoaRepositorio;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    // campos usr
    @FXML
    private TextField inpNome;

    @FXML
    private TextField inpSobrenome;

    @FXML
    private TextField inpCpf;

    @FXML
    private TextField inpRG;

    @FXML
    private ChoiceBox<TipoPessoa> inpCargo;

    @FXML
    private TextField inpEmail;

    @FXML
    private PasswordField inpSenha;

    @FXML
    private TextField inpTelefone;

    // campos endereço
    @FXML
    private TextField inpLogradouro;

    @FXML
    private TextField inpNumero;

    @FXML
    private TextField inpBairro;

    @FXML
    private TextField inpComplemento;

    // gerencia usr
    @FXML
    private Button deleteUsr;

    @FXML
    private Button procuraUsr;

    @FXML
    private Button criaUsr;

    // FIX: Corrigir função
    @FXML
    private void configInpCargo() {
        inpCargo.setItems(FXCollections.observableArrayList(TipoPessoa.values()));
        inpCargo.setValue(TipoPessoa.Funcionario);
    }

    @FXML
    private void openNovoUserScreen(ActionEvent event) {
        try {
            trocarTela(gerenciaUsr, UsuarioController.class, "novoUsr.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancelaCadastro(ActionEvent event) {
        try {
            trocarTela(novoUsr, UsuarioController.class, "gerenciaUsr.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void novoUsuario(ActionEvent event) {
        Pessoa usuario = new Pessoa();
        // configInpCargo();

        usuario.setNome(inpNome.getText());
        // usuario.setSobrenome(inpSobrenome.getText()); // FIX: adicionar no banco
        usuario.setCpf(inpCpf.getText());
        usuario.setRg(inpRG.getText());
        usuario.setTipoPessoa(inpCargo.getValue()); // WARNING: correção de funcionalidade

        // usuario.setSenha(inpSenha.getText());

        try {
            pessoaRepositorio.Salvar(usuario);

            Alert alert = new Alert(AlertType.INFORMATION, "Salvo com sucesso!", ButtonType.OK);
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, "Erro ao tentar salvar os dados", ButtonType.OK);
            alert.showAndWait();
        }

        trocarTela(novoUsr, UsuarioController.class, "gerenciaUsr.fxml");
    }
}
