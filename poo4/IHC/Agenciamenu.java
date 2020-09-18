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
import poo4.ClassesFilhas.Agencia;
import poo4.Database.AgenciaDAO;

public class Agenciamenu extends Application {
	
	private Button btnAlterar;
	private Button btnExcluir;
	private Button btnVisualizar;
	private String agencia;
	private Stage stage;
	private Pane pane;
	private Button btnVoltar;
	private ListView<String> lista;
	
	public Agenciamenu(String agencia) {
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
		stage.setTitle("Menu do Cliente");
		stage.setResizable(false);
		stage.show();
		
	}
	
	private void initComponentes() {		
		lista = new ListView<String>();
		ObservableList<String> items = FXCollections.observableArrayList(geraLista());
		lista.setItems(items);
		
		btnAlterar = new Button("Alterar Agencia");
		btnAlterar.setOnAction(Alterar());
		
		btnVisualizar = new Button("Visualizar Dados");
		btnVisualizar.setOnAction(Visualizar());

		btnExcluir = new Button("Excluir Agencia");
		btnExcluir.setOnAction(Excluir());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(lista, btnExcluir, btnAlterar, btnVisualizar, btnVoltar);

	}
	
	private void configLayout() {
		pane.setPrefSize(470, 480);
		
		lista.setLayoutX(10);
		lista.setLayoutY(10);
		lista.setPrefHeight(pane.getPrefHeight() - 55);
		lista.setPrefWidth(pane.getPrefWidth() - 20);

		btnExcluir.setLayoutX(pane.getPrefWidth() - 460);
		btnExcluir.setLayoutY(pane.getPrefHeight() - 35);
		btnExcluir.setPrefHeight(20);
		btnExcluir.setPrefWidth(100);
		
		btnAlterar.setLayoutX(pane.getPrefWidth() - 360);
		btnAlterar.setLayoutY(pane.getPrefHeight() - 35);
		btnAlterar.setPrefHeight(20);
		btnAlterar.setPrefWidth(100);
		
		btnVisualizar.setLayoutX(pane.getPrefWidth() - 260);
		btnVisualizar.setLayoutY(pane.getPrefHeight() - 35);
		btnVisualizar.setPrefHeight(20);
		btnVisualizar.setPrefWidth(100);

		btnVoltar.setLayoutX(pane.getPrefWidth() - 160);
		btnVoltar.setLayoutY(pane.getPrefHeight() - 35);
		btnVoltar.setPrefHeight(20);
		btnVoltar.setPrefWidth(100);
		
	}
	
	private List<String> geraLista() {
		List<String> retorno = new ArrayList<String>();
		List<Agencia> ag = new AgenciaDAO().todos();
		for (Agencia agencia : ag)
			retorno.add(agencia.getNumAgencia());
		return retorno;
	}
	
	private EventHandler<ActionEvent> Visualizar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (lista.getSelectionModel().isEmpty()) {
					Alertas.alerta("Selecione um cliente para ser visualizado.");
					return;
				}
				
				String NumAgencia = lista.getSelectionModel().getSelectedItem();
				Agencia ag = new AgenciaDAO().get(NumAgencia);
				
				try {
					new Visualizar(ag).start(stage);
				} catch (Exception e) {
					Alertas.alerta("Erro ao visualizar agencia.");
				}
			}
		};
	}
	
	private EventHandler<ActionEvent> Alterar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (lista.getSelectionModel().isEmpty()) {
					Alertas.alerta("Selecione uma agencia para ser alterada.");
					return;
				}
				
				String NumAgencia = lista.getSelectionModel().getSelectedItem();
				Agencia ag = new AgenciaDAO().get(NumAgencia);
				
				try {
					new Alterar(agencia, ag).start(stage);
					ag.setNumAgencia(NumAgencia);
					atualizarLista();
				} catch (Exception e) {
					Alertas.alerta("Erro ao alterar contas.");
				}		
			}
		};
	}
	
	private EventHandler<ActionEvent> Excluir() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					if (lista.getSelectionModel().isEmpty()) {
						Alertas.alerta("Selecione uma agencia para ser excluida.");
						return;
					}
					
					AgenciaDAO agdao = new AgenciaDAO();
					Agencia ag = agdao.get(lista.getSelectionModel().getSelectedItem());
					agdao.remover(ag.getNumAgencia());
					atualizarLista();
					
				} catch (Exception e) {
					Alertas.erro("Nao foi possivel remover agencia!");
				}		
			}
		};
	}
	
	private void atualizarLista() {
		ObservableList<String> items = FXCollections.observableArrayList(geraLista());
		lista.setItems(items);
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

