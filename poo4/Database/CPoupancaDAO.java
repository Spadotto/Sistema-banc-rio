package poo4.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import poo4.ClassesFilhas.CPoupanca;
import poo4.IHC.Alertas;

public class CPoupancaDAO implements InterfaceDAO<CPoupanca> {

	public void adicionar(CPoupanca cpoupanca) {
		try {
			String sql = "INSERT INTO CPoupanca VALUES ('" + cpoupanca.getNumPoupanca() + "','" + cpoupanca.getNumConta() + "','"
					+ cpoupanca.getSaldo() + "')";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel inserir a conta poupanca no banco!");
		}
	}

	public void remover(String numConta) {
		try {
			String sql = "DELETE FROM CPoupanca WHERE numConta = '" + numConta + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel remover a conta poupanca do banco!");
		}

	}

	public List<CPoupanca> todos() {
		List<CPoupanca> retorno = new ArrayList<CPoupanca>();
		try {
			String sql = "SELECT NumPoupanca, Saldo FROM CPoupanca";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				String NumPoupanca = resultSet.getString("NumPoupanca");
				double Saldo = resultSet.getDouble("Saldo");
				retorno.add(new CPoupanca(NumPoupanca, Saldo));
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel consultar todas as contas poupancas do banco!");
		}
		return retorno;
	}

	public CPoupanca get(String numConta) {
		CPoupanca retorno = null;
		try {
			String sql = "SELECT NumPoupanca, Saldo FROM CPoupanca WHERE numConta = '" + numConta + "'";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				String numPoupanca = resultSet.getString("NumPoupanca");
				double Saldo = resultSet.getDouble("Saldo");				
				retorno = new CPoupanca(numPoupanca, Saldo);
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel consultar uma conta poupanca do banco!");
		}
		return retorno;
	}
	
	public void atualizar(String NumPoupanca, double Saldo, String NumConta) {
		try {
			String sql = "UPDATE CPoupanca SET NumPoupanca = '" + NumPoupanca + "', Saldo = '" + Saldo + "' WHERE numConta = '" + NumConta + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel atualizar a conta poupanca do banco!");
		}
	}

}
