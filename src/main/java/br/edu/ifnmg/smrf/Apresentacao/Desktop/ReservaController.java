package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.servicos.CondutorRepositorio;
import br.edu.ifnmg.smrf.servicos.VeiculoRepositorio;
import br.edu.ifnmg.smrf.servicos.ViagemRepositorio;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("reservaCarro.fxml")
public class ReservaController extends Controller {
    @Autowired
    ViagemRepositorio viagemRepositorio;

    @Autowired
    VeiculoRepositorio veiculoRepositorio;

    @Autowired
    CondutorRepositorio condutorRepositorio;

    @FXML
    private TextField inpBairro;

    @FXML
    private TextField inpComplemento;

    @FXML
    private ChoiceBox<String> inpCondutor;

    @FXML
    private DatePicker inpData;

    @FXML
    private TextField inpHora;

    @FXML
    private TextArea inpJustificativa;

    @FXML
    private TextField inpLogradouro;

    @FXML
    private TextField inpNumero;

    @FXML
    private ChoiceBox<String> inpVeiculo;

    @FXML
    private AnchorPane reserva;

    @FXML
    private Button cancelaViagem;

    public void initialize() {
        contextoSpring = AplicacaoSpring.getContextoSpring();

        inpVeiculo.setItems(FXCollections.observableArrayList(veiculoRepositorio.buscarPlacas()));
        inpCondutor.setItems(FXCollections.observableArrayList(condutorRepositorio.buscarNome()));
    }

    @FXML
    private void cancelarReserva(ActionEvent event) {
        try {
            trocarTela(reserva, ViagemController.class, "viagens.fxml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
