package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClassesFilhas.JCliente;

public class JClienteDAO implements InterfaceDAO<JCliente> {

	public void adicionar(JCliente jcliente) {
		try {
			String sql = "INSERT INTO JCliente VALUES ('" + jcliente.getNumConta() + "','"
					+ jcliente.getNome() + "','"+ jcliente.getCnpj() + "','" + jcliente.getEmail() + "','" + jcliente.getNomefantasia() + "','" + jcliente.getTelefoneempresa() + "')";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel inserir o cliente no banco!");
		}
	}

	public void remover(int conta) {
		try {
			String sql = "DELETE FROM JCliente WHERE numConta = '" + conta + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel remover o cliente do banco!");
		}

	}

	public List<JCliente> todos() {
		List<JCliente> retorno = new ArrayList<JCliente>();
		try {
			String sql = "SELECT * FROM JCliente";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				int NumConta = resultSet.getInt("numConta");
				String Nome = resultSet.getString("Nome");
				String Cnpj = resultSet.getString("CNPJ");
				String Email = resultSet.getString("Email");
				String Nomefantasia = resultSet.getString("Nomefantasia");
				String Telefone = resultSet.getString("Telefone");
				retorno.add(new JCliente(NumConta, Cnpj, Nome, Email, Nomefantasia, Telefone));
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			System.out.println("Nao foi possivel consultar todos os clientes do banco!");
		}
		return retorno;
	}

	public JCliente get(int conta) {
		JCliente retorno = null;
		try {
			String sql = "SELECT numConta, Nome, CNPJ, NomeFantasia, Email, Telefone FROM JCliente WHERE numConta = '" + conta + "'";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				int numConta = resultSet.getInt("numConta");
				String CNPJ = resultSet.getString("Cnpj");
				String Nome = resultSet.getString("Nome");
				String Nomefantasia = resultSet.getString("Nomefantasia");
				String Telefone = resultSet.getString("Telefone");
				String Email = resultSet.getString("Email");
				CCorrenteDAO cconta = new CCorrenteDAO();
				System.out.println(cconta.get(numConta));
				CPoupancaDAO pconta = new CPoupancaDAO();
				System.out.println(pconta.get(numConta));
				retorno = new JCliente(numConta, CNPJ, Nome, Nomefantasia, Email, Telefone);
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			System.out.println("Nao foi possivel consultar um cliente do banco!");
		}
		return retorno;
	}
	
	public void atualizar(String mudar, String newdado, int numconta) {
		try {
			String sql = "UPDATE JCliente SET '" + mudar + "' = '" + newdado + "' WHERE numConta = '" + numconta + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel atualizar o cliente do banco!");
		}
	}

}
