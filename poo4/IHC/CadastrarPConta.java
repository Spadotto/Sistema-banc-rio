package poo4.IHC;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import poo4.ClassesFilhas.CPoupanca;
import poo4.Database.CPoupancaDAO;

public class CadastrarPConta extends Application {
	
	private String numConta;
	private String agencia;
	private Stage stage;
	private Pane pane;
	private TextField numPoupanca;
	private TextField saldo;
	private Button btnVoltar;
	private Button btnCadastrar;
	
	public CadastrarPConta(String numConta, String agencia) {
		if (numConta.isBlank())
			numConta = "Erro - Numero da conta em branco!";
		this.numConta = numConta;
		if (agencia.isBlank())
			agencia = "Erro - Numero da conta em branco!";
		this.agencia = agencia;
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		this.stage = stage;
		initComponentes();
		configLayout();

		Scene scene = new Scene(pane);
		btnVoltar.requestFocus();

		stage.setScene(scene);
		stage.setTitle("Registro da conta Poupanca");
		stage.setResizable(false);
		stage.show();
	}
	
	private void initComponentes() {
		numPoupanca = new TextField();
		numPoupanca.setPromptText("Numero da Conta");

		saldo = new TextField();
		saldo.setPromptText("Saldo");

		btnCadastrar = new Button("Cadastrar");
		btnCadastrar.setOnAction(cadastrar());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(numPoupanca, saldo, btnCadastrar, btnVoltar);

	}

	private void configLayout() {
		pane.setPrefSize(320, 125);
		
		numPoupanca.setLayoutX(10);
		numPoupanca.setLayoutY(10);
		numPoupanca.setPrefHeight(30);
		numPoupanca.setPrefWidth(pane.getPrefWidth() - 20);

		saldo.setLayoutX(10);
		saldo.setLayoutY(50);
		saldo.setPrefHeight(30);
		saldo.setPrefWidth(pane.getPrefWidth() - 20);

		btnCadastrar.setLayoutX(10);
		btnCadastrar.setLayoutY(90);
		btnCadastrar.setPrefHeight(20);
		btnCadastrar.setPrefWidth((pane.getPrefWidth() - 30) / 2);

		btnVoltar.setLayoutX(btnCadastrar.getPrefWidth() + 20);
		btnVoltar.setLayoutY(90);
		btnVoltar.setPrefHeight(20);
		btnVoltar.setPrefWidth((pane.getPrefWidth() - 30) / 2);
		
	}
	
	private EventHandler<ActionEvent> cadastrar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (numPoupanca.getText().isBlank()) {
					Alertas.alerta("NumConta em branco!");
					return;
				}
			
				if (saldo.getText().isBlank()) {
					Alertas.alerta("Saldo em branco!");
					return;
				}
				
				new CPoupancaDAO().adicionar(new CPoupanca(numPoupanca.getText(), numConta, Double.valueOf(saldo.getText())));
				Alertas.info("Conta cadastrada com sucesso :)");

				voltar();
			}
		};
	}

	private EventHandler<ActionEvent> voltar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new Contas(numConta, agencia).start(stage);
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel iniciar o menu de clientes!");
				};
			}
		};
	}

}
