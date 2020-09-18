package poo4.IHC;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import poo4.ClassesFilhas.CCorrente;
import poo4.ClassesFilhas.CPoupanca;
import poo4.ClassesFilhas.FCliente;
import poo4.ClassesFilhas.JCliente;
import poo4.Database.CCorrenteDAO;
import poo4.Database.CPoupancaDAO;
import poo4.Database.FClienteDAO;
import poo4.Database.JClienteDAO;

public class Clientes extends Application {
	
	private Stage stage;
	private Pane pane;
	private String agencia;
	private String numconta;
	private Button btnCadastrarFCliente;
	private Button btnCadastrarJCliente;
	private Button btnAlterarCliente;
	private Button btnAlterarContas;
	private Button btnExcluirCliente;
	private Button btnVisualizar;
	private Button btnVoltar;
	private ListView<String> listaClientes;
	
	public Clientes(String Agencia) {
		if (Agencia.isBlank())
			Agencia = "Erro - Numero de agencia em branco!";
		this.agencia = Agencia;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		this.stage = stage;
		initComponentes();
		configLayout();

		Scene scene = new Scene(pane);
		btnVoltar.requestFocus();

		stage.setScene(scene);
		stage.setTitle("Menu do Cliente");
		stage.setResizable(false);
		stage.show();
	}
	
	private void initComponentes() {
		listaClientes = new ListView<String>();
		ObservableList<String> items = FXCollections.observableArrayList(geraListaClientes());
		listaClientes.setItems(items);

		btnCadastrarFCliente = new Button("Cads. fisico");
		btnCadastrarFCliente.setOnAction(CadastrarFCliente());
		
		btnCadastrarJCliente = new Button("Cads. juridico");
		btnCadastrarJCliente.setOnAction(CadastrarJCliente());

		btnAlterarCliente = new Button("Alterar Cliente");
		btnAlterarCliente.setOnAction(AlterarCliente());
		
		btnAlterarContas = new Button("Alterar Conta");
		btnAlterarContas.setOnAction(AlteracaoContas());
		
		btnVisualizar = new Button("Visualizar Dados");
		btnVisualizar.setOnAction(Visualizar());

		btnExcluirCliente = new Button("Excluir cliente");
		btnExcluirCliente.setOnAction(ExcluirCliente());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(listaClientes, btnCadastrarFCliente, btnCadastrarJCliente, btnExcluirCliente, btnAlterarCliente, btnAlterarContas, btnVisualizar, btnVoltar);

	}

	private void configLayout() {
		pane.setPrefSize(670, 480);

		listaClientes.setLayoutX(10);
		listaClientes.setLayoutY(10);
		listaClientes.setPrefHeight(pane.getPrefHeight() - 55);
		listaClientes.setPrefWidth(pane.getPrefWidth() - 20);

		btnCadastrarFCliente.setLayoutX(pane.getPrefWidth() - 660);
		btnCadastrarFCliente.setLayoutY(pane.getPrefHeight() - 35);
		btnCadastrarFCliente.setPrefHeight(20);
		btnCadastrarFCliente.setPrefWidth(100);

		btnCadastrarJCliente.setLayoutX(pane.getPrefWidth() - 560);
		btnCadastrarJCliente.setLayoutY(pane.getPrefHeight() - 35);
		btnCadastrarJCliente.setPrefHeight(20);
		btnCadastrarJCliente.setPrefWidth(100);

		btnExcluirCliente.setLayoutX(pane.getPrefWidth() - 460);
		btnExcluirCliente.setLayoutY(pane.getPrefHeight() - 35);
		btnExcluirCliente.setPrefHeight(20);
		btnExcluirCliente.setPrefWidth(100);
		
		btnAlterarCliente.setLayoutX(pane.getPrefWidth() - 360);
		btnAlterarCliente.setLayoutY(pane.getPrefHeight() - 35);
		btnAlterarCliente.setPrefHeight(20);
		btnAlterarCliente.setPrefWidth(100);
		
		btnAlterarContas.setLayoutX(pane.getPrefWidth() - 260);
		btnAlterarContas.setLayoutY(pane.getPrefHeight() - 35);
		btnAlterarContas.setPrefHeight(20);
		btnAlterarContas.setPrefWidth(100);
		
		btnVisualizar.setLayoutX(pane.getPrefWidth() - 160);
		btnVisualizar.setLayoutY(pane.getPrefHeight() - 35);
		btnVisualizar.setPrefHeight(20);
		btnVisualizar.setPrefWidth(100);

		btnVoltar.setLayoutX(pane.getPrefWidth() - 60);
		btnVoltar.setLayoutY(pane.getPrefHeight() - 35);
		btnVoltar.setPrefHeight(20);
		btnVoltar.setPrefWidth(50);
		
	}
	
