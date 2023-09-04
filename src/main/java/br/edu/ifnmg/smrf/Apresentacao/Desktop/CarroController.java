package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Veiculo;
import br.edu.ifnmg.smrf.servicos.VeiculoRepositorio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("carro.fxml")
public class CarroController extends Controller {
    @Autowired
    VeiculoRepositorio veiculoRepositorio;

    // parents cars
    @FXML
    private AnchorPane veiculos;

    @FXML
    private AnchorPane novoCarro;

    @FXML
    private Button cadastraCarro;

    @FXML
    private Button cancelaCarro;

    @FXML
    private Button retorno;

    @FXML
    private Button ordemservico;

    @FXML
    private TextField anodefabricacao;

    @FXML
    private DatePicker datadeaquisicao;

    @FXML
    private TextArea descricao;

    @FXML
    private TextField fabricante;

    @FXML
    private TextField modelo;

    @FXML
    private TextField placa;

    @FXML
    private TextField renavan;

    @FXML
    private TextField versao;

    // reserva de carro
    @FXML
    private Button escolhecondutor;

    @FXML
    private Button escolhemodelo;

    @FXML
    private Button novaViagem;

    @FXML
    private void openRetornoScreen(ActionEvent event) {
        try {
            trocarTela(veiculos, CarroController.class, "registraRetorno.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openAddCarroScreen(ActionEvent event) {
        try {
            trocarTela(veiculos, CarroController.class, "novoCarro.fxml");
           } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openNovaReservaScreen(ActionEvent event) {
        try {
            trocarTela(veiculos, CarroController.class, "reservaCarro.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void novoVeiculo(ActionEvent event) {
        Veiculo veiculo = new Veiculo();

        veiculo.setModelo(modelo.getText());
        veiculo.setFabricante(fabricante.getText());
        veiculo.setRenavan(renavan.getText());
        veiculo.setDescricao(descricao.getText());
        veiculo.setDataDeAquisicao(datadeaquisicao.getValue());
        veiculo.setPlaca(placa.getText());
        veiculo.setVersao(versao.getText());

        try {
            veiculo.setAno(Integer.valueOf(anodefabricacao.getText()));
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.WARNING, "Ano de fabricação deve ser um numero", ButtonType.OK);
            alert.showAndWait();

            return;
        }

        Field[] atributos = veiculo.getClass().getDeclaredFields();
        for (Field atributo : atributos) {
            atributo.setAccessible(true);
            try {
                if (atributo.get(veiculo) == null) {
                    Alert alert = new Alert(AlertType.ERROR, "Há campos sem preencher", ButtonType.OK);
                    alert.showAndWait();

                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            veiculoRepositorio.Salvar(veiculo);

            Alert alert = new Alert(AlertType.INFORMATION, "Salvo com sucesso!", ButtonType.OK);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                trocarTela(novoCarro, CarroController.class, "carro.fxml");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}