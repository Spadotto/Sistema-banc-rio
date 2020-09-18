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
import poo4.ClassesFilhas.JCliente;
import poo4.Database.JClienteDAO;

public class AlterarJCliente extends Application {

	private String agencia;
	private Stage stage;
	private Pane pane;
	private TextField txtNome;
	private TextField txtCnpj;
	private TextField txtNomefantasia;
	private TextField txtEmail;
	private TextField txtTelefone;
	private Button btnVoltar;
	private Button btnAlterar;
	private JCliente jc;

	public AlterarJCliente(String agencia, JCliente jc) {
		this.agencia = agencia;
		this.jc = jc;
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		this.stage = stage;
		initComponentes();
		configLayout();

		Scene scene = new Scene(pane);
		btnVoltar.requestFocus();

		stage.setScene(scene);
		stage.setTitle("Alteracao de um cliente");
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() {
		txtNome = new TextField();
		txtNome.setPromptText("Nome Cliente");
		txtNome.setText(String.valueOf(jc.getNome()));

		txtCnpj = new TextField();
		txtCnpj.setPromptText("Cpf Cliente");
		txtCnpj.setText(String.valueOf(jc.getCnpj()));
		
		txtEmail = new TextField();
		txtEmail.setPromptText("Email Cliente");
		txtEmail.setText(String.valueOf(jc.getEmail()));
		
		txtNomefantasia = new TextField();
		txtNomefantasia.setPromptText("Nome Cliente");
		txtNomefantasia.setText(String.valueOf(jc.getNomefantasia()));
		
		txtTelefone = new TextField();
		txtTelefone.setPromptText("Telefone Cliente");
		txtTelefone.setText(String.valueOf(jc.getTelefoneempresa()));

		btnAlterar = new Button("Alterar");
		btnAlterar.setOnAction(alterar());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(txtNome, txtCnpj, txtEmail, txtNomefantasia, txtTelefone, btnAlterar, btnVoltar);

	}

	private void configLayout() {
		pane.setPrefSize(320, 245);

		txtNome.setLayoutX(10);
		txtNome.setLayoutY(10);
		txtNome.setPrefHeight(30);
		txtNome.setPrefWidth(pane.getPrefWidth() - 20);

		txtCnpj.setLayoutX(10);
		txtCnpj.setLayoutY(50);
		txtCnpj.setPrefHeight(30);
		txtCnpj.setPrefWidth(pane.getPrefWidth() - 20);

		txtEmail.setLayoutX(10);
		txtEmail.setLayoutY(90);
		txtEmail.setPrefHeight(30);
		txtEmail.setPrefWidth(pane.getPrefWidth() - 20);
		
		txtNomefantasia.setLayoutX(10);
		txtNomefantasia.setLayoutY(130);
		txtNomefantasia.setPrefHeight(30);
		txtNomefantasia.setPrefWidth(pane.getPrefWidth() - 20);

		txtTelefone.setLayoutX(10);
		txtTelefone.setLayoutY(170);
		txtTelefone.setPrefHeight(30);
		txtTelefone.setPrefWidth(pane.getPrefWidth() - 20);

		btnAlterar.setLayoutX(10);
		btnAlterar.setLayoutY(210);
		btnAlterar.setPrefHeight(20);
		btnAlterar.setPrefWidth((pane.getPrefWidth() - 30) / 2);

		btnVoltar.setLayoutX(btnAlterar.getPrefWidth() + 20);
		btnVoltar.setLayoutY(210);
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
				if (txtNome.getText().isBlank()) {
					Alertas.alerta("Nome em branco!");
					return;
				}
				jc.setNome(String.valueOf(txtNome.getText()));
				new JClienteDAO().atualizar("Gerente", txtNome.getText(), jc.getNumConta());
				
				if (txtCnpj.getText().isBlank()) {
					Alertas.alerta("CPF em branco!");
					return;
				}
				jc.setCnpj(String.valueOf(txtCnpj.getText()));
				new JClienteDAO().atualizar("CNPJ", txtCnpj.getText(), jc.getNumConta());
				
				if (txtEmail.getText().isBlank()) {
					Alertas.alerta("Email em branco!");
					return;
				}
				jc.setEmail(String.valueOf(txtEmail.getText()));
				new JClienteDAO().atualizar("Email", txtEmail.getText(), jc.getNumConta());
				
				if (txtNomefantasia.getText().isBlank()) {
					Alertas.alerta("Nome Fantasia em branco!");
					return;
				}
				jc.setNomefantasia(String.valueOf(txtNomefantasia.getText()));
				new JClienteDAO().atualizar("Nome Fantasia", txtNomefantasia.getText(), jc.getNumConta());
				
				if (txtTelefone.getText().isBlank()) {
					Alertas.alerta("Telefone em branco!");
					return;
				}
				jc.setTelefoneempresa(String.valueOf(txtTelefone.getText()));
				new JClienteDAO().atualizar("Telefone", txtTelefone.getText(), jc.getNumConta());

				Alertas.info("Cliente atualizado com sucesso :)");

				abrirJanelaPrincipal();
			}
		};
	}

	private void abrirJanelaPrincipal() {
		try {
			new Clientes(agencia).start(stage);
		} catch (Exception e) {
			Alertas.erro("Nao foi possivel iniciar a tela principal!");
		}
	}

}