	private List<String> geraListaClientes() {
		List<String> retorno = new ArrayList<String>();
		List<FCliente> fcliente = new FClienteDAO().todos();
		retorno.add("Clientes Fisicos:");
		for (FCliente fc : fcliente)
			retorno.add(fc.getNumConta());
		
		List<JCliente> jcliente = new JClienteDAO().todos();
		retorno.add("Clientes Juridicos:");
		for (JCliente jc : jcliente)
			retorno.add(jc.getNumConta());
		return retorno;
	}
	
	private EventHandler<ActionEvent> Visualizar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (listaClientes.getSelectionModel().isEmpty()) {
					Alertas.alerta("Selecione um cliente para ser visualizado.");
					return;
				}
				
				String numConta = listaClientes.getSelectionModel().getSelectedItem();
				FCliente fc = new FClienteDAO().get(numConta);
				JCliente jc = new JClienteDAO().get(numConta);
				CCorrente cc = new CCorrenteDAO().get(numConta);
				CPoupanca cp = new CPoupancaDAO().get(numConta);
				
				try {
					new VisualizarFCliente(agencia, fc, cc, cp).start(stage);
				} catch (Exception e) {
					try {
						new VisualizarJCliente(agencia, jc, cc, cp).start(stage);
					} catch (Exception e1) {
						Alertas.alerta("Erro ao visualizar cliente.");
					}
				}
			}
		};
	}
	
	private EventHandler<ActionEvent> AlteracaoContas() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (listaClientes.getSelectionModel().isEmpty()) {
					Alertas.alerta("Selecione um cliente para ser alterado.");
					return;
				}
				
				String numConta = listaClientes.getSelectionModel().getSelectedItem();
				FCliente cc = new FClienteDAO().get(numConta);
				JCliente cp = new JClienteDAO().get(numConta);
				
				try {
					numconta = cc.getNumConta();
					new AlterarContas(agencia, numconta).start(stage);
					atualizarLista();
				} catch (Exception e) {
					try {
						numconta = cp.getNumConta();
						new AlterarContas(agencia, numconta).start(stage);
					} catch (Exception e1) {
						Alertas.alerta("Erro ao alterar conta.");
					}
					atualizarLista();
				}		
			}
		};
	}
	
	private EventHandler<ActionEvent> CadastrarFCliente() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new CadastrarFCliente(agencia).start(stage);
					atualizarLista();
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel adicionar cliente!");
				}		
			}
		};
	}
	
	private EventHandler<ActionEvent> CadastrarJCliente() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new CadastrarJCliente(agencia).start(stage);
					atualizarLista();
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel adicionar cliente!");
				}		
			}
		};
	}
	
	private EventHandler<ActionEvent> AlterarCliente() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (listaClientes.getSelectionModel().isEmpty()) {
					Alertas.alerta("Selecione um cliente para ser alterado.");
					return;
				}
				
				String numConta = listaClientes.getSelectionModel().getSelectedItem();
				FCliente fc = new FClienteDAO().get(numConta);
				JCliente jc = new JClienteDAO().get(numConta);
				
				try {
					new AlterarFCliente(agencia, fc).start(stage);
					atualizarLista();
				} catch (Exception e) {
					try {
						new AlterarJCliente(agencia, jc).start(stage);
					} catch (Exception e1) {
						Alertas.alerta("Erro ao alterar cliente.");
					}
					atualizarLista();
				}		
			}
		};
	}
	
	private EventHandler<ActionEvent> ExcluirCliente() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					if (listaClientes.getSelectionModel().isEmpty()) {
						Alertas.alerta("Selecione um Cliente para ser excluido.");
						return;
					}
					
					try {
						FClienteDAO fcdao = new FClienteDAO();
						FCliente fc = fcdao.get(listaClientes.getSelectionModel().getSelectedItem());
						fcdao.remover(fc);
						atualizarLista();
					} catch (Exception e) {
						JClienteDAO jcdao = new JClienteDAO();
						JCliente jc = jcdao.get(listaClientes.getSelectionModel().getSelectedItem());
						jcdao.remover(jc);
						atualizarLista();
					}
					
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel remover cliente!");
				}		
			}
		};
	}
	
	private void atualizarLista() {
		ObservableList<String> items = FXCollections.observableArrayList(geraListaClientes());
		listaClientes.setItems(items);
	}
	
	private EventHandler<ActionEvent> voltar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new Principal(agencia).start(stage);
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel iniciar o menu principal!");
				};
			}
		};
	}

}
