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
import poo4.ClassesFilhas.JCliente;
import poo4.Database.JClienteDAO;
import poo4.Database.UtilBD;

public class CadastrarJCliente extends Application {

	private Stage stage;
	private Pane pane;
	private String agencia;
	private String numConta;
	private TextField txtNumConta;
	private TextField txtNome;
	private TextField txtNomefantasia;
	private TextField txtCnpj;
	private TextField txtEmail;
	private TextField txttelefone;
	private Button btnVoltar;
	private Button btnCadastrar;
	private Button btnCriarconta;
	
	public CadastrarJCliente(String agencia) {
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
		txtNome.setPromptText("Gerente");
		
		txtCnpj = new TextField();
		txtCnpj.setPromptText("CNPJ");
		
		txtEmail = new TextField();
		txtEmail.setPromptText("Email");
		
		txtNomefantasia = new TextField();
		txtNomefantasia.setPromptText("Nome Fantasia");

		txttelefone = new TextField();
		txttelefone.setPromptText("Telefone");

		btnCadastrar = new Button("Cadastrar");
		btnCadastrar.setOnAction(cadastrar());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());
		
		btnCriarconta = new Button("Criar Conta");
		btnCriarconta.setOnAction(criarconta());

		pane = new AnchorPane();
		pane.getChildren().addAll(txtNumConta, txtNome, txtCnpj, txtNomefantasia, txtEmail, txttelefone, btnCadastrar, btnVoltar, btnCriarconta);

	}

	private void configLayout() {
		pane.setPrefSize(320, 325);
		
		txtNumConta.setLayoutX(10);
		txtNumConta.setLayoutY(10);
		txtNumConta.setPrefHeight(30);
		txtNumConta.setPrefWidth(pane.getPrefWidth() - 20);

		txtNome.setLayoutX(10);
		txtNome.setLayoutY(50);
		txtNome.setPrefHeight(30);
		txtNome.setPrefWidth(pane.getPrefWidth() - 20);

		txtCnpj.setLayoutX(10);
		txtCnpj.setLayoutY(90);
		txtCnpj.setPrefHeight(30);
		txtCnpj.setPrefWidth(pane.getPrefWidth() - 20);
		
		txtNomefantasia.setLayoutX(10);
		txtNomefantasia.setLayoutY(130);
		txtNomefantasia.setPrefHeight(30);
		txtNomefantasia.setPrefWidth(pane.getPrefWidth() - 20);

		txtEmail.setLayoutX(10);
		txtEmail.setLayoutY(170);
		txtEmail.setPrefHeight(30);
		txtEmail.setPrefWidth(pane.getPrefWidth() - 20);
		
		txttelefone.setLayoutX(10);
		txttelefone.setLayoutY(210);
		txttelefone.setPrefHeight(30);
		txttelefone.setPrefWidth(pane.getPrefWidth() - 20);

		btnCadastrar.setLayoutX(10);
		btnCadastrar.setLayoutY(250);
		btnCadastrar.setPrefHeight(20);
		btnCadastrar.setPrefWidth((pane.getPrefWidth() - 30) / 2);

		btnVoltar.setLayoutX(btnCadastrar.getPrefWidth() + 20);
		btnVoltar.setLayoutY(250);
		btnVoltar.setPrefHeight(20);
		btnVoltar.setPrefWidth((pane.getPrefWidth() - 30) / 2);
		
		btnCriarconta.setLayoutX(10);
		btnCriarconta.setLayoutY(290);
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
				
				if (txtCnpj.getText().isBlank()) {
					Alertas.alerta("CPF em branco!");
					return;
				}
				
				if (txtEmail.getText().isBlank()) {
					Alertas.alerta("Email em branco!");
					return;
				}
				
				if (txtNomefantasia.getText().isBlank()) {
					Alertas.alerta("Nome fantasia em branco!");
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
					new JClienteDAO().adicionar(new JCliente(txtNumConta.getText(), txtNome.getText(), txtCnpj.getText(), txtEmail.getText(), txtNomefantasia.getText(), txttelefone.getText()));
					Alertas.info("Cliente cadastrado com sucesso :)");
				} catch (SQLException e) {
					System.out.println("Nao foi possivel criar a conta no banco!");
				}

				voltar();
			}
		};
	}
}
