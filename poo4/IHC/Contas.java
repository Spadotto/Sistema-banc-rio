package poo4.IHC;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Contas extends Application {
	
	private String numConta;
	private String agencia;
	private Stage stage;
	private Pane pane;
	private Button numCorrente;
	private Button numPoupanca;
	private Button btnVoltar;
	
	public Contas(String numConta, String agencia) {
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
		stage.setTitle("Menu Contas");
		stage.setResizable(false);
		stage.show();
	}
	
	private void initComponentes() {
		numCorrente = new Button("Conta Corrente");
		numCorrente.setOnAction(CCorrente());

		numPoupanca = new Button("Conta Poupanca");
		numPoupanca.setOnAction(CPoupanca());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(numCorrente, numPoupanca, btnVoltar);

	}

	private void configLayout() {
		pane.setPrefSize(320, 125);
		
		numCorrente.setLayoutX(10);
		numCorrente.setLayoutY(10);
		numCorrente.setPrefHeight(30);
		numCorrente.setPrefWidth(pane.getPrefWidth() - 20);

		numPoupanca.setLayoutX(10);
		numPoupanca.setLayoutY(50);
		numPoupanca.setPrefHeight(30);
		numPoupanca.setPrefWidth(pane.getPrefWidth() - 20);

		btnVoltar.setLayoutX(10);
		btnVoltar.setLayoutY(90);
		btnVoltar.setPrefHeight(30);
		btnVoltar.setPrefWidth(pane.getPrefWidth() - 20);
		
	}
	
	private EventHandler<ActionEvent> CCorrente() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new CadastrarCConta(numConta, agencia).start(stage);
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel criar uma conta corrente!");
				};
			}
		};
	}
	
	private EventHandler<ActionEvent> CPoupanca() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new CadastrarPConta(numConta, agencia).start(stage);
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel criar uma conta corrente!");
				};
			}
		};
	}

	private EventHandler<ActionEvent> voltar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new Clientes(agencia).start(stage);
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel iniciar o menu de clientes!");
				};
			}
		};
	}

}
