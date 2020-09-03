package Main;


import java.sql.SQLException;
import java.util.Scanner;

import ClassesFilhas.Agencia;
import ClassesFilhas.CCorrente;
import ClassesFilhas.CPoupanca;
import ClassesFilhas.FCliente;
import ClassesFilhas.JCliente;
import Database.AgenciaDAO;
import Database.CCorrenteDAO;
import Database.CPoupancaDAO;
import Database.FClienteDAO;
import Database.JClienteDAO;
import Database.UtilBD;

public class Main {
	
	static Scanner Teclado = new Scanner(System.in);

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		UtilBD.initBD();

		String numAgencia;

		while(true) {
			
			AgenciaDAO agencia = new AgenciaDAO();
			System.out.println("\n\nInforme o numero da agencia: \n");
			numAgencia = Teclado.nextLine();
			if((agencia.verifica(numAgencia)) != true) {
				System.out.println("\nA agencia informada não existe!\n");
				System.out.println("Agencias disponiveis:\n");
				System.out.println(agencia.todos());
			}
			else {
				
				do {
					
					FClienteDAO fcliente = new FClienteDAO();
					JClienteDAO jcliente = new JClienteDAO();
					CCorrenteDAO contac = new CCorrenteDAO();
					CPoupancaDAO contap = new CPoupancaDAO();
					
					System.out.println("+-----------------------------------------------+\n|                                               |");
					System.out.println("|Digite a opção:                                |\n|                                               |");
					System.out.println("|1. Cliente                                     |\n|                                               |");
					System.out.println("|2. Agencia                                     |\n|                                               |");
					System.out.println("|0. Sair                                        |\n|                                               |");
					System.out.println("+-----------------------------------------------+\n                                                 ");
					int opcao = Teclado.nextInt();
					Teclado.nextLine();
				
					if (opcao == 1) {
						
						System.out.println("\n\n\n\n\n\n");
						System.out.println("+-----------------------------------------------+\n|                                               |");
						System.out.println("|1. Cadastrar cliente fisico;                   |\n|                                               |");
						System.out.println("|2. Cadastrar cliente juridico;                 |\n|                                               |");
						System.out.println("|3. Listar clientes;                            |\n|                                               |");
						System.out.println("|4. Buscar cliente;                             |\n|                                               |");
						System.out.println("|5. Excluir dados de cliente;                   |\n|                                               |");
						System.out.println("|6. Editar cliente;                             |\n|                                               |");
						System.out.println("+-----------------------------------------------+\n                                                 ");
						int Menu = Teclado.nextInt();
						
						switch(Menu) {
						
							case 1 :
								cadastrarFCliente(numAgencia);
								System.out.println("\n\n\n\n\n\n");
							break;
							
							case 2 :
								cadastrarJCliente(numAgencia);
								System.out.println("\n\n\n\n\n\n");
							break;
							
							case 3 :
								System.out.println("\n\nClientes Fisicos: ");
								System.out.println(fcliente.todos());
								System.out.println("\n\nClientes Juridicos: ");
								System.out.println(jcliente.todos());
								System.out.println("\n\n\n\n\n\n");
							break;
							
							case 4 :
								while(true) {
									System.out.println("\nDigite 1 para pessoa fisica e 2 para pessoa juridica: ");
									int op = Teclado.nextInt();
									Teclado.nextLine();
									
									if(op == 1) {
										
										System.out.println("Digite o numero da conta do cliente a ser pesquisado: ");
										Scanner a = new Scanner(System.in);
										int numconta = a.nextInt();
										a.nextLine();
										
										System.out.println(fcliente.get(numconta));
										
										break;
										
									}
									if(op == 2) {
										
										System.out.println("Digite o numero da conta do cliente a ser pesquisado: ");
										Scanner b = new Scanner(System.in);
										int conta = b.nextInt();
										b.nextLine();
										
										System.out.println(jcliente.get(conta));
										
										break;
										
									}
									else {
										System.out.println("\n\nInforme um valor válido!\n");
									}
									
								}
								
								System.out.println("\n\n\n\n\n\n");
							break;
							
							case 5 :
								System.out.println("\nDigite 1 para pessoa fisica e 2 para pessoa juridica: ");
								int op = Teclado.nextInt();
								Teclado.nextLine();
								
								if(op == 1) {
									
									System.out.println("Digite o numero da conta do cliente a ser removido: ");
									Scanner a = new Scanner(System.in);
									int conta = a.nextInt();
									a.nextLine();
									
									fcliente.remover(conta);
									
									System.out.println("\nCliente removido com sucesso!\n");
									
								}
								
								if(op == 2) {
									
									System.out.println("Digite o numero da conta do cliente a ser removido: ");
									Scanner a = new Scanner(System.in);
									int conta = a.nextInt();
									a.nextLine();
									
									jcliente.remover(conta);
									
									System.out.println("\nCliente removido com sucesso!\n");
									
								}
								
								System.out.println("\n\n\n\n\n\n");
							break;
							
							case 6:
								
								System.out.println("\nDigite 1 para pessoa fisica e 2 para pessoa juridica: ");
								int op2 = Teclado.nextInt();
								Teclado.nextLine();
								
								if(op2 == 1) {
									System.out.println("+-----------------------------------------------+\n|                                               |");
									System.out.println("|Digite a opção:                                |\n|                                               |");
									System.out.println("|1. Atualizar dados do cliente;                 |\n|                                               |");
									System.out.println("|2. Atualizar saldo conta corrente;             |\n|                                               |");
									System.out.println("|3. Atualizar saldo conta Poupanca;             |\n|                                               |");
									System.out.println("+-----------------------------------------------+\n                                                 ");
									int opcao1 = Teclado.nextInt();
									Teclado.nextLine();
									
									switch(opcao1) {
										
									case 1:
										
										System.out.println("Digite o numero da conta do cliente que deseja alterar: ");
										int conta = Teclado.nextInt();
										Teclado.nextLine();
										
										System.out.println("Digite o campo que sera alterado do cliente: ");
										String mudar = Teclado.nextLine();
										
										System.out.println("Digite o novo valor que sera salvo: ");
										String newdado = Teclado.nextLine();
										
										fcliente.atualizar(mudar, newdado, conta);
										
									break;
									
									case 2:
										System.out.println("Digite o numero da conta do cliente que deseja aterar seu saldo da conta corrente: ");
										int numConta = Teclado.nextInt();
										Teclado.nextLine();
										
										System.out.println("\nInforme o novo saldo: ");
										double newSaldo = Teclado.nextDouble();
										Teclado.nextLine();
										
										contac.atualizar(newSaldo, numConta);
									break;
									
									case 3:
										System.out.println("Digite o numero da conta do cliente que deseja aterar seu saldo da conta poupanca: ");
										int NumConta = Teclado.nextInt();
										Teclado.nextLine();
										
										System.out.println("\nInforme o novo saldo: ");
										double NewSaldo = Teclado.nextDouble();
										Teclado.nextLine();
										
										contap.atualizar(NewSaldo, NumConta);
									break;
									
									}
								}
								if(op2 == 2) {
									System.out.println("+-----------------------------------------------+\n|                                               |");
									System.out.println("|Digite a opção:                                |\n|                                               |");
									System.out.println("|1. Atualizar dados do cliente;                 |\n|                                               |");
									System.out.println("|2. Atualizar saldo conta corrente;             |\n|                                               |");
									System.out.println("|0. Atualizar saldo conta Poupanca;             |\n|                                               |");
									System.out.println("+-----------------------------------------------+\n                                                 ");
									int opcao1 = Teclado.nextInt();
									Teclado.nextLine();
									
									switch(opcao1) {
									
									case 1:
										
										System.out.println("Digite o CNPJ do cliente que deseja alterar: ");
										int conta = Teclado.nextInt();
										Teclado.nextLine();
										
										System.out.println("Digite o campo que sera alterado do cliente: ");
										String mudar = Teclado.nextLine();
										
										System.out.println("Digite o novo valor que sera salvo: ");
										String newdado = Teclado.nextLine();
										
										jcliente.atualizar(mudar, newdado, conta);
										
									break;
									
									case 2:
										System.out.println("Digite o numero da conta do cliente que deseja aterar seu saldo da conta corrente: ");
										int numConta = Teclado.nextInt();
										Teclado.nextLine();
										
										System.out.println("\nInforme o novo saldo: ");
										double newSaldo = Teclado.nextDouble();
										Teclado.nextLine();
										
										contac.atualizar(newSaldo, numConta);
									break;
									
									case 3:
										System.out.println("Digite o numero da conta do cliente que deseja aterar seu saldo da conta poupanca: ");
										int NumConta = Teclado.nextInt();
										Teclado.nextLine();
										
										System.out.println("\nInforme o novo saldo: ");
										double NewSaldo = Teclado.nextDouble();
										Teclado.nextLine();
										
										contap.atualizar(NewSaldo, NumConta);
									break;
									
									}
									
								}
								
							break;
								
						}
						
					}
					
					if (opcao == 2) {
						System.out.println("+-----------------------------------------------+\n|                                               |");
						System.out.println("|1. Listar agencias;                            |\n|                                               |");
						System.out.println("|2. Consultar agencia;                          |\n|                                               |");
						System.out.println("|3. Excluir dados de agencia;                   |\n|                                               |");
						System.out.println("|4. Atualizar dados de agencia;                 |\n|                                               |");
						System.out.println("|5. Adicionar agencia;                          |\n|                                               |");
						System.out.println("+-----------------------------------------------+\n                                                 ");
						int opc = Teclado.nextInt();
						Teclado.nextLine();
						
						if(opc == 1) {
							
							System.out.println(agencia.todos());
							System.out.println("\n\n\n\n\n\n");
							
						}
						
						if(opc == 2) {
							
							System.out.println("Digite o numero da agencia a ser pesquisado: ");
							Scanner c = new Scanner(System.in);
							String NumAgencia = c.nextLine();
							c.nextLine();
							
							System.out.println(agencia.get(NumAgencia));
							
							System.out.println("\n\n\n\n\n\n");
						
						}
						
						if(opc == 3) {
							
							System.out.println("Digite o numero da agencia que deseja excluir: ");
							String nome = Teclado.nextLine();
							
							agencia.remover(nome);
							
							System.out.println("\nAgencia removida com sucesso!\n");
							System.out.println("\n\n\n\n\n\n");
							
						}
				
						if(opc == 4) {
							
							System.out.println("Digite o numero da agencia que deseja alterar: ");
							String num = Teclado.nextLine();
							
							System.out.println("Digite o campo que sera alterado da agencia: ");
							String mudar = Teclado.nextLine();
							
							System.out.println("Digite o novo valor que sera salvo: ");
							String newdado = Teclado.nextLine();
							
							agencia.atualizar(mudar, newdado, num);
							System.out.println("\n\n\n\n\n\n");
							
						}
				
						if(opc == 5) {
					
						addagencia();
						System.out.println("\n\n\n\n\n\n");
					
						}
					
					}
				
					if (opcao == 0) {
						System.out.println("\n\nDeslogando....\n");
						System.exit(0);
					}
			
				} while(true);
				
			}
			
			UtilBD.fecharConexao();
		}
		
		

	}
	
	public static void addagencia(){
		
		AgenciaDAO agencia = new AgenciaDAO();
		
		Teclado.nextLine();
		System.out.println("Digite os dados");

		System.out.println("\nNum agencia: ");
		String NumAgencia = Teclado.nextLine();

		System.out.println("\nCidade: ");
		String Cidade = Teclado.nextLine();

		System.out.println("\nTelefone: ");
		String Telefone = Teclado.nextLine();

		System.out.println("A agencia possui app? [s/n] ");
		String op = Teclado.nextLine();
		
		if (op.equals("s")) {

			System.out.println("\nDigite o link para o app: ");
			String app = Teclado.nextLine();
			
			agencia.adicionar(new Agencia(NumAgencia, Cidade, Telefone, app));
		
		}else {
			
			String app = "nao possui";
			agencia.adicionar(new Agencia(NumAgencia, Cidade, Telefone, app));
			
		}
		
	}
	
	public static void cadastrarJCliente(String numAgencia) {
		
		JClienteDAO jcliente = new JClienteDAO();

		Teclado.nextLine();
		System.out.println("Digite os dados");

		System.out.println("\nNumero da conta: ");
		int numConta = Teclado.nextInt();
		Teclado.nextLine();
		
		try {
			String sql = "INSERT INTO Conta VALUES ('" + numConta + "','" + numAgencia + "');";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel criar a conta no banco!");
		}

		System.out.println("\nQual nome do gerente: ");
		String nome = Teclado.nextLine();

		System.out.println("\nDigite seu CNPJ: ");
		String Cnpj = Teclado.nextLine();
		
		System.out.println("\nQual o nome do estabelecimento: ");
		String nomefantasia = Teclado.nextLine();

		System.out.println("O cliente possui email? [s/n] ");
		String op = Teclado.nextLine();

		if (op.equals("s")) {

			System.out.println("\nDigite seu Email: ");
			String email = Teclado.nextLine();

			System.out.println("O cliente possui telefone? [s/n] ");
			String op2 = Teclado.nextLine();

			if (op2.equals("s")) {

				System.out.println("\nDigite seu Telefone: ");
				String telefonepessoal = Teclado.nextLine();
				Teclado.nextLine();

				jcliente.adicionar(new JCliente(numConta, nome, Cnpj, nomefantasia, email, telefonepessoal));

			} else {

				String telefonepessoal = "nao possui";
				jcliente.adicionar(new JCliente(numConta, nome, Cnpj, nomefantasia, email, telefonepessoal));

			}

		} else {

			System.out.println("O cliente possui telefone? [s/n] ");
			String op3 = Teclado.nextLine();

			if (op3.equals("s")) {

				System.out.println("\nDigite seu Telefone: ");
				String telefonepessoal = Teclado.nextLine();
				Teclado.nextLine();
				String email = "nao possui";

				jcliente.adicionar(new JCliente(numConta, nome, Cnpj, nomefantasia, email, telefonepessoal));

			} else {

				String telefonepessoal = "nao possui";
				String email = "nao possui";
				jcliente.adicionar(new JCliente(numConta, nome, Cnpj, nomefantasia, email, telefonepessoal));

			}

		}

		System.out.println("\n\n1. Criar conta Corrente;\n2. Criar conta Poupança;\n3. Criar os dois tipos de conta;\n");
		int aux = Teclado.nextInt();
		Teclado.nextLine();

		switch (aux) {
			case 1:
				
				criarcontaCorrente(numConta);
	
			break;
	
			case 2:
				
				criarcontaPoupanca(numConta);
	
			break;
	
			case 3:
				
				criarcontaCorrente(numConta);
				criarcontaPoupanca(numConta);
	
			break;

		}

	}
	
	public static void cadastrarFCliente(String numAgencia) {
		
		FClienteDAO fcliente = new FClienteDAO();

		Teclado.nextLine();
		System.out.println("Digite os dados");

		System.out.println("\nNumero da conta: ");
		int numConta = Teclado.nextInt();
		Teclado.nextLine();
		
		try {
			String sql = "INSERT INTO Conta VALUES ('" + numConta + "','" + numAgencia + "');";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			System.out.println("Nao foi possivel criar a conta no banco!");
		}

		System.out.println("\nQual seu nome: ");
		String nome = Teclado.nextLine();

		System.out.println("\nDigite seu CPF: ");
		String CPF = Teclado.nextLine();

		System.out.println("O cliente possui email? [s/n] ");
		String op = Teclado.nextLine();

		if (op.equals("s")) {

			System.out.println("\nDigite seu Email: ");
			String email = Teclado.nextLine();

			System.out.println("O cliente possui telefone? [s/n] ");
			String op2 = Teclado.nextLine();

			if (op2.equals("s")) {

				System.out.println("\nDigite seu Telefone: ");
				String telefonepessoal = Teclado.nextLine();
				Teclado.nextLine();

				fcliente.adicionar(new FCliente(numConta, nome, CPF, email, telefonepessoal));

			} else {
				
				String telefonepessoal = "nao possui";
				fcliente.adicionar(new FCliente(numConta, nome, CPF, email, telefonepessoal));

			}

		} else {

			System.out.println("O cliente possui telefone? [s/n] ");
			String op3 = Teclado.nextLine();

			if (op3.equals("s")) {

				System.out.println("\nDigite seu Telefone: ");
				String telefonepessoal = Teclado.nextLine();
				Teclado.nextLine();
				String email = "nao possui";

				fcliente.adicionar(new FCliente(numConta, nome, CPF, email, telefonepessoal));

			} else {
				
				String telefonepessoal = "nao possui";
				String email = "nao possui";
				fcliente.adicionar(new FCliente(numConta, nome, CPF, email, telefonepessoal));

			}

		}

		System.out.println("\n\n1. Criar conta Corrente;\n2. Criar conta Poupança;\n3. Criar os dois tipos de conta;\n");
		int aux = Teclado.nextInt();
		Teclado.nextLine();

		switch (aux) {
			case 1:
				
				criarcontaCorrente(numConta);
	
			break;
	
			case 2:
				
				criarcontaPoupanca(numConta);
	
			break;
	
			case 3:
				
				criarcontaCorrente(numConta);
				criarcontaPoupanca(numConta);
	
			break;

		}

	}
	
	public static void criarcontaCorrente(int numConta) {
	
		CCorrenteDAO contac = new CCorrenteDAO();

		System.out.println("\nNumero da conta corrente: ");
		int numCorrente = Teclado.nextInt();
		Teclado.nextLine();
		
		System.out.println("\nDeseja adicionar um saldo inicial: [s/n]");
		String aux5 = Teclado.nextLine();
		
		if(aux5.equals("s")) {
			
			System.out.println("\nValor a ser adicionado: ");
			double saldo = Teclado.nextDouble();
				
			contac.adicionar(new CCorrente(numCorrente, numConta, saldo));
			
		}else {
			
			double saldo = 0.0;
			contac.adicionar(new CCorrente(numCorrente, numConta, saldo));	
			
		}
		
	}
	
	public static void criarcontaPoupanca(int numConta) {
		
		CPoupancaDAO contap = new CPoupancaDAO();

		System.out.println("\nNumero da conta poupanca: ");
		int numPoupanca = Teclado.nextInt();
		Teclado.nextLine();
		
		System.out.println("\nDeseja adicionar um saldo inicial: [s/n]");
		String aux5 = Teclado.nextLine();
		
		if(aux5.equals("s")) {
			
			System.out.println("\nValor a ser adicionado: ");
			double saldo = Teclado.nextDouble();
				
			contap.adicionar(new CPoupanca(numPoupanca, numConta, saldo));
			
		}else {
			
			double saldo = 0.0;
			contap.adicionar(new CPoupanca(numPoupanca, numConta, saldo));	
			
		}
		
	}
	
}
