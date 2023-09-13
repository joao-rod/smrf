package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Cnh;
import br.edu.ifnmg.smrf.entidades.Condutor;
import br.edu.ifnmg.smrf.entidades.Endereco;
import br.edu.ifnmg.smrf.entidades.Pessoa;
import br.edu.ifnmg.smrf.entidades.TipoPessoa;
import br.edu.ifnmg.smrf.servicos.CnhRepositorio;
import br.edu.ifnmg.smrf.servicos.CondutorRepositorio;
import br.edu.ifnmg.smrf.servicos.EnderecoRepositorio;
import br.edu.ifnmg.smrf.servicos.PessoaRepositorio;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("novoUsr.fxml")
public class NovoUsuarioController extends Controller {
    @Autowired
    PessoaRepositorio pessoaRepositorio;

    @Autowired
    EnderecoRepositorio enderecoRepositorio;

    @Autowired
    CnhRepositorio cnhRepositorio;

    @Autowired
    CondutorRepositorio condutorRepositorio;

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

    @FXML
    private Label labelCnhCategoria;

    @FXML
    private Label labelCnhEmissao;

    @FXML
    private Label labelCnhValidade;

    @FXML
    private TextField inpCnhCategoria;

    @FXML
    private DatePicker inpCnhEmissao;

    @FXML
    private DatePicker inpCnhValidade;

    public void initialize() {
        contextoSpring = AplicacaoSpring.getContextoSpring();

        inpCargo.setItems(FXCollections.observableArrayList(TipoPessoa.values()));

        inpCargo.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue == TipoPessoa.Motorista) {
                        labelCnhCategoria.setVisible(true);
                        labelCnhEmissao.setVisible(true);
                        labelCnhValidade.setVisible(true);
                        inpCnhCategoria.setVisible(true);
                        inpCnhEmissao.setVisible(true);
                        inpCnhValidade.setVisible(true);
                    } else {
                        labelCnhCategoria.setVisible(false);
                        labelCnhEmissao.setVisible(false);
                        labelCnhValidade.setVisible(false);
                        inpCnhCategoria.setVisible(false);
                        inpCnhEmissao.setVisible(false);
                        inpCnhValidade.setVisible(false);
                    }
                });
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

            if (inpCnhCategoria.getText() != null && !inpCnhCategoria.getText().isEmpty()) {
                Cnh cnh = new Cnh();
                cnh.setCategoria(inpCnhCategoria.getText());
                cnh.setDataEmissao(inpCnhEmissao.getValue());
                cnh.setDataValidade(inpCnhValidade.getValue());

                Condutor condutor = new Condutor();
                try {
                    usuario = pessoaRepositorio.abrirPorCpf(usuario.getCpf());
                    condutor.setCondutor(usuario);
                    condutorRepositorio.Salvar(condutor);
                } catch (Exception e) {
                    usuario.setEndereco(null);
                    e.getStackTrace();
                }

                try {
                    condutor = condutorRepositorio.abrirPorUsuario(condutor.getCondutor());
                    cnh.setCondutor(condutor);
                    cnhRepositorio.Salvar(cnh);
                } catch (Exception e) {
                    cnh.setCondutor(null);
                    System.out.println("CNH =================== \n\n" + e.getMessage());
                }

                try {
                    cnh = cnhRepositorio.abrirPorCondutor(cnh.getCondutor());
                    condutor.setCnh(cnh);
                    condutorRepositorio.Salvar(condutor);
                } catch (Exception e) {
                    condutor.setCnh(null);
                    System.out.println("Condutor =================== \n\n" + e.getMessage());
                }
            }

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

            trocarTela(novoUsr, UsuarioController.class, "gerenciaUsr.fxml");
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, "Erro ao tentar salvar os dados", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
