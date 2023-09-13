package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Condutor;
import br.edu.ifnmg.smrf.entidades.Veiculo;
import br.edu.ifnmg.smrf.entidades.Viagem;
import br.edu.ifnmg.smrf.entidades.ViagemStatus;
import br.edu.ifnmg.smrf.servicos.ViagemRepositorio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("viagens.fxml")
public class ViagemController extends Controller {
    @Autowired
    ViagemRepositorio viagemRepositorio;

    @FXML
    private Button btnNovaViagem;

    @FXML
    private Button btnRetorno;

    @FXML
    private AnchorPane viagem;

    @FXML
    private TableColumn<Condutor, String> colCondutor;

    @FXML
    private TableColumn<Veiculo, String> colPlaca;

    @FXML
    private TableColumn<Viagem, ViagemStatus> colStatus;

    @FXML
    private TableColumn<Viagem, LocalDateTime> colDataViagem;

    @FXML
    private TableView<?> tableViagens;

    @FXML
    private Button editaViagem;

    @FXML
    private Button procuraViagem;

    @FXML
    private Button cancelaViagem;

    @FXML
    private AnchorPane veiculos;

    public void initialize() {
        contextoSpring = AplicacaoSpring.getContextoSpring();
    }

    @FXML
    void openNovaReservaScreen(ActionEvent event) {
        trocarTela(viagem, ViagemController.class, "reservaCarro.fxml");
    }

    @FXML
    void openRetornoScreen(ActionEvent event) {
        trocarTela(viagem, ViagemController.class, "registraRetorno.fxml");
    }

}
