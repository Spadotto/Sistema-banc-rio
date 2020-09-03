package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ClassesFilhas.CCorrente;

public class CCorrenteDAO implements InterfaceDAO<CCorrente> {

	public void adicionar(CCorrente ccorrente) {
		try {
			String sql = "INSERT INTO CCorrente VALUES ('" + ccorrente.getNumCorrente() + "','" + ccorrente.getNumConta() + "','" + ccorrente.getSaldo() + "')";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel inserir a conta corrente no banco!");
		}
	}

	public void remover(CCorrente ccorrente) {
		try {
			String sql = "DELETE FROM CCorrente WHERE numConta = '" + ccorrente.getNumConta() + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel remover a conta corrente do banco!");
		}

	}

	public List<CCorrente> todos() {
		List<CCorrente> retorno = new ArrayList<CCorrente>();
		try {
			String sql = "SELECT NumCorrente, Saldo FROM CCorrente;";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				int NumCorrente = resultSet.getInt("NumCorrente");
				double Saldo = resultSet.getDouble("Saldo");
				retorno.add(new CCorrente(NumCorrente, Saldo));
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			System.out.println("Nao foi possivel consultar todas as contas correntes do banco!");
		}
		return retorno;
	}

	public CCorrente get(int NumConta) {
		CCorrente retorno = null;
		try {
			String sql = "SELECT NumCorrente, Saldo FROM CCorrente WHERE numConta = '" + NumConta + "'";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				int numCorrente = resultSet.getInt("NumCorrente");
				double Saldo = resultSet.getDouble("Saldo");
				retorno = new CCorrente(numCorrente, Saldo);
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			System.out.println("Nao foi possivel consultar uma conta corrente do banco!");
		}
		return retorno;
	}
	
	public void atualizar(double newSaldo, int numConta) {
		try {
			String sql = "UPDATE CCorrente SET Saldo = '" + newSaldo + "' WHERE numConta = '" + numConta + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel atualizar a conta corrente do banco!");
		}
	}

}
