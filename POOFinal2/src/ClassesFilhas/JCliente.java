package ClassesFilhas;

import ClassesMaes.Pessoa;

public class JCliente extends Pessoa {
	
	private String cnpj;
	private String nomefantasia;
	private int telefoneempresa;
	
	public JCliente(int ID, String nome, String email, String cnpj, String nomefantasia, int telefoneempresa) {
		super(ID, nome, email);
		this.cnpj = cnpj;
		this.nomefantasia = nomefantasia;
		this.telefoneempresa = telefoneempresa;
	}
	
	public JCliente(int ID, String nome, String cnpj, String nomefantasia, int telefoneempresa) {
		super(ID, nome);
		this.email = "não tem";
		this.cnpj = cnpj;
		this.nomefantasia = nomefantasia;
		this.telefoneempresa = telefoneempresa;
	}
	
	public JCliente(int ID, String nome, String email, String cnpj, String nomefantasia) {
		super(ID, nome, email);
		this.cnpj = cnpj;
		this.nomefantasia = nomefantasia;
		this.telefoneempresa = 0;
	}
	
	public JCliente(int ID, String nome, String cnpj, String nomefantasia) {
		super(ID, nome);
		this.email = "não tem";
		this.cnpj = cnpj;
		this.nomefantasia = nomefantasia;
		this.telefoneempresa = 0;
	}

	public int getTelefoneempresa() {
		return telefoneempresa;
	}

	public void setTelefoneempresa(int telefoneempresa) {
		this.telefoneempresa = telefoneempresa;
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

	@Override
    public String toString() {
        return "[ID} =  "+ ID + " [Empresa] = " + nomefantasia +
                "  [Email] = " + email + " [CNPJ] = " + cnpj + 
                " [Telefone] = "+ telefoneempresa + "[Gerente] = "+ nome;
	}

}
