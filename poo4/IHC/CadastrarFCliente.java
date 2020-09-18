package poo4.IHC;

import java.sql.SQLException;
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
import poo4.Database.UtilBD;

public class CadastrarFCliente extends Application {

	private Stage stage;
	private Pane pane;
	private String agencia;
	private String numConta;
	private TextField txtNumConta;
	private TextField txtNome;
	private TextField txtCpf;
	private TextField txtEmail;
	private TextField txttelefone;
	private Button btnVoltar;
	private Button btnCadastrar;
	private Button btnCriarconta;
	
	public CadastrarFCliente(String agencia) {
		if (agencia.isBlank())
			agencia = "Erro - Numero de agencia em branco!";
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
		stage.setTitle("Registro de um novo cliente");
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() {
		txtNumConta = new TextField();
		txtNumConta.setPromptText("Numero da Conta");

		txtNome = new TextField();
		txtNome.setPromptText("Nome");
		
		txtCpf = new TextField();
		txtCpf.setPromptText("Cpf");
		
		txtEmail = new TextField();
		txtEmail.setPromptText("Email");

		txttelefone = new TextField();
		txttelefone.setPromptText("Telefone");

		btnCadastrar = new Button("Cadastrar");
		btnCadastrar.setOnAction(cadastrar());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());
		
		btnCriarconta = new Button("Criar Conta");
		btnCriarconta.setOnAction(criarconta());

		pane = new AnchorPane();
		pane.getChildren().addAll(txtNumConta, txtNome, txtCpf, txtEmail, txttelefone, btnCadastrar, btnVoltar, btnCriarconta);

	}

	private void configLayout() {
		pane.setPrefSize(320, 285);
		
		txtNumConta.setLayoutX(10);
		txtNumConta.setLayoutY(10);
		txtNumConta.setPrefHeight(30);
		txtNumConta.setPrefWidth(pane.getPrefWidth() - 20);

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
		
		txttelefone.setLayoutX(10);
		txttelefone.setLayoutY(170);
		txttelefone.setPrefHeight(30);
		txttelefone.setPrefWidth(pane.getPrefWidth() - 20);

		btnCadastrar.setLayoutX(10);
		btnCadastrar.setLayoutY(210);
		btnCadastrar.setPrefHeight(20);
		btnCadastrar.setPrefWidth((pane.getPrefWidth() - 30) / 2);

		btnVoltar.setLayoutX(btnCadastrar.getPrefWidth() + 20);
		btnVoltar.setLayoutY(210);
		btnVoltar.setPrefHeight(20);
		btnVoltar.setPrefWidth((pane.getPrefWidth() - 30) / 2);
		
		btnCriarconta.setLayoutX(10);
		btnCriarconta.setLayoutY(250);
		btnCriarconta.setPrefHeight(30);
		btnCriarconta.setPrefWidth(pane.getPrefWidth() - 20);
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
	
	private EventHandler<ActionEvent> criarconta() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					if (txtNumConta.getText().isBlank()) {
						Alertas.alerta("NumConta em branco!");
						return;
					}
					new Contas(txtNumConta.getText(), agencia).start(stage);
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel iniciar o menu de contas!");
				};
			}
		};
	}

	private EventHandler<ActionEvent> cadastrar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtNumConta.getText().isBlank()) {
					Alertas.alerta("NumConta em branco!");
					return;
				}
			
				if (txtNome.getText().isBlank()) {
					Alertas.alerta("Nome em branco!");
					return;
				}
				
				if (txtCpf.getText().isBlank()) {
					Alertas.alerta("CPF em branco!");
					return;
				}
				
				if (txtEmail.getText().isBlank()) {
					Alertas.alerta("Email em branco!");
					return;
				}
				
				if (txttelefone.getText().isBlank()) {
					Alertas.alerta("Telefone em branco!");
					return;
				}
				
				numConta = txtNumConta.getText();

				try {
					String sql = "INSERT INTO Conta VALUES ('" + numConta + "','" + agencia + "');";
					UtilBD.alterarBD(sql);
					new FClienteDAO().adicionar(new FCliente(txtNumConta.getText(), txtNome.getText(), txtCpf.getText(), txtEmail.getText(), txttelefone.getText()));
					Alertas.info("Cliente cadastrado com sucesso :)");
				} catch (SQLException e) {
					System.out.println("Nao foi possivel criar a conta no banco!");
				}

				voltar();
			}
		};
	}
}
