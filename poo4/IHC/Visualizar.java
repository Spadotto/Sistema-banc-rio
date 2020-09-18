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
import poo4.ClassesFilhas.Agencia;

public class Visualizar extends Application {

	private Agencia ag;
	private Stage stage;
	private Pane pane;
	private TextField txtNumconta;
	private TextField txtCidade;
	private TextField txtApp;
	private TextField txtTelefone;
	private Button btnVoltar;
	private String agencia;

	public Visualizar(Agencia ag) {
		this.ag = ag;
		agencia = ag.getNumAgencia();
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		this.stage = stage;
		initComponentes();
		configLayout();

		Scene scene = new Scene(pane);
		btnVoltar.requestFocus();

		stage.setScene(scene);
		stage.setTitle("Visualizacao de uma agencia");
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() {
		txtNumconta = new TextField();
		txtNumconta.setPromptText("Numero da agencia");
		txtNumconta.setText(String.valueOf(ag.getNumAgencia()));
		txtNumconta.setDisable(true);
		
		txtCidade = new TextField();
		txtCidade.setPromptText("Nome Cliente");
		txtCidade.setText(String.valueOf(ag.getCidade()));
		txtCidade.setDisable(true);

		txtTelefone = new TextField();
		txtTelefone.setPromptText("Telefone Cliente");
		txtTelefone.setText(String.valueOf(ag.getTelefone()));
		txtTelefone.setDisable(true);
		
		txtApp = new TextField();
		txtApp.setPromptText("Cpf Cliente");
		txtApp.setText(String.valueOf(ag.getApp()));
		txtApp.setDisable(true);

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(txtNumconta, txtCidade, txtTelefone, txtApp, btnVoltar);

	}

	private void configLayout() {
		pane.setPrefSize(320, 205);
		
		txtNumconta.setLayoutX(10);
		txtNumconta.setLayoutY(10);
		txtNumconta.setPrefHeight(30);
		txtNumconta.setPrefWidth(pane.getPrefWidth() - 20);

		txtCidade.setLayoutX(10);
		txtCidade.setLayoutY(50);
		txtCidade.setPrefHeight(30);
		txtCidade.setPrefWidth(pane.getPrefWidth() - 20);

		txtTelefone.setLayoutX(10);
		txtTelefone.setLayoutY(90);
		txtTelefone.setPrefHeight(30);
		txtTelefone.setPrefWidth(pane.getPrefWidth() - 20);
		
		txtApp.setLayoutX(10);
		txtApp.setLayoutY(130);
		txtApp.setPrefHeight(30);
		txtApp.setPrefWidth(pane.getPrefWidth() - 20);

		btnVoltar.setLayoutX(10);
		btnVoltar.setLayoutY(170);
		btnVoltar.setPrefHeight(20);
		btnVoltar.setPrefWidth((pane.getPrefWidth() - 30) / 2);
	}

	private EventHandler<ActionEvent> voltar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new Agenciamenu(agencia).start(stage);
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel iniciar o menu dos clientes!");
				}
			}
		};
	}
}
