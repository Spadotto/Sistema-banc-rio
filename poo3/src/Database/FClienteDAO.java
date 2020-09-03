package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClassesFilhas.FCliente;

public class FClienteDAO implements InterfaceDAO<FCliente> {

	public void adicionar(FCliente fcliente) {
		try {
			String sql = "INSERT INTO FCliente VALUES ('" + fcliente.getNumConta() + "','"
					+ fcliente.getNome() + "','"+ fcliente.getCPF() + "','" + fcliente.getEmail() + "','" + fcliente.getTelefonepessoal() + "');";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel inserir o cliente no banco!");
		}
	}

	public void remover(int numConta) {
		try {
			String sql = "DELETE FROM FCliente WHERE numConta = '" + numConta + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel remover o cliente do banco!");
		}

	}

	public List<FCliente> todos() {
		List<FCliente> retorno = new ArrayList<FCliente>();
		try {
			String sql = "SELECT * FROM FCliente";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				int NumConta = resultSet.getInt("numConta");
				String Nome = resultSet.getString("Nome");
				String CPF = resultSet.getString("CPF");
				String Email = resultSet.getString("Email");
				String Telefone = resultSet.getString("Telefone");
				retorno.add(new FCliente(NumConta, Nome, CPF, Email, Telefone));
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			System.out.println("Nao foi possivel consultar todos os clientes do banco!");
		}
		return retorno;
	}

	public FCliente get(int NumConta) {
		FCliente retorno = null;
		try {
			String sql = "SELECT numConta, Nome, Email, CPF, Telefone FROM FCliente WHERE numConta = '" + NumConta + "'";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				int numConta = resultSet.getInt("numConta");
				String Cpf = resultSet.getString("CPF");
				String Nome = resultSet.getString("Nome");
				String Telefone = resultSet.getString("Telefone");
				String Email = resultSet.getString("Email");
				CCorrenteDAO cconta = new CCorrenteDAO();
				System.out.println(cconta.get(numConta));
				CPoupancaDAO pconta = new CPoupancaDAO();
				System.out.println(pconta.get(numConta));
				retorno = new FCliente(numConta, Cpf, Nome, Email, Telefone);
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			System.out.println("Nao foi possivel consultar um cliente do banco!");
		}
		return retorno;
	}
	
	public void atualizar(String mudar, String newdado, int numconta) {
		try {
			String sql = "UPDATE FCliente SET '" + mudar + "' = '" + newdado + "' WHERE numConta = '" + numconta + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel atualizar o cliente do banco!");
		}
	}

}
