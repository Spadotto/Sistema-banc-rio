package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import ClassesFilhas.Agencia;
import ClassesFilhas.CCorrente;
import ClassesFilhas.CPoupanca;
import ClassesFilhas.FCliente;
import ClassesFilhas.JCliente;
import ClassesMaes.Conta;
import ClassesMaes.Pessoa;

public class Main {

	private static ArrayList<Pessoa> pfisica = new ArrayList<Pessoa>();
	private static ArrayList<Pessoa> pjuridica = new ArrayList<Pessoa>();
	private static ArrayList<Agencia> agencia = new ArrayList<Agencia>();
	private static ArrayList<Conta> contac = new ArrayList<Conta>();
	private static ArrayList<Conta> contap = new ArrayList<Conta>();
	private static ArrayList<Conta> pjcontac = new ArrayList<Conta>();
	private static ArrayList<Conta> pjcontap = new ArrayList<Conta>();

	static Scanner Teclado = new Scanner(System.in);

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		agencia.add(new Agencia("478-9", "Sunset Valley", "99969696", "app: download/landgrab.com"));
		agencia.add(new Agencia("557-4", "Riverview", "66051247"));
		agencia.add(new Agencia("666-6", "Bridgport", "88630029"));
		agencia.add(new Agencia("891-3", "Twinbrook", "99968722", "app: download/brookapp.com"));
		agencia.add(new Agencia("263-2", "Apaloosa Plains", "36005548"));

