package poo4.IHC;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import poo4.ClassesFilhas.CCorrente;
import poo4.ClassesFilhas.CPoupanca;
import poo4.ClassesFilhas.JCliente;

public class VisualizarJCliente extends Application {

	private String agencia;
	private Stage stage;
	private Pane pane;
	private TextField txtNumconta;
	private TextField txtNome;
	private TextField txtNomefantasia;
	private TextField txtCnpj;
	private TextField txtEmail;
	private TextField txtTelefone;
	private TextField txtNumcorrente;
	private TextField txtNumpoupanca;
	private TextField txtCSaldo;
	private TextField txtPSaldo;
	private Button btnVoltar;
	private JCliente jc;
	private CCorrente cc;
	private CPoupanca cp;
	private Label lblPConta;
	private Label lblCConta;

	public VisualizarJCliente(String agencia, JCliente jc, CCorrente cc, CPoupanca cp) {
		this.agencia = agencia;
		this.jc = jc;
		this.cc = cc;
		this.cp = cp;
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		this.stage = stage;
		initComponentes();
		configLayout();

		Scene scene = new Scene(pane);
		btnVoltar.requestFocus();

		stage.setScene(scene);
		stage.setTitle("Visualizacao de um cliente");
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() {
		txtNumconta = new TextField();
		txtNumconta.setPromptText("Numero da conta");
		txtNumconta.setText(String.valueOf(jc.getNumConta()));
		txtNumconta.setDisable(true);
		
		txtNome = new TextField();
		txtNome.setPromptText("Gerente");
		txtNome.setText(String.valueOf(jc.getNome()));
		txtNome.setDisable(true);

		txtCnpj = new TextField();
		txtCnpj.setPromptText("CNPJ Cliente");
		txtCnpj.setText(String.valueOf(jc.getCnpj()));
		txtCnpj.setDisable(true);
		
		txtEmail = new TextField();
		txtEmail.setPromptText("Email Cliente");
		txtEmail.setText(String.valueOf(jc.getEmail()));
		txtEmail.setDisable(true);
		
		txtNomefantasia = new TextField();
		txtNomefantasia.setPromptText("Nome fantasia");
		txtNomefantasia.setText(String.valueOf(jc.getNomefantasia()));
		txtNomefantasia.setDisable(true);
		
		txtTelefone = new TextField();
		txtTelefone.setPromptText("Telefone Cliente");
		txtTelefone.setText(String.valueOf(jc.getTelefoneempresa()));
		txtTelefone.setDisable(true);
		
		lblCConta = new Label("Conta Corrente");
		
		txtNumcorrente = new TextField();
		txtNumcorrente.setPromptText("Conta Corrente");
		txtNumcorrente.setText(String.valueOf(cc.getNumCorrente()));
		txtNumcorrente.setDisable(true);
		
		txtCSaldo = new TextField();
		txtCSaldo.setPromptText("Saldo Conta Corrente");
		txtCSaldo.setText(String.valueOf(cc.getSaldo()));
		txtCSaldo.setDisable(true);
		
		lblPConta = new Label("Conta Poupanca");
								
		txtNumpoupanca = new TextField();
		txtNumpoupanca.setPromptText("Conta Poupanca");
		txtNumpoupanca.setText(String.valueOf(cp.getNumPoupanca()));
		txtNumpoupanca.setDisable(true);
		
		txtPSaldo = new TextField();
		txtPSaldo.setPromptText("Saldo Conta Poupanca");
		txtPSaldo.setText(String.valueOf(cp.getSaldo()));
		txtPSaldo.setDisable(true);

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(lblCConta, lblPConta);
		pane.getChildren().addAll(txtNumconta, txtNome, txtCnpj, txtEmail, txtNomefantasia, txtTelefone, txtNumcorrente, txtCSaldo, txtNumpoupanca, txtPSaldo, btnVoltar);

	}

	private void configLayout() {
		pane.setPrefSize(320, 525);
		
		txtNumconta.setLayoutX(10);
		txtNumconta.setLayoutY(10);
		txtNumconta.setPrefHeight(30);
		txtNumconta.setPrefWidth(pane.getPrefWidth() - 20);

		txtNome.setLayoutX(10);
		txtNome.setLayoutY(50);
		txtNome.setPrefHeight(30);
		txtNome.setPrefWidth(pane.getPrefWidth() - 20);

		txtCnpj.setLayoutX(10);
		txtCnpj.setLayoutY(90);
		txtCnpj.setPrefHeight(30);
		txtCnpj.setPrefWidth(pane.getPrefWidth() - 20);

		txtEmail.setLayoutX(10);
		txtEmail.setLayoutY(130);
		txtEmail.setPrefHeight(30);
		txtEmail.setPrefWidth(pane.getPrefWidth() - 20);
		
		txtNomefantasia.setLayoutX(10);
		txtNomefantasia.setLayoutY(170);
		txtNomefantasia.setPrefHeight(30);
		txtNomefantasia.setPrefWidth(pane.getPrefWidth() - 20);

		txtTelefone.setLayoutX(10);
		txtTelefone.setLayoutY(210);
		txtTelefone.setPrefHeight(30);
		txtTelefone.setPrefWidth(pane.getPrefWidth() - 20);
		
		lblCConta.setLayoutX(10);
		lblCConta.setLayoutY(250);
		
		txtNumcorrente.setLayoutX(10);
		txtNumcorrente.setLayoutY(290);
		txtNumcorrente.setPrefHeight(30);
		txtNumcorrente.setPrefWidth(pane.getPrefWidth() - 20);
		
		txtCSaldo.setLayoutX(10);
		txtCSaldo.setLayoutY(330);
		txtCSaldo.setPrefHeight(30);
		txtCSaldo.setPrefWidth(pane.getPrefWidth() - 20);
		
		lblPConta.setLayoutX(10);
		lblPConta.setLayoutY(370);
		
		txtNumpoupanca.setLayoutX(10);
		txtNumpoupanca.setLayoutY(410);
		txtNumpoupanca.setPrefHeight(30);
		txtNumpoupanca.setPrefWidth(pane.getPrefWidth() - 20);
		
		txtPSaldo.setLayoutX(10);
		txtPSaldo.setLayoutY(450);
		txtPSaldo.setPrefHeight(30);
		txtPSaldo.setPrefWidth(pane.getPrefWidth() - 20);

		btnVoltar.setLayoutX(10);
		btnVoltar.setLayoutY(490);
		btnVoltar.setPrefHeight(20);
		btnVoltar.setPrefWidth((pane.getPrefWidth() - 30) / 2);
		
	}

	private EventHandler<ActionEvent> voltar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new Clientes(agencia).start(stage);
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel iniciar o menu de clientes!");
				}
			}
		};
	}
}
