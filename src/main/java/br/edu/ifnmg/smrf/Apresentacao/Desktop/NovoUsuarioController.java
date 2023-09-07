package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Endereco;
import br.edu.ifnmg.smrf.entidades.Pessoa;
import br.edu.ifnmg.smrf.entidades.TipoPessoa;
import br.edu.ifnmg.smrf.servicos.EnderecoRepositorio;
import br.edu.ifnmg.smrf.servicos.PessoaRepositorio;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("gerenciaUsr.fxml")
public class NovoUsuarioController extends Controller {
    @Autowired
    PessoaRepositorio pessoaRepositorio;

    @Autowired
    EnderecoRepositorio enderecoRepositorio;

    // parents usr
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

    public void initialize() {
        inpCargo.setItems(FXCollections.observableArrayList(TipoPessoa.values()));
    }

    @FXML
    private void cancelaCadastro(ActionEvent event) {
        try {
            trocarScene(novoUsr, "gerenciaUsr.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void novoUsuario(ActionEvent event) {
        try {
            Pessoa usuario = new Pessoa();
            usuario.setNome(inpNome.getText());
            usuario.setSobrenome(inpSobrenome.getText());
            usuario.setCpf(inpCpf.getText());
            usuario.setRg(inpRG.getText());
            usuario.setTipoPessoa(inpCargo.getValue());
            usuario.setEmail(inpEmail.getText());
            usuario.setSenha(inpSenha.getText());
            usuario.setTelefone(inpTelefone.getText());
            pessoaRepositorio.Salvar(usuario);

            Endereco endereco = new Endereco();
            endereco.setLogradouro(inpLogradouro.getText());
            endereco.setNumero(inpNumero.getText());
            endereco.setBairro(inpBairro.getText());
            endereco.setComplemento(inpComplemento.getText());

            try {
                usuario = pessoaRepositorio.abrirPorCpf(usuario.getCpf());
                endereco.setPessoa(usuario);
                enderecoRepositorio.Salvar(endereco);
            } catch (Exception e) {
                usuario.setEndereco(null);
                e.getStackTrace();
            }

            try {
                endereco = enderecoRepositorio.abrirPorUsuario(endereco.getPessoa());
                usuario.setEndereco(endereco);
                pessoaRepositorio.Salvar(usuario);
            } catch (Exception e) {
                endereco.setPessoa(null);
                e.getStackTrace();
            }

            Alert alert = new Alert(AlertType.INFORMATION, "Salvo com sucesso!", ButtonType.OK);
            alert.showAndWait();

            trocarScene(novoUsr, "gerenciaUsr.fxml");
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, "Erro ao tentar salvar os dados", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
