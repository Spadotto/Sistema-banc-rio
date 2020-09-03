package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilBD {
	private static Connection conexao;

	public static Connection getConexao() {
		try {

			if (conexao == null)
				abrirConexao();

			if (conexao.isClosed())
				abrirConexao();

		} catch (SQLException e) {
			System.out.println("Nao consegui abrir a conexao com o banco!");
		}

		return conexao;
	}

	private static void abrirConexao() {
		try {
			Class.forName("org.sqlite.JDBC");
			conexao = DriverManager.getConnection("jdbc:sqlite:banco.sqlite");
			
		} catch (SQLException e) {
			System.out.println("Nao consegui abrir a conexao com o banco!");
		} catch (ClassNotFoundException e2) {
			System.out.println("A biblioteca do SQLite nao esta funcionando corretamente!");
		}
	}

	public static void fecharConexao() {
		if (conexao == null)
			return;

		try {
			if (!conexao.isClosed())
				conexao.close();
		} catch (SQLException e) {
			System.out.println("Nao consegui fechar a conexao com o banco!");
		}
	}

	public static void initBD() {
		try {
			conexao = getConexao();
			Statement stm = conexao.createStatement();
			criarAgencia(stm);
			criarConta(stm);
			criarCPoupanca(stm);
			criarCCorrente(stm);
			criarFCliente(stm);
			criarJCliente(stm);
			stm.executeUpdate("PRAGMA foreign_keys = ON;");
			stm.close();
		} catch (SQLException e) {
			System.out.println("Nao consegui criar o banco!");
		}
	}

	private static void criarAgencia(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS Agencia;");
		stm.executeUpdate("CREATE TABLE Agencia (" + 
				"	NumAgencia varchar(5) NOT NULL PRIMARY KEY, " + 
				"    Cidade varchar(50) NOT NULL, " + 
				"    Telefone varchar(50) NOT NULL, " + 
				"    App varchar(100));");
		stm.executeUpdate("INSERT INTO Agencia VALUES ('478-9', 'Sunset Valley', '99969696', 'app: download/landgrab.com');");
		stm.executeUpdate("INSERT INTO Agencia VALUES ('557-4', 'Riverview', '66051247', 'nao possui');");
		stm.executeUpdate("INSERT INTO Agencia VALUES ('666-6', 'Bridgport', '88630029', 'nao possui');");
		stm.executeUpdate("INSERT INTO Agencia VALUES ('891-3', 'Twinbrook', '99968722', 'app: download/brookapp.com');");
		stm.executeUpdate("INSERT INTO Agencia VALUES ('263-2', 'Apaloosa Plains', '36005548', 'nao possui');");
	}
	
	private static void criarConta(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS Conta;");
		stm.executeUpdate("CREATE TABLE Conta (" + 
				"	numConta int NOT NULL unique PRIMARY KEY, " + 
				"   numAgencia varchar(5), " +
				"	foreign key (numAgencia) references Agencia(numAgencia));");
		stm.executeUpdate("INSERT INTO Conta VALUES ('89460', '478-9');");
		stm.executeUpdate("INSERT INTO Conta VALUES ('25107', '263-2');");
		stm.executeUpdate("INSERT INTO Conta VALUES ('74062', '478-9');");
	}
	
	private static void criarCCorrente(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS CCorrente");
		stm.executeUpdate("CREATE TABLE CCorrente (" + 
				"	NumCorrente int NOT NULL unique primary KEY, " + 
				"	numConta int NOT NULL, " + 
				"	Saldo double, " +  
				"	foreign key (numConta) references Conta(numConta) on delete cascade);");
		stm.executeUpdate("INSERT INTO CCorrente VALUES ('68927', '89460', '1250.00')");
		stm.executeUpdate("INSERT INTO CCorrente VALUES ('90653', '25107', '5000.00')");
		stm.executeUpdate("INSERT INTO CCorrente VALUES ('38170', '74062', '36000.00')");
	}

	private static void criarCPoupanca(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS CPoupanca");
		stm.executeUpdate("CREATE TABLE CPoupanca (" + 
				"	NumPoupanca int NOT NULL unique primary KEY, " + 
				"	numConta int NOT NULL, " + 
				"	Saldo double, " +  
				"	foreign key (numConta) references Conta(numConta) on delete cascade);");
		stm.executeUpdate("INSERT INTO CPoupanca VALUES ('2164', '25107', '500.00')");
	}

	private static void criarFCliente(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS FCliente");
		stm.executeUpdate("CREATE TABLE FCliente (" + 
				"	numConta int NOT NULL unique, " + 
				"    Nome varchar(100) NOT NULL , " + 
				"    CPF varchar(12) NOT NULL unique PRIMARY KEY, " + 
				"    Email varchar(100), " + 
				"    Telefone varchar(14), " + 
				"    foreign key (numConta) references Conta(numConta) on delete cascade);");
		stm.executeUpdate("INSERT INTO FCliente VALUES ('89460', 'Margarida Aruda', '365296888-63', 'margarida@hotmail.com', null)");
		stm.executeUpdate("INSERT INTO FCliente VALUES ('25107', 'Florentino Flor', '999641287-88', 'florentino666@gmail.com', '(99)99999-9999')");
	}

	private static void criarJCliente(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS JCliente");
		stm.executeUpdate("CREATE TABLE JCliente (" + 
				"	numConta int NOT NULL unique, " + 
				"    Nome varchar(100) NOT NULL, " + 
				"    CNPJ varchar(15) NOT NULL unique PRIMARY KEY, " + 
				"    Email varchar(50), " + 
				"    NomeFantasia varchar(50), " + 
				"    Telefone varchar(14), " + 
				"    foreign key (numConta) references Conta(numConta) on delete cascade);");
		stm.executeUpdate("INSERT INTO JCliente VALUES ('74062', 'Abgail Dolores', '999641287751-88', 'DoloresDores@gmail.com', 'Dolores sem Dores', '(88)88888-8888')");
	}

	public static void alterarBD(String sql) throws SQLException {
		Connection bd = UtilBD.getConexao();
		Statement stm = bd.createStatement();
		stm.executeUpdate(sql);
		stm.close();
	}

	public static ResultSet consultarBD(String sql) throws SQLException {
		Connection bd = UtilBD.getConexao();
		Statement stm = bd.createStatement();
		ResultSet retorno = stm.executeQuery(sql);
		return retorno;
	}
}
