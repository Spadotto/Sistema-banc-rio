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
import poo4.ClassesFilhas.FCliente;
import poo4.Database.FClienteDAO;

public class AlterarFCliente extends Application {

	private String agencia;
	private Stage stage;
	private Pane pane;
	private TextField txtNome;
	private TextField txtCpf;
	private TextField txtEmail;
	private TextField txtTelefone;
	private Button btnVoltar;
	private Button btnAlterar;
	private FCliente fc;

	public AlterarFCliente(String agencia, FCliente fc) {
		this.agencia = agencia;
		this.fc = fc;
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
		txtNome.setText(String.valueOf(fc.getNome()));

		txtCpf = new TextField();
		txtCpf.setPromptText("Cpf Cliente");
		txtCpf.setText(String.valueOf(fc.getCPF()));
		
		txtEmail = new TextField();
		txtEmail.setPromptText("Email Cliente");
		txtEmail.setText(String.valueOf(fc.getEmail()));
		
		txtTelefone = new TextField();
		txtTelefone.setPromptText("Telefone Cliente");
		txtTelefone.setText(String.valueOf(fc.getTelefonepessoal()));

		btnAlterar = new Button("Alterar");
		btnAlterar.setOnAction(alterar());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(txtNome, txtCpf, txtEmail, txtTelefone, btnAlterar, btnVoltar);

	}

	private void configLayout() {
		pane.setPrefSize(320, 210);

		txtNome.setLayoutX(10);
		txtNome.setLayoutY(10);
		txtNome.setPrefHeight(30);
		txtNome.setPrefWidth(pane.getPrefWidth() - 20);

		txtCpf.setLayoutX(10);
		txtCpf.setLayoutY(50);
		txtCpf.setPrefHeight(30);
		txtCpf.setPrefWidth(pane.getPrefWidth() - 20);

		txtEmail.setLayoutX(10);
		txtEmail.setLayoutY(90);
		txtEmail.setPrefHeight(30);
		txtEmail.setPrefWidth(pane.getPrefWidth() - 20);

		txtTelefone.setLayoutX(10);
		txtTelefone.setLayoutY(130);
		txtTelefone.setPrefHeight(30);
		txtTelefone.setPrefWidth(pane.getPrefWidth() - 20);

		btnAlterar.setLayoutX(10);
		btnAlterar.setLayoutY(170);
		btnAlterar.setPrefHeight(20);
		btnAlterar.setPrefWidth((pane.getPrefWidth() - 30) / 2);

		btnVoltar.setLayoutX(btnAlterar.getPrefWidth() + 20);
		btnVoltar.setLayoutY(170);
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
				fc.setNome(String.valueOf(txtNome.getText()));
				new FClienteDAO().atualizar("Nome", txtNome.getText(), fc.getNumConta());
				
				if (txtCpf.getText().isBlank()) {
					Alertas.alerta("CPF em branco!");
					return;
				}
				fc.setCPF(String.valueOf(txtCpf.getText()));
				new FClienteDAO().atualizar("CPF", txtCpf.getText(), fc.getNumConta());
				
				if (txtEmail.getText().isBlank()) {
					Alertas.alerta("Email em branco!");
					return;
				}
				fc.setEmail(String.valueOf(txtEmail.getText()));
				new FClienteDAO().atualizar("Email", txtEmail.getText(), fc.getNumConta());
				
				if (txtTelefone.getText().isBlank()) {
					Alertas.alerta("Telefone em branco!");
					return;
				}
				fc.setTelefonepessoal(String.valueOf(txtTelefone.getText()));
				new FClienteDAO().atualizar("Telefone", txtTelefone.getText(), fc.getNumConta());

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
