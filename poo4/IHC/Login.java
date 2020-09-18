package poo4.IHC;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import poo4.ClassesFilhas.Agencia;
import poo4.Database.AgenciaDAO;

public class Login extends Application {

	private Stage stage;
	private Label lblBanco;
	private TextField txtUsuario;
	private Button btnEntrar;
	private Button btnSair;
	private Button btnCadastrar;
	private Pane pane;

	@Override
	public void start(Stage stage) { 

		this.stage = stage;
		initComponentes();
		configLayout();

		Scene scene = new Scene(pane);
		btnEntrar.requestFocus(); 

		stage.setScene(scene);
		stage.setTitle("Banco login");
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() {
		lblBanco = new Label("Bem-vindo ao Banco");

		txtUsuario = new TextField();
		txtUsuario.setPromptText("Digite aqui a agencia");

		btnEntrar = new Button("Entrar");
		btnEntrar.setOnAction(entrar());

		btnSair = new Button("Sair");
		btnSair.setOnAction(sair());

		btnCadastrar = new Button("Registrar nova conta");
		btnCadastrar.setOnAction(abrirJanelaCadastro());

		pane = new AnchorPane();

		pane.getChildren().add(lblBanco);
		pane.getChildren().addAll(txtUsuario, btnEntrar, btnSair, btnCadastrar);
	}

	private void configLayout() {
		pane.setPrefSize(320, 150);
		
		lblBanco.setLayoutX(10);
		lblBanco.setLayoutY(10);

		txtUsuario.setLayoutX(10);
		txtUsuario.setLayoutY(35);
		txtUsuario.setPrefHeight(30);
		txtUsuario.setPrefWidth(pane.getPrefWidth() - 20);

		btnEntrar.setLayoutX(10);
		btnEntrar.setLayoutY(75);
		btnEntrar.setPrefHeight(20);
		btnEntrar.setPrefWidth((pane.getPrefWidth() - 30) / 2);

		btnSair.setLayoutX(btnEntrar.getPrefWidth() + 20);
		btnSair.setLayoutY(75);
		btnSair.setPrefHeight(20);
		btnSair.setPrefWidth((pane.getPrefWidth() - 30) / 2);

		btnCadastrar.setLayoutX(10);
		btnCadastrar.setLayoutY(115);
		btnCadastrar.setPrefHeight(20);
		btnCadastrar.setPrefWidth(pane.getPrefWidth() - 20);
	}

	private EventHandler<ActionEvent> entrar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					if (txtUsuario.getText().isBlank()) {
						Alertas.alerta("Numero da Agencia!");
						return;
					}

					Agencia usuarioBD = new AgenciaDAO().get(txtUsuario.getText());

					if (usuarioBD == null) {
						Alertas.alerta("Agencia nao encontrada!");
						return;
					}

					new Principal(txtUsuario.getText()).start(stage);
				} catch (Exception e) {
					Alertas.alerta("Nao foi possivel iniciar a tela principal!");
				}
			}
		};
	 }

	private EventHandler<ActionEvent> sair() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		};
	}

	private EventHandler<ActionEvent> abrirJanelaCadastro() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new CadastrarAgencia().start(stage);
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel iniciar a tela de cadastro de agencia!");
				}
			}
		};
	}
}
