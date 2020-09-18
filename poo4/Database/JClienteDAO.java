package poo4.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import poo4.ClassesFilhas.JCliente;
import poo4.IHC.Alertas;

public class JClienteDAO implements InterfaceDAO<JCliente> {

	public void adicionar(JCliente jcliente) {
		try {
			String sql = "INSERT INTO JCliente VALUES ('" + jcliente.getNumConta() + "','"
					+ jcliente.getNome() + "','"+ jcliente.getCnpj() + "','" + jcliente.getEmail() + "','" + jcliente.getNomefantasia() + "','" + jcliente.getTelefoneempresa() + "')";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel inserir o cliente no banco!");
		}
	}

	public void remover(JCliente jc) {
		String numConta = jc.getNumConta();
		try {
			String sql = "DELETE FROM JCliente WHERE numConta = '" + jc.getNumConta() + "'";
			CPoupancaDAO pconta = new CPoupancaDAO();
			pconta.remover(numConta);
			CCorrenteDAO cconta = new CCorrenteDAO();
			cconta.remover(numConta);
			String sql2 = "DELETE FROM Conta WHERE numConta = '" + jc.getNumConta() + "'";
			UtilBD.alterarBD(sql2);
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel remover o cliente do banco!");
		}

	}

	public List<JCliente> todos() {
		List<JCliente> retorno = new ArrayList<JCliente>();
		try {
			String sql = "SELECT * FROM JCliente";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				String NumConta = resultSet.getString("numConta");
				String Nome = resultSet.getString("Nome");
				String Cnpj = resultSet.getString("CNPJ");
				String Email = resultSet.getString("Email");
				String Nomefantasia = resultSet.getString("Nomefantasia");
				String Telefone = resultSet.getString("Telefone");
				retorno.add(new JCliente(NumConta, Cnpj, Nome, Email, Nomefantasia, Telefone));
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel consultar todos os clientes do banco!");
		}
		return retorno;
	}

	public JCliente get(String string) {
		JCliente retorno = null;
		try {
			String sql = "SELECT * FROM JCliente WHERE numConta = '" + string + "'";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				String numConta = resultSet.getString("numConta");
				String CNPJ = resultSet.getString("Cnpj");
				String Nome = resultSet.getString("Nome");
				String Nomefantasia = resultSet.getString("Nomefantasia");
				String Telefone = resultSet.getString("Telefone");
				String Email = resultSet.getString("Email");
				retorno = new JCliente(numConta, CNPJ, Nome, Nomefantasia, Email, Telefone);
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel consultar um cliente do banco!");
		}
		return retorno;
	}
	
	public void atualizar(String mudar, String newdado, String numconta) {
		try {
			String sql = "UPDATE JCliente SET '" + mudar + "' = '" + newdado + "' WHERE numConta = '" + numconta + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			Alertas.erro("Nao foi possivel atualizar o cliente do banco!");
		}
	}

}
