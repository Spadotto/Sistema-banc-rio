package poo4.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import poo4.ClassesFilhas.Agencia;

public class AgenciaDAO implements InterfaceDAO<Agencia> {

	public void adicionar(Agencia agencia) {
		try {
			String sql = "INSERT INTO Agencia VALUES ('" + agencia.getNumAgencia() + "','"
					+ agencia.getCidade() + "','"+ agencia.getTelefone() + "','" + agencia.getApp() + "');";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel inserir a agencia no banco!");
		}
	}

	public void remover(String NumAgencia) {
		try {
			String sql = "DELETE FROM Agencia WHERE NumAgencia = '" + NumAgencia + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel remover a agencia do banco!");
		}

	}

	public List<Agencia> todos() {
		List<Agencia> retorno = new ArrayList<Agencia>();
		try {
			String sql = "SELECT NumAgencia, Cidade, Telefone, App FROM Agencia";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				String NumAgencia = resultSet.getString("NumAgencia");
				String Cidade = resultSet.getString("Cidade");
				String Telefone = resultSet.getString("Telefone");
				String App = resultSet.getString("App");
				retorno.add(new Agencia(NumAgencia, Cidade, Telefone, App));
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			System.out.println("Nao foi possivel consultar todas as agencias do banco!");
		}
		return retorno;
	}

	public Agencia get(String NumAgencia) {
		Agencia retorno = null;
		try {
			String sql = "SELECT NumAgencia, Cidade, Telefone, App FROM Agencia WHERE NumAgencia = '" + NumAgencia + "'";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				String numAgencia = resultSet.getString("NumAgencia");
				String Cidade = resultSet.getString("Cidade");
				String Telefone = resultSet.getString("Telefone");
				String App = resultSet.getString("App");
				retorno = new Agencia(numAgencia, Cidade, Telefone, App);
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			System.out.println("Nao foi possivel consultar uma agencia do banco!");
		}
		return retorno;
	}
	
	public boolean verifica(String NumAgencia) {
		boolean retorno = false;
		try {
			String sql = "SELECT NumAgencia FROM Agencia WHERE NumAgencia = '" + NumAgencia + "'";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				retorno = true;
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			System.out.println("Nao foi possivel consultar uma agencia do banco!");
		}
		return retorno;
	}
	
	public void atualizar(String mudar, String newdado, String numAgencia) {
		try {
			String sql = "UPDATE Agencia SET '" + mudar + "' = '" + newdado + "' WHERE NumAgencia = '" + numAgencia + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel atualizar o cliente do banco!");
		}
	}

}
