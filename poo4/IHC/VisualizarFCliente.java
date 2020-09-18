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
import poo4.ClassesFilhas.FCliente;

public class VisualizarFCliente extends Application {

	private String agencia;
	private Stage stage;
	private Pane pane;
	private TextField txtNumconta;
	private TextField txtNome;
	private TextField txtCpf;
	private TextField txtEmail;
	private TextField txtTelefone;
	private TextField txtNumcorrente;
	private TextField txtNumpoupanca;
	private TextField txtCSaldo;
	private TextField txtPSaldo;
	private Button btnVoltar;
	private FCliente fc;
	private CCorrente cc;
	private CPoupanca cp;
	private Label lblPConta;
	private Label lblCConta;

	public VisualizarFCliente(String agencia, FCliente fc, CCorrente cc, CPoupanca cp) {
		this.agencia = agencia;
		this.fc = fc;
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
		txtNumconta.setText(String.valueOf(fc.getNumConta()));
		txtNumconta.setDisable(true);
		
		txtNome = new TextField();
		txtNome.setPromptText("Nome Cliente");
		txtNome.setText(String.valueOf(fc.getNome()));
		txtNome.setDisable(true);

		txtCpf = new TextField();
		txtCpf.setPromptText("Cpf Cliente");
		txtCpf.setText(String.valueOf(fc.getCPF()));
		txtCpf.setDisable(true);
		
		txtEmail = new TextField();
		txtEmail.setPromptText("Email Cliente");
		txtEmail.setText(String.valueOf(fc.getEmail()));
		txtEmail.setDisable(true);
		
		txtTelefone = new TextField();
		txtTelefone.setPromptText("Telefone Cliente");
		txtTelefone.setText(String.valueOf(fc.getTelefonepessoal()));
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
		pane.getChildren().addAll(txtNumconta, txtNome, txtCpf, txtEmail, txtTelefone, txtNumcorrente, txtCSaldo, txtNumpoupanca, txtPSaldo, btnVoltar);

	}

	private void configLayout() {
		pane.setPrefSize(320, 485);
		
		txtNumconta.setLayoutX(10);
		txtNumconta.setLayoutY(10);
		txtNumconta.setPrefHeight(30);
		txtNumconta.setPrefWidth(pane.getPrefWidth() - 20);

		txtNome.setLayoutX(10);
		txtNome.setLayoutY(50);
		txtNome.setPrefHeight(30);
		txtNome.setPrefWidth(pane.getPrefWidth() - 20);

		txtCpf.setLayoutX(10);
		txtCpf.setLayoutY(90);
		txtCpf.setPrefHeight(30);
		txtCpf.setPrefWidth(pane.getPrefWidth() - 20);

		txtEmail.setLayoutX(10);
		txtEmail.setLayoutY(130);
		txtEmail.setPrefHeight(30);
		txtEmail.setPrefWidth(pane.getPrefWidth() - 20);

		txtTelefone.setLayoutX(10);
		txtTelefone.setLayoutY(170);
		txtTelefone.setPrefHeight(30);
		txtTelefone.setPrefWidth(pane.getPrefWidth() - 20);
		
		lblCConta.setLayoutX(10);
		lblCConta.setLayoutY(210);
		
		txtNumcorrente.setLayoutX(10);
		txtNumcorrente.setLayoutY(250);
		txtNumcorrente.setPrefHeight(30);
		txtNumcorrente.setPrefWidth(pane.getPrefWidth() - 20);
		
		txtCSaldo.setLayoutX(10);
		txtCSaldo.setLayoutY(290);
		txtCSaldo.setPrefHeight(30);
		txtCSaldo.setPrefWidth(pane.getPrefWidth() - 20);
		
		lblPConta.setLayoutX(10);
		lblPConta.setLayoutY(330);
		
		txtNumpoupanca.setLayoutX(10);
		txtNumpoupanca.setLayoutY(370);
		txtNumpoupanca.setPrefHeight(30);
		txtNumpoupanca.setPrefWidth(pane.getPrefWidth() - 20);
		
		txtPSaldo.setLayoutX(10);
		txtPSaldo.setLayoutY(410);
		txtPSaldo.setPrefHeight(30);
		txtPSaldo.setPrefWidth(pane.getPrefWidth() - 20);

		btnVoltar.setLayoutX(10);
		btnVoltar.setLayoutY(450);
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
					Alertas.erro("Nao foi possivel iniciar o menu dos clientes!");
				}
			}
		};
	}
}
