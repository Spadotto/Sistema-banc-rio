package Banco;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import Classes.Agencia;
import Classes.Funcionario;
import Classes.PFCliente;
import Classes.PJCliente;
import java.util.Random;

public class Main {	
	
	private static Scanner Teclado = new Scanner(System.in);
	private static ArrayList<PFCliente> pfisica = new ArrayList<PFCliente>();
	private static ArrayList<PJCliente> pjuridica = new ArrayList<PJCliente>();
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private static ArrayList<Agencia> agencia = new ArrayList<Agencia>();
	
	public static void main(String[] args) throws IOException {
		
		funcionarios.add(new Funcionario(12000, "Garibalda Silva", "14854764564"));
		funcionarios.add(new Funcionario(11960, "Diosesmar Petruchka", "87834546876"));
		funcionarios.add(new Funcionario(15000, "Florentina Flor", "87487465413"));
		funcionarios.add(new Funcionario(11989, "Cleudeusmar Jurasick", "51454864568"));
		funcionarios.add(new Funcionario(11990, "Jobesvaldo Carmo", "84864515418"));
		
		agencia.add(new Agencia("478-9", "Sunset Valley", "99969696", 12000, "Garibalda Silva", "14854764564"));
		agencia.add(new Agencia("557-4", "Riverview", "66051247", 11960, "Diosesmar Petruchka", "87834546876"));
		agencia.add(new Agencia("666-6", "Bridgport", "88630029", 15000, "Florentina Flor", "87487465413"));
		agencia.add(new Agencia("891-3", "Twinbrook", "99968722", 11989, "Cleudeusmar Jurasick", "51454864568"));
		agencia.add(new Agencia("263-2", "Apaloosa Plains", "36005548", 11990, "Jobesvaldo Carmo", "84864515418"));
		
		int escolha = 0;
		int teste;
		while(escolha !=1) {
			
			System.out.flush();
			String senha; 
			String login;
			System.out.println("------------------------------------");
			System.out.println("Sistema bancario:\n");
			
			while(true) {
				
				System.out.println("\n\nInforme o numero da agencia: \n");
				String agenciain = Teclado.nextLine();
				boolean v = verificaragencia(agencia, agenciain);
				if(v != true) {
					System.out.println("\nA agencia informada não existe!\n");
					System.out.println("Agencias disponiveis:\n");
					listarAgencias();
				}
				else {
					break;
				}
				
			}
			
			System.out.println("\n[1} LOGIN\nQualqer outra tecla SAIR\n");
			System.out.println("Press Enter");
			teste = Teclado.nextInt();
			
			if (teste == 1) {
				
				System.out.println("\nDigite o nome de usuario: \n");
				login = Teclado.next();
				System.out.println("\nDigite a senha: \n");
				senha = Teclado.next();
				
				if (login.equals("admin") && senha.equals("123")) {
					
					System.out.println("\nLogin realizado com sucesso!\n");
					System.out.println("------------------------------------\n");
					escolha = 1;
					System.out.println("Press Enter");
					System.in.read();
					
				}else {
					
					System.out.println("\nSenha ou usuário incorretos!\n");
					System.out.println("------------------------------------\n");
					System.out.println("Press Enter");
					System.in.read();
					
				}
			}else {
				System.exit(0);
			}
			
		}
			
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
								
								PFCliente buscarFcliente =  buscarFCliente(pfisica, qwe);
								
								if(buscarFcliente != null) {
									System.out.println("\nId: "+buscarFcliente.getID()+"\nNome: "+buscarFcliente.getNome()+"\nCPF: "+buscarFcliente.getCPF()+"\nConta corrente: "+buscarFcliente.getCcorrente()+"\nConta poupança: "+buscarFcliente.getCpoupanca());
		
								}
								break;
								
							}
							if(op == 2) {
								
								System.out.println("Digite o nome do cliente a ser pesquisado: ");
								@SuppressWarnings("resource")
								Scanner b = new Scanner(System.in);
								String ewq = b.nextLine();
								b.nextLine();
								
								PJCliente buscarJcliente =  buscarJCliente(pjuridica, ewq);
								
								if(buscarJcliente != null) {
									
									System.out.println("\nId: "+buscarJcliente.getID()+"\nNome: "+buscarJcliente.getNome()+"\nCNPJ: "+buscarJcliente.getCNPJ()+"\nConta corrente: "+buscarJcliente.getCcorrente()+"\nConta poupança: "+buscarJcliente.getCpoupanca());

								}
								
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
						
						Iterator<PJCliente> j = pjuridica.iterator();
						Iterator<PFCliente> f = pfisica.iterator();
						
						if(op == 1) {
							
							System.out.println("Digite o nome do cliente que deseja excluir: ");
							String nome = Teclado.nextLine();
							
							while (f.hasNext()) {
								PFCliente nome2 = f.next();
								if (nome.equals(nome2.getNome())) {
					        	 
									f.remove();
					        	   
								}	
					          
							}
							
							System.out.println("\nCliente removido com sucesso!\n");
							
						}
						
						if(op == 2) {
							
							System.out.println("Digite o nome do cliente que deseja excluir: ");
							String nome = Teclado.nextLine();
							
							while (j.hasNext()) {
								PJCliente nome2 = j.next();
								if (nome.equals(nome2.getNome())) {
					        	 
									j.remove();
					        	   
								}	
					          
							}
							
							System.out.println("\nCliente removido com sucesso!\n");
							
						}
						
						System.out.println("\n\n\n\n\n\n");
					break;
						
				}
				
			}
			
			if (opcao == 2) {
				System.out.println("\n______________________________________________\n");
				System.out.println("\n1. Listar agencias;");
				System.out.println("\n2. Consultar agencia;");
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
						System.out.println("\nNumero da agencia: "+buscarAgencia.getNumAgencia()+"\nCidade: "+buscarAgencia.getCidade()+"\nTelefone: "+buscarAgencia.getTelefone()+"\nGerente: "+buscarAgencia.getNome());

					}
					System.out.println("\n\n\n\n\n\n");
				
				}
				
			}
			
			if (opcao == 0) {
				System.out.println("\n\nDeslogando....\n");
				System.exit(0);
			}
			
		} while(true);
			
	}

	public static void cadastrarFCliente() {
		
		Teclado.nextLine();
		System.out.println("Digite os dados");
        
        System.out.println("\nQual seu nome: ");
		String Nome = Teclado.nextLine();
		
		System.out.println("\nDigite seu CPF: ");
		String CPF = Teclado.nextLine();
		
		System.out.println("\nID: ");
	    int ID = Teclado.nextInt();
	    Teclado.nextLine();
	    
	    System.out.println("\n\n1. Criar conta Corrente;\n2. Criar conta Poupança;\n3. Criar os dois tipos de conta;\n");
	    int aux = Teclado.nextInt();
	    Teclado.nextLine();
	    
		int Ccorrente = 0;
	    int Cpoupanca = 0;
	    Random random = new Random();
	    
	    switch(aux) {
	    	case 1 :
	    		
	    		System.out.println("\nNome do titular: "+Nome);
				Ccorrente = random.nextInt(99999);
				System.out.println("\nNumero da conta corrente: "+Ccorrente);
			break;
			
	    	case 2 :
	    		
	    		System.out.println("\nNome do titular: "+Nome);
				Cpoupanca = random.nextInt(99999);
				System.out.println("\nNumero da conta poupança: "+Cpoupanca);
			break;
			
	    	case 3 :
	    		
	    		System.out.println("\nNome do titular: "+Nome);
				Cpoupanca = random.nextInt(99999);
				System.out.println("\nNumero da conta poupança: "+Cpoupanca);
				Ccorrente = random.nextInt(99999);
				System.out.println("\nNumero da conta corrente: "+Ccorrente);
	    	break;
	    		
	    }
	    
	    pfisica.add(new PFCliente(ID, CPF, Nome, Ccorrente, Cpoupanca));
		
	}
	
	public static void cadastrarJCliente() {
		
		Teclado.nextLine();
		System.out.println("Digite os dados");
        
        System.out.println("\nQual seu nome: ");
		String Nome = Teclado.nextLine();
		
		System.out.println("\nDigite seu CNPJ: ");
		String CNPJ = Teclado.nextLine();
		
		System.out.println("\nID: ");
	    int ID = Teclado.nextInt();
	    Teclado.nextLine();
	    
	    System.out.println("\n\n1. Criar conta Corrente;\n2. Criar conta Poupança;\n3. Criar os dois tipos de conta;\n");
	    int aux = Teclado.nextInt();
	    Teclado.nextLine();
	    
	    int Ccorrente = 0;
	    int Cpoupanca = 0;
	    Random random = new Random();
	    
	    switch(aux) {
	    	case 1 :
	    		
	    		System.out.println("\nNome do titular: "+Nome);
				Ccorrente = random.nextInt(99999);
				System.out.println("\nNumero da conta corrente: "+Ccorrente);
			break;
			
	    	case 2 :
	    		
	    		System.out.println("\nNome do titular: "+Nome);
				Cpoupanca = random.nextInt(99999);
				System.out.println("\nNumero da conta poupança: "+Cpoupanca);
			break;
			
	    	case 3 :
	    		
	    		System.out.println("\nNome do titular: "+Nome);
				Cpoupanca = random.nextInt(99999);
				System.out.println("\nNumero da conta poupança: "+Cpoupanca);
				Ccorrente = random.nextInt(99999);
				System.out.println("\nNumero da conta corrente: "+Ccorrente);
	    	break;
	    		
	    }
	    
	    pjuridica.add(new PJCliente(ID, CNPJ, Nome, Ccorrente, Cpoupanca));
		
	}
	
	public static void listarClientes() {
		
		System.out.println("\n\nClientes Físicos: ");
		
		for(PFCliente tS : pfisica) {
			
			System.out.println(tS.toString());
			
		}
		
		System.out.println("\n\nClientes Jurídicos: ");
		
		for(PJCliente tS : pjuridica) {
			
			System.out.println(tS.toString());
			
		}
		
	}
	
	public static PJCliente buscarJCliente(ArrayList<PJCliente> pjuridica, String Nome) {
	     
	     for (PJCliente pj : pjuridica) {
	         if (pj.getNome().equals(Nome)) {
	        	 
	        	 return pj;
	        	  
	         }
	         else {
	        	 System.out.println("\nCliente não encontrado!\n");
	         }
	          
		 }
	     return null;
	}
	
	public static PFCliente buscarFCliente(ArrayList<PFCliente> pfisica, String Nome) {
	     
	     for (PFCliente pf : pfisica) {
	         if (pf.getNome().equals(Nome)) {
	        	 
	        	 return pf;
	        	  
	         }
	         else {
	        	 System.out.println("\nCliente não encontrado!\n");
	         }
	          
		 }
	     return null;
		
	}
	
	public static void listarAgencias() {
		
		System.out.println("\nAgencias cadastradas: \n\n");
		
		for(Agencia tS : agencia) {
			
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
	
	public static boolean verificaragencia(ArrayList<Agencia> agencia, String NumAgencia) {
		
		for (Agencia agen : agencia) {
	         if (agen.getNumAgencia().equals(NumAgencia)) {
	        	 
	        	 return true;
	        	  
	         }	
	          
		 }
		
		return false;
		
	}
	
}
