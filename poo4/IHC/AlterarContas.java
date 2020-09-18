package poo4.IHC;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import poo4.ClassesFilhas.CCorrente;
import poo4.ClassesFilhas.CPoupanca;
import poo4.Database.CCorrenteDAO;
import poo4.Database.CPoupancaDAO;

public class AlterarContas extends Application {

	private String agencia;
	private Stage stage;
	private Pane pane;
	private TextField txtcc;
	private TextField txtcsaldo;
	private TextField txtcp;
	private TextField txtpsaldo;
	private Button btnVoltar;
	private Button btnAlterar;
	private String nc;
	private String numcc;
	private String numcp;
	private Label lblcc;
	private Label lblcp;
	private double nsaldo;
	private double nsaldo2;

	public AlterarContas(String agencia, String nc) {
		this.agencia = agencia;
		this.nc = nc;
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
		CPoupanca cp = new CPoupancaDAO().get(nc);
		CCorrente cc = new CCorrenteDAO().get(nc);
		
		lblcc = new Label("Conta Corrente");
		
		txtcc = new TextField();
		txtcc.setPromptText("Conta Corrente");
		txtcc.setText(String.valueOf(cc.getNumCorrente()));

		txtcsaldo = new TextField();
		txtcsaldo.setPromptText("Saldo");
		txtcsaldo.setText(String.valueOf(cc.getSaldo()));
		
		lblcp = new Label("Conta Poupanca");
		
		txtcp = new TextField();
		txtcp.setPromptText("Conta Poupanca");
		txtcp.setText(String.valueOf(cp.getNumPoupanca()));
		
		txtpsaldo = new TextField();
		txtpsaldo.setPromptText("Saldo");
		txtpsaldo.setText(String.valueOf(cp.getSaldo()));

		btnAlterar = new Button("Alterar");
		btnAlterar.setOnAction(alterar());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(lblcc, lblcp);
		pane.getChildren().addAll(txtcc, txtcsaldo, txtcp, txtpsaldo, btnAlterar, btnVoltar);

	}

	private void configLayout() {
		pane.setPrefSize(320, 285);
		
		lblcc.setLayoutX(10);
		lblcc.setLayoutY(10);

		txtcc.setLayoutX(10);
		txtcc.setLayoutY(50);
		txtcc.setPrefHeight(30);
		txtcc.setPrefWidth(pane.getPrefWidth() - 20);

		txtcsaldo.setLayoutX(10);
		txtcsaldo.setLayoutY(90);
		txtcsaldo.setPrefHeight(30);
		txtcsaldo.setPrefWidth(pane.getPrefWidth() - 20);

		lblcp.setLayoutX(10);
		lblcp.setLayoutY(130);
		
		txtcp.setLayoutX(10);
		txtcp.setLayoutY(170);
		txtcp.setPrefHeight(30);
		txtcp.setPrefWidth(pane.getPrefWidth() - 20);
		
		txtpsaldo.setLayoutX(10);
		txtpsaldo.setLayoutY(210);
		txtpsaldo.setPrefHeight(30);
		txtpsaldo.setPrefWidth(pane.getPrefWidth() - 20);		

		btnAlterar.setLayoutX(10);
		btnAlterar.setLayoutY(250);
		btnAlterar.setPrefHeight(20);
		btnAlterar.setPrefWidth((pane.getPrefWidth() - 30) / 2);

		btnVoltar.setLayoutX(btnAlterar.getPrefWidth() + 20);
		btnVoltar.setLayoutY(250);
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
				if (txtcc.getText().isBlank()) {
					Alertas.alerta("Conta em branco!");
					return;
				}
				numcc = (String.valueOf(txtcc.getText()));
				
				if (txtcsaldo.getText().isBlank()) {
					Alertas.alerta("Saldo em branco!");
					return;
				}
				nsaldo = Double.valueOf(txtcsaldo.getText());
				new CCorrenteDAO().atualizar(numcc, nsaldo, nc);
			
				if (txtcp.getText().isBlank()) {
					Alertas.alerta("Conta em branco!");
					return;
				}
				numcp = (String.valueOf(txtcp.getText()));
				
				if (txtpsaldo.getText().isBlank()) {
					Alertas.alerta("Saldo em branco!");
					return;
				}
				nsaldo2 = Double.valueOf(txtpsaldo.getText());
				new CPoupancaDAO().atualizar(numcp, nsaldo2, nc);

				Alertas.info("Cliente atualizado com sucesso :)");

				abrirJanelaPrincipal();
			}
		};
	}

	private void abrirJanelaPrincipal() {
		try {
			new Clientes(agencia).start(stage);
		} catch (Exception e) {
			Alertas.erro("Nao foi possivel iniciar o menu de clientes!");
		}
	}

}
