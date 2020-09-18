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
import poo4.Database.AgenciaDAO;

public class Alterar extends Application {

	private String agencia;
	private Stage stage;
	private Pane pane;
	private TextField txtcidade;
	private TextField txtapp;
	private TextField txtTelefone;
	private Button btnVoltar;
	private Button btnAlterar;
	private Agencia ag;

	public Alterar(String agencia, Agencia ag) {
		this.agencia = agencia;
		this.ag = ag;
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		this.stage = stage;
		initComponentes();
		configLayout();

		Scene scene = new Scene(pane);
		btnVoltar.requestFocus();

		stage.setScene(scene);
		stage.setTitle("Alteracao de uma agencia");
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() {
		
		txtcidade = new TextField();
		txtcidade.setPromptText("Cidade");
		txtcidade.setText(String.valueOf(ag.getCidade()));

		txtTelefone = new TextField();
		txtTelefone.setPromptText("Telefone");
		txtTelefone.setText(String.valueOf(ag.getTelefone()));
		
		txtapp = new TextField();
		txtapp.setPromptText("Cpf Cliente");
		txtapp.setText(String.valueOf(ag.getApp()));

		btnAlterar = new Button("Alterar");
		btnAlterar.setOnAction(alterar());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(txtcidade, txtTelefone, txtapp, btnAlterar, btnVoltar);

	}

	private void configLayout() {
		pane.setPrefSize(320, 165);

		txtcidade.setLayoutX(10);
		txtcidade.setLayoutY(10);
		txtcidade.setPrefHeight(30);
		txtcidade.setPrefWidth(pane.getPrefWidth() - 20);

		txtapp.setLayoutX(10);
		txtapp.setLayoutY(50);
		txtapp.setPrefHeight(30);
		txtapp.setPrefWidth(pane.getPrefWidth() - 20);

		txtTelefone.setLayoutX(10);
		txtTelefone.setLayoutY(90);
		txtTelefone.setPrefHeight(30);
		txtTelefone.setPrefWidth(pane.getPrefWidth() - 20);

		btnAlterar.setLayoutX(10);
		btnAlterar.setLayoutY(130);
		btnAlterar.setPrefHeight(20);
		btnAlterar.setPrefWidth((pane.getPrefWidth() - 30) / 2);

		btnVoltar.setLayoutX(btnAlterar.getPrefWidth() + 20);
		btnVoltar.setLayoutY(130);
		btnVoltar.setPrefHeight(20);
		btnVoltar.setPrefWidth((pane.getPrefWidth() - 30) / 2);
	}

	private EventHandler<ActionEvent> voltar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				abrirJanelaPrincipal();
			}
		};
	}

	private EventHandler<ActionEvent> alterar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtcidade.getText().isBlank()) {
					Alertas.alerta("Cidade em branco!");
					return;
				}
				ag.setCidade(String.valueOf(txtcidade.getText()));
				new AgenciaDAO().atualizar("Cidade", txtcidade.getText(), ag.getNumAgencia());
				
				if (txtapp.getText().isBlank()) {
					Alertas.alerta("App em branco!");
					return;
				}
				ag.setApp(String.valueOf(txtapp.getText()));
				new AgenciaDAO().atualizar("App", txtapp.getText(), ag.getNumAgencia());
				
				if (txtTelefone.getText().isBlank()) {
					Alertas.alerta("Telefone em branco!");
					return;
				}
				ag.setTelefone(String.valueOf(txtTelefone.getText()));
				new AgenciaDAO().atualizar("Telefone", txtTelefone.getText(), ag.getNumAgencia());

				Alertas.info("Cliente atualizado com sucesso :)");

				abrirJanelaPrincipal();
			}
		};
	}

	private void abrirJanelaPrincipal() {
		try {
			new Agenciamenu(agencia).start(stage);
		} catch (Exception e) {
			Alertas.erro("Nao foi possivel iniciar a tela principal!");
		}
	}

}