		do {
			
			System.out.println("\n______________________________________________\n");
			System.out.println("Digite a opção: \n");
			System.out.println("1. Cliente\n");
			System.out.println("2. Agencia\n");
			System.out.println("0. Sair\n");
			System.out.println("\n______________________________________________\n");
			int opcao = Teclado.nextInt();
			Teclado.nextLine();
		
			if (opcao == 1) {
				
				System.out.println("\n\n\n\n\n\n");
				System.out.println("\n______________________________________________\n");
				System.out.println("\n1. Cadastrar cliente fisico;");
				System.out.println("\n2. Cadastrar cliente juridico;");
				System.out.println("\n3. Listar clientes;");
				System.out.println("\n4. Buscar cliente;");
				System.out.println("\n5. Excluir dados de cliente;");
				System.out.println("\n6. Editar cliente;");
				System.out.println("\n______________________________________________\n");
				int Menu = Teclado.nextInt();
				
				switch(Menu) {
				
					case 1 :
						cadastrarFCliente();
						System.out.println("\n\n\n\n\n\n");
					break;
					
					case 2 :
						cadastrarJCliente();
						System.out.println("\n\n\n\n\n\n");
					break;
					
					case 3 :
						listarClientes();
						System.out.println("\n\n\n\n\n\n");
					break;
					
					case 4 :
						while(true) {
							System.out.println("\nDigite 1 para pessoa fisica e 2 para pessoa juridica: ");
							int op = Teclado.nextInt();
							Teclado.nextLine();
							
							if(op == 1) {
								
								System.out.println("Digite o nome do contato a ser pesquisado: ");
								@SuppressWarnings("resource")
								Scanner a = new Scanner(System.in);
								String qwe = a.nextLine();
								a.nextLine();
								
								buscarFCliente(pfisica, qwe);
								
								break;
								
							}
							if(op == 2) {
								
								System.out.println("Digite o nome do cliente a ser pesquisado: ");
								@SuppressWarnings("resource")
								Scanner b = new Scanner(System.in);
								String ewq = b.nextLine();
								b.nextLine();
								
								buscarJCliente(pjuridica, ewq);
								
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
						
						Iterator<Pessoa> j = pjuridica.iterator();
						Iterator<Pessoa> f = pfisica.iterator();
						Iterator<Conta> cc = contac.iterator();
						Iterator<Conta> cp = contap.iterator();
						Iterator<Conta> jcc = pjcontac.iterator();
						Iterator<Conta> jcp = pjcontap.iterator();
						
						if(op == 1) {
							
							System.out.println("Digite o nome do cliente que deseja excluir: ");
							String nome = Teclado.nextLine();
							
							while (f.hasNext() && cc.hasNext() && cp.hasNext()) {
								Pessoa nome2 = f.next();
								Conta nome3 = cc.next();
								Conta nome4 = cp.next();
								
								if (nome.equals(nome2.getNome())) {
											
									f.remove();
									cc.remove();
									cp.remove();
									break;
					        	   
								}	
					          
							}
							
							System.out.println("\nCliente removido com sucesso!\n");
							
						}
						
						if(op == 2) {
							
							System.out.println("Digite o nome do cliente que deseja excluir: ");
							String nome = Teclado.nextLine();
							
							while (j.hasNext() && jcc.hasNext() && jcp.hasNext()) {
								Pessoa nome2 = j.next();
								Conta nome3 = jcc.next();
								Conta nome4 = jcp.next();
								
								if (nome.equals(nome2.getNome())) {
											
									j.remove();
									jcc.remove();
									jcp.remove();
									break;
					        	   
								}	
					          
							}
							
							System.out.println("\nCliente removido com sucesso!\n");
							
						}
						
						System.out.println("\n\n\n\n\n\n");
					break;
					
					case 6:
						
						System.out.println("\nDigite 1 para pessoa fisica e 2 para pessoa juridica: ");
						int op2 = Teclado.nextInt();
						Teclado.nextLine();
						
						if(op2 == 1) {
							System.out.println("\n______________________________________________\n");
							System.out.println("Digite a opção: \n");
							System.out.println("1. Atualizar todos os dados do cliente;\n");
							System.out.println("2. Atualizar conta corrente;\n");
							System.out.println("3. Atualizar conta Poupanca;\n");
							System.out.println("\n______________________________________________\n");
							int opcao1 = Teclado.nextInt();
							Teclado.nextLine();
							
							switch(opcao1) {
								
							case 1:
								Iterator<Pessoa> pf = pfisica.iterator();
								Iterator<Conta> pfcc = contac.iterator();
								Iterator<Conta> pfcp = contap.iterator();
								
								System.out.println("Digite o nome do cliente que deseja alterar: ");
								String nome = Teclado.nextLine();
								
								while (pf.hasNext() && pfcc.hasNext() && pfcp.hasNext()) {
									Pessoa nome2 = pf.next();
									Conta nome3 = pfcc.next();
									Conta nome4 = pfcp.next();
									
									if (nome.equals(nome2.getNome())) {
												
										pf.remove();
										pfcc.remove();
										pfcp.remove();
										break;
						        	   
									}	
						          
								}
								
								cadastrarFCliente();
							break;
							
							case 2:
								System.out.println("Digite o nome do cliente que deseja criar uma conta corrente: ");
								String nome1 = Teclado.nextLine();
								
								pfeditarcontaCorrente(nome1);
							break;
							
							case 3:
								System.out.println("Digite o nome do cliente que deseja criar uma conta poupança: ");
								String nome2 = Teclado.nextLine();
								
								pfeditarcontaPoupanca(nome2);
							break;
							
							}
						}
						if(op2 == 2) {
							System.out.println("\n______________________________________________\n");
							System.out.println("Digite a opção: \n");
							System.out.println("1. Atualizar todos os dados do cliente;\n");
							System.out.println("2. Atualizar conta corrente;\n");
							System.out.println("0. Atualizar conta Poupanca;\n");
							System.out.println("\n______________________________________________\n");
							int opcao1 = Teclado.nextInt();
							Teclado.nextLine();
							
							switch(opcao1) {
								
							case 1:
								Iterator<Pessoa> pj = pjuridica.iterator();
								Iterator<Conta> pjcc = pjcontac.iterator();
								Iterator<Conta> pjcp = pjcontap.iterator();
								
								System.out.println("Digite o nome do cliente que deseja alterar: ");
								String nome = Teclado.nextLine();
								
								while (pj.hasNext() && pjcc.hasNext() && pjcp.hasNext()) {
									Pessoa nome2 = pj.next();
									Conta nome3 = pjcc.next();
									Conta nome4 = pjcp.next();
									
									if (nome.equals(nome2.getNome())) {
												
										pj.remove();
										pjcc.remove();
										pjcp.remove();
										break;
						        	   
									}	
						          
								}
								
								cadastrarJCliente();
							break;
							
							case 2:
								System.out.println("Digite o nome do cliente que deseja criar uma conta corrente: ");
								String nome1 = Teclado.nextLine();
								
								pjeditarcontaCorrente(nome1);
							break;
							
							case 3:
								System.out.println("Digite o nome do cliente que deseja criar uma conta poupança: ");
								String nome2 = Teclado.nextLine();
								
								pjeditarcontaPoupanca(nome2);
							break;
							
							}
							
						}
						
					break;
						
				}
				
			}
			
			if (opcao == 2) {
				System.out.println("\n______________________________________________\n");
				System.out.println("\n1. Listar agencias;");
				System.out.println("\n2. Consultar agencia;");
				System.out.println("\n3. Excluir dados de agencia;");
				System.out.println("\n4. Atualizar dados de agencia;");
				System.out.println("\n5. Adicionar agencia;");
				System.out.println("\n______________________________________________\n");
				int opc = Teclado.nextInt();
				Teclado.nextLine();
				
				if(opc == 1) {
					
					listarAgencias();
					System.out.println("\n\n\n\n\n\n");
					
				}
				
				if(opc == 2) {
					
					System.out.println("Digite o numero da agencia a ser pesquisado: ");
					@SuppressWarnings("resource")
					Scanner c = new Scanner(System.in);
					String qew = c.nextLine();
					c.nextLine();
					
					Agencia buscarAgencia =  buscarAgencia(agencia, qew);
					
					if(buscarAgencia != null) {
						System.out.println(buscarAgencia.toString());

					}
					System.out.println("\n\n\n\n\n\n");
				
				}
				
				if(opc == 3) {
					
					Iterator<Agencia> a = agencia.iterator();
					
					System.out.println("Digite o numero da agencia que deseja excluir: ");
					String nome = Teclado.nextLine();
					
					while (a.hasNext()) {
						Agencia nome2 = a.next();
						
						if (nome.equals(nome2.getNumAgencia())) {
									
							a.remove();
							break;
			        	   
						}	
			          
					}
					
					System.out.println("\nAgencia removida com sucesso!\n");
					System.out.println("\n\n\n\n\n\n");
					
				}
				
				if(opc == 4) {
					
					Iterator<Agencia> a = agencia.iterator();
					
					System.out.println("Digite o numero da agencia que deseja alterar: ");
					String num = Teclado.nextLine();
					
					while (a.hasNext()) {
						Agencia nome2 = a.next();
						
						if (num.equals(nome2.getNumAgencia())) {
									
							a.remove();
							break;
			        	   
						}	
			          
					}
					
					addagencia();
					
				}
				
				if(opc == 5) {
					
					addagencia();
					
				}
					
			}
				
			if (opcao == 0) {
				System.out.println("\n\nDeslogando....\n");
				System.exit(0);
			}
			
		} while(true);
	
	}
	
	public static void addagencia(){
		
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
			
			agencia.add(new Agencia(NumAgencia, Cidade, Telefone, app));
		
		}else {
			
			agencia.add(new Agencia(NumAgencia, Cidade, Telefone));
			
		}
		
	}

