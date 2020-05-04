package ClassesFilhas;

import ClassesMaes.Pessoa;

public class FCliente extends Pessoa {
	
	private String CPF;
	private int telefonepessoal;
	
	public FCliente(int ID, String nome, String email, String cpf, int telefonepessoal) {
		super(ID, nome, email);
		this.CPF = cpf;
		this.telefonepessoal = telefonepessoal;
	}
	
	public FCliente(int ID, String nome, String cpf, int telefonepessoal) {
		super(ID, nome);
		this.email = "não tem";
		this.CPF = cpf;
		this.telefonepessoal = telefonepessoal;
	}
	
	public FCliente(int ID, String nome, String email, String cpf) {
		super(ID, nome, email);
		this.CPF = cpf;
		this.telefonepessoal = 0;
	}
	
	public FCliente(int ID, String nome, String cpf) {
		super(ID, nome);
		this.email = "não tem";
		this.CPF = cpf;
		this.telefonepessoal = 0;
	}
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public int getTelefonepessoal() {
		return telefonepessoal;
	}

	public void setTelefonepessoal(int telefonepessoal) {
		this.telefonepessoal = telefonepessoal;
	}

	@Override
    public String toString() {
        return "[ID] =  "+ ID + " [Nome] = " + nome +
                "  [Email] = " + email + " [CPF] = " + CPF + 
                " [Telefone] = "+ telefonepessoal;
	}

}
