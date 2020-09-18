package poo4.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import poo4.ClassesFilhas.CCorrente;
import poo4.IHC.Alertas;

public class CCorrenteDAO implements InterfaceDAO<CCorrente> {

	public void adicionar(CCorrente ccorrente) {
		try {
			String sql = "INSERT INTO CCorrente VALUES ('" + ccorrente.getNumCorrente() + "','" + ccorrente.getNumConta() + "','" + ccorrente.getSaldo() + "')";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel inserir a conta corrente no banco!");
		}
	}

	public void remover(String numConta) {
		try {
			String sql = "DELETE FROM CCorrente WHERE numConta = '" + numConta + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel remover a conta corrente do banco!");
		}

	}

	public List<CCorrente> todos() {
		List<CCorrente> retorno = new ArrayList<CCorrente>();
		try {
			String sql = "SELECT NumCorrente, Saldo FROM CCorrente;";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				String NumCorrente = resultSet.getString("NumCorrente");
				double Saldo = resultSet.getDouble("Saldo");
				retorno.add(new CCorrente(NumCorrente, Saldo));
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel consultar todas as contas correntes do banco!");
		}
		return retorno;
	}

	public CCorrente get(String numConta) {
		CCorrente retorno = null;
		try {
			String sql = "SELECT NumCorrente, Saldo FROM CCorrente WHERE numConta = '" + numConta + "'";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				String numCorrente = resultSet.getString("NumCorrente");
				double Saldo = resultSet.getDouble("Saldo");
				retorno = new CCorrente(numCorrente, Saldo);
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel consultar uma conta corrente do banco!");
		}
		return retorno;
	}
	
	public void atualizar(String NumCorrente, double Saldo, String NumConta) {
		try {
			String sql = "UPDATE CCorrente SET NumCorrente = '" + NumCorrente + "', Saldo = '" + Saldo + "' WHERE numConta = '" + NumConta + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel atualizar a conta corrente do banco!");
		}
	}

}
