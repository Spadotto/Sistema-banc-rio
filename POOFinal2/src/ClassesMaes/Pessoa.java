package ClassesMaes;

public abstract class Pessoa {
	
	protected int ID;
	protected String nome;
	protected String email;
	
	public Pessoa(int ID, String nome, String email) {
		this.ID = ID;
		this.nome = nome;
		this.email = email;
	}
	
	public Pessoa(int ID, String nome) {
		this.ID = ID;
		this.nome = nome;
	}
	
	public abstract String toString();
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
