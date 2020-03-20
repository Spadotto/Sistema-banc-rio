package Classes;

public class PJCliente extends PJuridica {
	private int ID;
	int Ccorrente;
	int Cpoupanca;
	
	public PJCliente(int ID, String CNPJ, String Nome, int Ccorrente, int Cpoupanca) {
		super(CNPJ, Nome);
		this.ID = ID;
		this.Ccorrente = Ccorrente;
		this.Cpoupanca = Cpoupanca;
	}
	
	public int getCcorrente() {
		return Ccorrente;
	}

	public void setCcorrente(int Ccorrente) {
		this.Ccorrente = Ccorrente;
	}

	public int getCpoupanca() {
		return Cpoupanca;
	}

	public void setCpoupanca(int Cpoupanca) {
		this.Cpoupanca = Cpoupanca;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	@Override
	public String toString() {
		return "\nID: "+ID+"\nNome: "+Nome+"\nCNPJ: "+CNPJ+"\n\n\n";
	}

}
