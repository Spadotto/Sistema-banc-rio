package poo4.IHC;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Principal extends Application {

	private Stage stage;
	private Pane pane;
	private String Agencia;
	private Button btnAgencia;
	private Button btnCliente;
	private Button btnSair;
	private Label lblBanco;

	public Principal(String Agencia) {
		if (Agencia.isBlank())
			Agencia = "Erro - Numero de agencia em branco!";
		this.Agencia = Agencia;
	}

	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;
		initComponentes();
		configLayout();

		Scene scene = new Scene(pane);
		btnSair.requestFocus();

		stage.setScene(scene);
		stage.setTitle("Agencia " + Agencia);
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() {
		
		lblBanco = new Label("Menu Principal");

		btnAgencia = new Button("Agencia");
		btnAgencia.setOnAction(abrirAgencia());

		btnCliente = new Button("Cliente");
		btnCliente.setOnAction(abrirCliente());

		btnSair = new Button("Sair");
		btnSair.setOnAction(sair());

		pane = new AnchorPane();
		pane.getChildren().add(lblBanco);
		pane.getChildren().addAll(btnAgencia, btnCliente, btnSair);

	}

	private void configLayout() {
		pane.setPrefSize(320, 160);
		
		lblBanco.setLayoutX(10);
		lblBanco.setLayoutY(10);

		btnAgencia.setLayoutX(10);
		btnAgencia.setLayoutY(35);
		btnAgencia.setPrefHeight(30);
		btnAgencia.setPrefWidth(pane.getPrefWidth() - 20);

		btnCliente.setLayoutX(10);
		btnCliente.setLayoutY(75);
		btnCliente.setPrefHeight(30);
		btnCliente.setPrefWidth(pane.getPrefWidth() - 20);

		btnSair.setLayoutX(10);
		btnSair.setLayoutY(115);
		btnSair.setPrefHeight(30);
		btnSair.setPrefWidth(pane.getPrefWidth() - 20);
	}

	private EventHandler<ActionEvent> abrirCliente() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new Clientes(Agencia).start(stage);
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel iniciar o menu de clientes!");
				}
			}
		};
	}
	
	private EventHandler<ActionEvent> abrirAgencia() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new Agenciamenu(Agencia).start(stage);
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel iniciar o menu de agencias!");
				}
			}
		};
	}

	private EventHandler<ActionEvent> sair() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new Login().start(stage);
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel iniciar a tela de login");
				}
			}
		};
	}
}
