package poo4.IHC;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import poo4.ClassesFilhas.Agencia;
import poo4.Database.AgenciaDAO;

public class CadastrarAgencia extends Application {

	private Stage stage;
	private Pane pane;
	private PasswordField txtNumAgencia;
	private TextField txtCidade;
	private TextField txttelefone;
	private TextField txtApp;
	private Button btnVoltar;
	private Button btnCadastrar;

	@Override
	public void start(Stage stage) throws Exception {
		
		this.stage = stage;
		initComponentes();
		configLayout();

		Scene scene = new Scene(pane);
		btnVoltar.requestFocus();

		stage.setScene(scene);
		stage.setTitle("Registro de uma nova agencia");
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() {
		txtNumAgencia = new PasswordField();
		txtNumAgencia.setPromptText("Numero da Agencia");

		txtCidade = new TextField();
		txtCidade.setPromptText("Cidade");

		txttelefone = new TextField();
		txttelefone.setPromptText("Telefone");

		txtApp = new TextField();
		txtApp.setPromptText("App");

		btnCadastrar = new Button("Cadastrar");
		btnCadastrar.setOnAction(cadastrar());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(txtNumAgencia, txtCidade, txttelefone, txtApp, btnCadastrar, btnVoltar);

	}

	private void configLayout() {
		pane.setPrefSize(320, 205);
		
		txtNumAgencia.setLayoutX(10);
		txtNumAgencia.setLayoutY(10);
		txtNumAgencia.setPrefHeight(30);
		txtNumAgencia.setPrefWidth(pane.getPrefWidth() - 20);

		txtCidade.setLayoutX(10);
		txtCidade.setLayoutY(50);
		txtCidade.setPrefHeight(30);
		txtCidade.setPrefWidth(pane.getPrefWidth() - 20);

		txttelefone.setLayoutX(10);
		txttelefone.setLayoutY(90);
		txttelefone.setPrefHeight(30);
		txttelefone.setPrefWidth(pane.getPrefWidth() - 20);

		txtApp.setLayoutX(10);
		txtApp.setLayoutY(130);
		txtApp.setPrefHeight(30);
		txtApp.setPrefWidth(pane.getPrefWidth() - 20);

		btnCadastrar.setLayoutX(10);
		btnCadastrar.setLayoutY(170);
		btnCadastrar.setPrefHeight(20);
		btnCadastrar.setPrefWidth((pane.getPrefWidth() - 30) / 2);

		btnVoltar.setLayoutX(btnCadastrar.getPrefWidth() + 20);
		btnVoltar.setLayoutY(170);
		btnVoltar.setPrefHeight(20);
		btnVoltar.setPrefWidth((pane.getPrefWidth() - 30) / 2);
	}

	private EventHandler<ActionEvent> voltar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				abrirJanelaLogin();
			}
		};
	}

	private EventHandler<ActionEvent> cadastrar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtNumAgencia.getText().isBlank()) {
					Alertas.alerta("Agencia em branco!");
					return;
				}
			
				if (txtCidade.getText().isBlank()) {
					Alertas.alerta("Cidade em branco!");
					return;
				}
				if (txttelefone.getText().isBlank()) {
					Alertas.alerta("Telefone em branco!");
					return;
				}
				
				if (txtApp.getText().isBlank()) {
					Alertas.alerta("App em branco!");
					return;
				}

				new AgenciaDAO().adicionar(new Agencia(txtNumAgencia.getText(), txtCidade.getText(), txttelefone.getText(), txtApp.getText()));

				Alertas.info("Agencia cadastrada com sucesso :)");

				abrirJanelaLogin();
			}
		};
	}

	private void abrirJanelaLogin() {
		try {
			new Login().start(stage);
		} catch (Exception e) {
			Alertas.erro("Nao foi possivel iniciar a tela de login!");
		}
	}
}
