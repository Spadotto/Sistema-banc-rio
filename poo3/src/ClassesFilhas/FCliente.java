package ClassesFilhas;

import ClassesMaes.Conta;

public class FCliente extends Conta {
	
	private String Nome;
	private String CPF;
	private String Email;
	private String telefonepessoal;
	
	
	public FCliente(int numConta, String cpf, String nome, String Email, String telefonepessoal) {
		super(numConta);
		this.Nome = nome;
		this.CPF = cpf;
		this.Email = Email;
		this.telefonepessoal = telefonepessoal;
	}
	
	public FCliente(int numConta, String cpf, String nome, String telefonepessoal) {
		super(numConta);
		this.Nome = nome;
		this.CPF = cpf;
		this.telefonepessoal = telefonepessoal;
	}
	
	public FCliente(int numConta, String cpf, String nome) {
		super(numConta);
		this.Nome = nome;
		this.CPF = cpf;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefonepessoal() {
		return telefonepessoal;
	}

	public void setTelefonepessoal(String telefonepessoal) {
		this.telefonepessoal = telefonepessoal;
	}

	@Override
    public String toString() {
        return "\n[Conta] =  " + NumConta + "\n[Nome] = " + Nome + "\n[CPF] = " + CPF + "\n[Email] = " + Email + "\n[Telefone] = " + telefonepessoal + "\n\n";
	}

}
