package poo4.ClassesFilhas;

import poo4.ClassesMaes.Conta;

public class JCliente extends Conta {
	
	private String Nome;
	private String cnpj;
	private String nomefantasia;
	private String Email;
	private String telefoneempresa;
	
	public JCliente(String numConta, String cnpj, String nome, String email, String nomefantasia, String telefoneempresa) {
		super(numConta);
		this.Nome = nome;
		this.cnpj = cnpj;
		this.Email = email;
		this.nomefantasia = nomefantasia;
		this.telefoneempresa = telefoneempresa;
	}
	
	public JCliente(String numConta, String cnpj, String nome, String nomefantasia, String telefoneempresa) {
		super(numConta);
		this.Nome = nome;
		this.cnpj = cnpj;
		this.nomefantasia = nomefantasia;
		this.telefoneempresa = telefoneempresa;
	}
	
	public JCliente(String numConta, String cnpj, String nome, String nomefantasia) {
		super(numConta);
		this.Nome = nome;
		this.cnpj = cnpj;
		this.nomefantasia = nomefantasia;
		
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomefantasia() {
		return nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefoneempresa() {
		return telefoneempresa;
	}

	public void setTelefoneempresa(String telefoneempresa) {
		this.telefoneempresa = telefoneempresa;
	}

	@Override
    public String toString() {
        return "\n[Conta] =  "+ NumConta + "\n[CNPJ] = " + cnpj + "\n[Gerente] = "+ Nome + "\n[Email] = " + Email +  "\n[Empresa] = " + nomefantasia + "\n[Telefone] = "+ telefoneempresa + "\n\n";
                   
	}

}
