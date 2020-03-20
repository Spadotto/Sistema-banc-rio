package Classes;

public class PFCliente extends PFisica {
	private int ID;
	private int Ccorrente;
	private int Cpoupanca;
	
	public PFCliente(int ID, String CPF, String Nome, int Ccorrente, int Cpoupanca) {
		super(CPF, Nome);
		this.ID = ID;
		this.Ccorrente = Ccorrente;
		this.Cpoupanca = Cpoupanca;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
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

	@Override
	public String toString() {
		return "\nID: "+ID+"\nNome: "+Nome+"\nCPF: "+CPF+"\n\n\n";
	}

}
