package poo4.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poo4.ClassesFilhas.FCliente;
import poo4.IHC.Alertas;

public class FClienteDAO implements InterfaceDAO<FCliente> {

	public void adicionar(FCliente fcliente) {
		try {
			String sql = "INSERT INTO FCliente VALUES ('" + fcliente.getNumConta() + "','"
					+ fcliente.getNome() + "','"+ fcliente.getCPF() + "','" + fcliente.getEmail() + "','" + fcliente.getTelefonepessoal() + "');";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel inserir o cliente no banco!");
		}
	}

	public void remover(FCliente fc) {
		String numConta = fc.getNumConta();
		try {
			String sql = "DELETE FROM FCliente WHERE numConta = '" + fc.getNumConta() + "'";
			CPoupancaDAO pconta = new CPoupancaDAO();
			pconta.remover(numConta);
			CCorrenteDAO cconta = new CCorrenteDAO();
			cconta.remover(numConta);
			String sql2 = "DELETE FROM Conta WHERE numConta = '" + fc.getNumConta() + "'";
			UtilBD.alterarBD(sql2);
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel remover o cliente do banco!");
		}

	}

	public List<FCliente> todos() {
		List<FCliente> retorno = new ArrayList<FCliente>();
		try {
			String sql = "SELECT * FROM FCliente";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				String NumConta = resultSet.getString("numConta");
				String Nome = resultSet.getString("Nome");
				String CPF = resultSet.getString("CPF");
				String Email = resultSet.getString("Email");
				String Telefone = resultSet.getString("Telefone");
				retorno.add(new FCliente(NumConta, Nome, CPF, Email, Telefone));
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel consultar todos os clientes do banco!");
		}
		return retorno;
	}

	public FCliente get(String string) {
		FCliente retorno = null;
		try {
			String sql = "SELECT numConta, Nome, Email, CPF, Telefone FROM FCliente WHERE numConta = '" + string + "'";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				String numConta = resultSet.getString("numConta");
				String Cpf = resultSet.getString("CPF");
				String Nome = resultSet.getString("Nome");
				String Telefone = resultSet.getString("Telefone");
				String Email = resultSet.getString("Email");
				retorno = new FCliente(numConta, Cpf, Nome, Email, Telefone);
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel consultar um cliente do banco!");
		}
		return retorno;
	}
	
	public void atualizar(String mudar, String newdado, String numconta) {
		try {
			String sql = "UPDATE FCliente SET '" + mudar + "' = '" + newdado + "' WHERE numConta = '" + numconta + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel atualizar o cliente do banco!");
		}
	}

}