	public static void cadastrarFCliente() {

		Teclado.nextLine();
		System.out.println("Digite os dados");

		System.out.println("\nID: ");
		int ID = Teclado.nextInt();
		Teclado.nextLine();

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
				int telefonepessoal = Teclado.nextInt();
				Teclado.nextLine();

				pfisica.add(new FCliente(ID, nome, email, CPF, telefonepessoal));

			} else {

				pfisica.add(new FCliente(ID, nome, email, CPF));

			}

		} else {

			System.out.println("O cliente possui telefone? [s/n] ");
			String op3 = Teclado.nextLine();

			if (op3.equals("s")) {

				System.out.println("\nDigite seu Telefone: ");
				int telefonepessoal = Teclado.nextInt();
				Teclado.nextLine();

				pfisica.add(new FCliente(ID, nome, CPF, telefonepessoal));

			} else {

				pfisica.add(new FCliente(ID, nome, CPF));

			}

		}

		System.out.println("\n\n1. Criar conta Corrente;\n2. Criar conta Poupança;\n3. Criar os dois tipos de conta;\n");
		int aux = Teclado.nextInt();
		Teclado.nextLine();

		switch (aux) {
			case 1:
				
				criarcontaCorrente();
				contap.add(new CPoupanca("não possui"));
	
			break;
	
			case 2:
				
				criarcontaPoupanca();
				contac.add(new CCorrente("não possui"));
	
			break;
	
			case 3:
				
				criarcontaCorrente();
				criarcontaPoupanca();
	
			break;

		}

	}

	public static void cadastrarJCliente() {

		Teclado.nextLine();
		System.out.println("Digite os dados");

		System.out.println("\nID: ");
		int ID = Teclado.nextInt();
		Teclado.nextLine();

		System.out.println("\nNome empresa: ");
		String nomefantasia = Teclado.nextLine();

		System.out.println("\nGerente: ");
		String nome = Teclado.nextLine();

		System.out.println("\nDigite seu CNPJ: ");
		String cnpj = Teclado.nextLine();

		System.out.println("O cliente possui email? [s/n] ");
		String op = Teclado.nextLine();

		if (op.equals("s")) {

			System.out.println("\nDigite seu Email: ");
			String email = Teclado.nextLine();

			System.out.println("O cliente possui telefone? [s/n] ");
			String op2 = Teclado.nextLine();

			if (op2.equals("s")) {

				System.out.println("\nDigite seu Telefone: ");
				int telefoneempresa = Teclado.nextInt();
				Teclado.nextLine();

				pjuridica.add(new JCliente(ID, nome, email, cnpj, nomefantasia, telefoneempresa));

			} else {

				pjuridica.add(new JCliente(ID, nome, email, cnpj, nomefantasia));

			}

		} else {

			System.out.println("O cliente possui telefone? [s/n] ");
			String op3 = Teclado.nextLine();

			if (op3.equals("s")) {

				System.out.println("\nDigite seu Telefone: ");
				int telefoneempresa = Teclado.nextInt();
				Teclado.nextLine();

				pjuridica.add(new JCliente(ID, nome, cnpj, nomefantasia, telefoneempresa));

			} else {

				pjuridica.add(new JCliente(ID, nome, cnpj, nomefantasia));

			}

		}
		
		System.out.println("\n\n1. Criar conta Corrente;\n2. Criar conta Poupança;\n3. Criar os dois tipos de conta;\n");
		int aux = Teclado.nextInt();
		Teclado.nextLine();

		switch (aux) {
			case 1:
				
				pjcriarcontaCorrente();
				pjcontap.add(new CPoupanca("não possui"));
	
			break;
	
			case 2:
				
				pjcriarcontaPoupanca();
				pjcontac.add(new CCorrente("não possui"));
	
			break;
	
			case 3:
				
				pjcriarcontaCorrente();
				pjcriarcontaPoupanca();
	
			break;

		}

	}

	public static void listarClientes() {

		System.out.println("\n\nClientes Físicos: \n");

		for(int i=0; i<pfisica.size(); i++) {
			
			System.out.println(pfisica.get(i).toString());
			
		}

		System.out.println("\n\nClientes Jurídicos: \n");

		for(int i=0; i<pjuridica.size(); i++) {
			
			System.out.println(pjuridica.get(i).toString());
			
		}
		
	}

	public static void criarcontaCorrente() {
		
		String numAgencia;

		while(true) {
			
			System.out.println("\n\nInforme o numero da agencia: \n");
			numAgencia = Teclado.nextLine();
			boolean v = verificaragencia(agencia, numAgencia);
			if(v != true) {
				System.out.println("\nA agencia informada não existe!\n");
				System.out.println("Agencias disponiveis:\n");
				listarAgencias();
			}
			else {
				break;
			}
			
		}

		System.out.println("\nNome do titular da conta: ");
		String titular = Teclado.nextLine();
		
		System.out.println("\nDeseja adicionar um saldo inicial: [s/n]");
		String aux5 = Teclado.nextLine();
		
		if(aux5.equals("s")) {
			
			System.out.println("\nValor a ser adicionado: ");
			double saldo = Teclado.nextDouble();
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux6 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux6.equals("s")) {
				
				contac.add(new CCorrente(1, numAgencia, saldo, titular, true));
				
			}else {
				
				contac.add(new CCorrente(1, numAgencia, saldo, titular));
				
			}
			
		}else {
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux7 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux7.equals("s")) {
				
				contac.add(new CCorrente(1, numAgencia, titular, true));
				
			}else {
				
				contac.add(new CCorrente(1, numAgencia, titular));
				
			}
			
		}
		
	}
	
	public static void criarcontaPoupanca() {

		String numAgencia;

		while(true) {
			
			System.out.println("\n\nInforme o numero da agencia: \n");
			numAgencia = Teclado.nextLine();
			boolean v = verificaragencia(agencia, numAgencia);
			if(v != true) {
				System.out.println("\nA agencia informada não existe!\n");
				System.out.println("Agencias disponiveis:\n");
				listarAgencias();
			}
			else {
				break;
			}
			
		}

		System.out.println("\nNome do titular da conta: ");
		String titular = Teclado.nextLine();
		
		System.out.println("\nDeseja adicionar um saldo inicial: [s/n]");
		String aux10 = Teclado.nextLine();
		
		if(aux10.equals("s")) {
			
			System.out.println("\nValor a ser adicionado: ");
			double saldo = Teclado.nextDouble();
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux9 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux9.equals("s")) {
				
				contap.add(new CPoupanca(1, numAgencia, saldo, titular, true));
				
			}else {
				
				contap.add(new CPoupanca(1, numAgencia, saldo, titular));
				
			}
			
		}else {
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux8 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux8.equals("s")) {
				
				contap.add(new CPoupanca(1, numAgencia, titular, true));
				
			}else {
				
				contap.add(new CPoupanca(1, numAgencia, titular));
				
			}
			
		}
		
	}
	
	public static void buscarJCliente(ArrayList<Pessoa> pjuridica, String Nome) {
				
		boolean achou = false;
		
		for(int i=0; i<pjuridica.size(); i++) {

			if (pjuridica.get(i).getNome().equals(Nome)) {
						
				System.out.println(pjuridica.get(i).toString());
				System.out.println(pjcontac.get(i).toString());
				System.out.println(pjcontap.get(i).toString());
				achou = true;
				
			}

		}
		if(!achou) {
				System.out.println("\nCliente não encontrado!\n");
		}

	}
		
	public static void buscarFCliente(ArrayList<Pessoa> pfisica, String Nome) {
		
		boolean achou = false;
				
		for(int i=0; i<pfisica.size(); i++) {

			if (pfisica.get(i).getNome().equals(Nome)) {
						
				System.out.println(pfisica.get(i).toString());
				System.out.println(contac.get(i).toString());
				System.out.println(contap.get(i).toString());
				achou = true;
						
			}

		} 
		if(!achou) {
			System.out.println("\nCliente não encontrado!\n");
		}

	}


	public static void listarAgencias() {

		System.out.println("\nAgencias cadastradas: \n\n");

		for (Agencia tS : agencia) {

			System.out.println(tS.toString());

		}

	}

	public static Agencia buscarAgencia(ArrayList<Agencia> agencia, String NumAgencia) {

		for (Agencia agen : agencia) {
			if (agen.getNumAgencia().equals(NumAgencia)) {

				return agen;

			}

		}

		return null;

	}

	public static void pjcriarcontaCorrente() {
		
		String numAgencia;

		while(true) {
			
			System.out.println("\n\nInforme o numero da agencia: \n");
			numAgencia = Teclado.nextLine();
			boolean v = verificaragencia(agencia, numAgencia);
			if(v != true) {
				System.out.println("\nA agencia informada não existe!\n");
				System.out.println("Agencias disponiveis:\n");
				listarAgencias();
			}
			else {
				break;
			}
			
		}

		System.out.println("\nNome do titular da conta: ");
		String titular = Teclado.nextLine();
		
		System.out.println("\nDeseja adicionar um saldo inicial: [s/n]");
		String aux5 = Teclado.nextLine();
		
		if(aux5.equals("s")) {
			
			System.out.println("\nValor a ser adicionado: ");
			double saldo = Teclado.nextDouble();
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux6 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux6.equals("s")) {
				
				pjcontac.add(new CCorrente(1, numAgencia, saldo, titular, true));
				
			}else {
				
				pjcontac.add(new CCorrente(1, numAgencia, saldo, titular));
				
			}
			
		}else {
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux7 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux7.equals("s")) {
				
				pjcontac.add(new CCorrente(1, numAgencia, titular, true));
				
			}else {
				
				pjcontac.add(new CCorrente(1, numAgencia, titular));
				
			}
			
		}
		
	}
	
	
	public static void pjcriarcontaPoupanca() {

		String numAgencia;

		while(true) {
			
			System.out.println("\n\nInforme o numero da agencia: \n");
			numAgencia = Teclado.nextLine();
			boolean v = verificaragencia(agencia, numAgencia);
			if(v != true) {
				System.out.println("\nA agencia informada não existe!\n");
				System.out.println("Agencias disponiveis:\n");
				listarAgencias();
			}
			else {
				break;
			}
			
		}

		System.out.println("\nNome do titular da conta: ");
		String titular = Teclado.nextLine();
		
		System.out.println("\nDeseja adicionar um saldo inicial: [s/n]");
		String aux10 = Teclado.nextLine();
		
		if(aux10.equals("s")) {
			
			System.out.println("\nValor a ser adicionado: ");
			double saldo = Teclado.nextDouble();
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux9 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux9.equals("s")) {
				
				pjcontap.add(new CPoupanca(1, numAgencia, saldo, titular, true));
				
			}else {
				
				pjcontap.add(new CPoupanca(1, numAgencia, saldo, titular));
				
			}
			
		}else {
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux8 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux8.equals("s")) {
				
				pjcontap.add(new CPoupanca(1, numAgencia, titular, true));
				
			}else {
				
				pjcontap.add(new CPoupanca(1, numAgencia, titular));
				
			}
			
		}
		
	}

	
	public static boolean verificaragencia(ArrayList<Agencia> agencia, String NumAgencia) {
		
		for (Agencia agen : agencia) {
	         if (agen.getNumAgencia().equals(NumAgencia)) {
	        	 
	        	 return true;
	        	  
	         }	
	          
		 }
		
		return false;
		
	}
	
	public static void pfeditarcontaCorrente(String nome1) {
		
		String numAgencia;
		Random random = new Random();
		int numConta = random.nextInt(99999);

		while(true) {
			
			System.out.println("\n\nInforme o numero da agencia: \n");
			numAgencia = Teclado.nextLine();
			boolean v = verificaragencia(agencia, numAgencia);
			if(v != true) {
				System.out.println("\nA agencia informada não existe!\n");
				System.out.println("Agencias disponiveis:\n");
				listarAgencias();
			}
			else {
				break;
			}
			
		}

		System.out.println("\nNome do titular da conta: ");
		String titular = Teclado.nextLine();
		
		System.out.println("\nDeseja adicionar um saldo inicial: [s/n]");
		String aux5 = Teclado.nextLine();
		
		if(aux5.equals("s")) {
			
			System.out.println("\nValor a ser adicionado: ");
			double saldo = Teclado.nextDouble();
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux6 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux6.equals("s")) {
				
				for (int i = 0; i < pfisica.size(); i++) {
			        if (pfisica.get(i).getNome().equals(nome1)) {
			            contac.get(i).setNumAgencia(numAgencia);
			            contac.get(i).setSaldo(saldo);
			            ((CCorrente) contac.get(i)).setTitular(titular);
			            ((CCorrente) contac.get(i)).setCartaocredito(true);
			            contac.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}else {
				
				for (int i = 0; i < pfisica.size(); i++) {
			        if (pfisica.get(i).getNome().equals(nome1)) {
			            contac.get(i).setNumAgencia(numAgencia);
			            contac.get(i).setSaldo(saldo);
			            ((CCorrente) contac.get(i)).setTitular(titular);
			            contac.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}
			
		}else {
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux7 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux7.equals("s")) {
				
				for (int i = 0; i < pfisica.size(); i++) {
			        if (pfisica.get(i).getNome().equals(nome1)) {
			            contac.get(i).setNumAgencia(numAgencia);
			            ((CCorrente) contac.get(i)).setTitular(titular);
			            ((CCorrente) contac.get(i)).setCartaocredito(true);
			            contac.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}else {
				
				for (int i = 0; i < pfisica.size(); i++) {
			        if (pfisica.get(i).getNome().equals(nome1)) {
			            contac.get(i).setNumAgencia(numAgencia);
			            ((CCorrente) contac.get(i)).setTitular(titular);
			            contac.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}
			
		}
		
	}
	
	public static void pfeditarcontaPoupanca(String nome1) {
		
		String numAgencia;
		Random random = new Random();
		int numConta = random.nextInt(99999);

		while(true) {
			
			System.out.println("\n\nInforme o numero da agencia: \n");
			numAgencia = Teclado.nextLine();
			boolean v = verificaragencia(agencia, numAgencia);
			if(v != true) {
				System.out.println("\nA agencia informada não existe!\n");
				System.out.println("Agencias disponiveis:\n");
				listarAgencias();
			}
			else {
				break;
			}
			
		}

		System.out.println("\nNome do titular da conta: ");
		String titular = Teclado.nextLine();
		
		System.out.println("\nDeseja adicionar um saldo inicial: [s/n]");
		String aux5 = Teclado.nextLine();
		
		if(aux5.equals("s")) {
			
			System.out.println("\nValor a ser adicionado: ");
			double saldo = Teclado.nextDouble();
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux6 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux6.equals("s")) {
				
				for (int i = 0; i < pfisica.size(); i++) {
			        if (pfisica.get(i).getNome().equals(nome1)) {
			            contap.get(i).setNumAgencia(numAgencia);
			            contap.get(i).setSaldo(saldo);
			            ((CPoupanca) contap.get(i)).setTitular(titular);
			            ((CPoupanca) contap.get(i)).setCartaocredito(true);
			            contap.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}else {
				
				for (int i = 0; i < pfisica.size(); i++) {
			        if (pfisica.get(i).getNome().equals(nome1)) {
			            contap.get(i).setNumAgencia(numAgencia);
			            contap.get(i).setSaldo(saldo);
			            ((CPoupanca) contap.get(i)).setTitular(titular);
			            contap.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}
			
		}else {
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux7 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux7.equals("s")) {
				
				for (int i = 0; i < pfisica.size(); i++) {
			        if (pfisica.get(i).getNome().equals(nome1)) {
			            contap.get(i).setNumAgencia(numAgencia);
			            ((CPoupanca) contap.get(i)).setTitular(titular);
			            ((CPoupanca) contap.get(i)).setCartaocredito(true);
			            contap.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}else {
				
				for (int i = 0; i < pfisica.size(); i++) {
			        if (pfisica.get(i).getNome().equals(nome1)) {
			            contap.get(i).setNumAgencia(numAgencia);
			            ((CPoupanca) contap.get(i)).setTitular(titular);
			            contap.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}
			
		}
		
	}
	
	public static void pjeditarcontaCorrente(String nome1) {
		
		String numAgencia;
		Random random = new Random();
		int numConta = random.nextInt(99999);

		while(true) {
			
			System.out.println("\n\nInforme o numero da agencia: \n");
			numAgencia = Teclado.nextLine();
			boolean v = verificaragencia(agencia, numAgencia);
			if(v != true) {
				System.out.println("\nA agencia informada não existe!\n");
				System.out.println("Agencias disponiveis:\n");
				listarAgencias();
			}
			else {
				break;
			}
			
		}

		System.out.println("\nNome do titular da conta: ");
		String titular = Teclado.nextLine();
		
		System.out.println("\nDeseja adicionar um saldo inicial: [s/n]");
		String aux5 = Teclado.nextLine();
		
		if(aux5.equals("s")) {
			
			System.out.println("\nValor a ser adicionado: ");
			double saldo = Teclado.nextDouble();
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux6 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux6.equals("s")) {
				
				for (int i = 0; i < pjuridica.size(); i++) {
			        if (pjuridica.get(i).getNome().equals(nome1)) {
			            pjcontac.get(i).setNumAgencia(numAgencia);
			            pjcontac.get(i).setSaldo(saldo);
			            ((CCorrente) pjcontac.get(i)).setTitular(titular);
			            ((CCorrente) pjcontac.get(i)).setCartaocredito(true);
			            pjcontac.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}else {
				
				for (int i = 0; i < pjuridica.size(); i++) {
			        if (pjuridica.get(i).getNome().equals(nome1)) {
			            pjcontac.get(i).setNumAgencia(numAgencia);
			            pjcontac.get(i).setSaldo(saldo);
			            ((CCorrente) pjcontac.get(i)).setTitular(titular);
			            pjcontac.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}
			
		}else {
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux7 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux7.equals("s")) {
				
				for (int i = 0; i < pjuridica.size(); i++) {
			        if (pjuridica.get(i).getNome().equals(nome1)) {
			            pjcontac.get(i).setNumAgencia(numAgencia);
			            ((CCorrente) pjcontac.get(i)).setTitular(titular);
			            ((CCorrente) pjcontac.get(i)).setCartaocredito(true);
			            pjcontac.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}else {
				
				for (int i = 0; i < pjuridica.size(); i++) {
			        if (pjuridica.get(i).getNome().equals(nome1)) {
			            pjcontac.get(i).setNumAgencia(numAgencia);
			            ((CCorrente) pjcontac.get(i)).setTitular(titular);
			            pjcontac.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}
			
		}
		
	}
	
	public static void pjeditarcontaPoupanca(String nome1) {
		
		String numAgencia;
		Random random = new Random();
		int numConta = random.nextInt(99999);

		while(true) {
			
			System.out.println("\n\nInforme o numero da agencia: \n");
			numAgencia = Teclado.nextLine();
			boolean v = verificaragencia(agencia, numAgencia);
			if(v != true) {
				System.out.println("\nA agencia informada não existe!\n");
				System.out.println("Agencias disponiveis:\n");
				listarAgencias();
			}
			else {
				break;
			}
			
		}

		System.out.println("\nNome do titular da conta: ");
		String titular = Teclado.nextLine();
		
		System.out.println("\nDeseja adicionar um saldo inicial: [s/n]");
		String aux5 = Teclado.nextLine();
		
		if(aux5.equals("s")) {
			
			System.out.println("\nValor a ser adicionado: ");
			double saldo = Teclado.nextDouble();
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux6 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux6.equals("s")) {
				
				for (int i = 0; i < pjuridica.size(); i++) {
			        if (pjuridica.get(i).getNome().equals(nome1)) {
			            pjcontap.get(i).setNumAgencia(numAgencia);
			            pjcontap.get(i).setSaldo(saldo);
			            ((CPoupanca) pjcontap.get(i)).setTitular(titular);
			            ((CPoupanca) pjcontap.get(i)).setCartaocredito(true);
			            pjcontap.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}else {
				
				for (int i = 0; i < pjuridica.size(); i++) {
			        if (pjuridica.get(i).getNome().equals(nome1)) {
			            pjcontap.get(i).setNumAgencia(numAgencia);
			            pjcontap.get(i).setSaldo(saldo);
			            ((CPoupanca) pjcontap.get(i)).setTitular(titular);
			            pjcontap.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}
			
		}else {
			
			System.out.println("\nCartão de crédito adicional? [s/n]");
			String aux7 = Teclado.nextLine();
			Teclado.nextLine();
			
			if(aux7.equals("s")) {
				
				for (int i = 0; i < pjuridica.size(); i++) {
			        if (pjuridica.get(i).getNome().equals(nome1)) {
			            pjcontap.get(i).setNumAgencia(numAgencia);
			            ((CPoupanca) pjcontap.get(i)).setTitular(titular);
			            ((CPoupanca) pjcontap.get(i)).setCartaocredito(true);
			            pjcontap.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}else {
				
				for (int i = 0; i < pjuridica.size(); i++) {
			        if (pjuridica.get(i).getNome().equals(nome1)) {
			            pjcontap.get(i).setNumAgencia(numAgencia);
			            ((CPoupanca) pjcontap.get(i)).setTitular(titular);
			            pjcontap.get(i).setNumConta(numConta);
			           
			        }
			    }
				
			}
			
		}
		
	}
	
}
