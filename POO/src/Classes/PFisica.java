package Classes;

public abstract class PFisica extends Pessoa {
	String CPF;
	
	public PFisica(String CPF, String Nome) {
		super(Nome);
		this.CPF = CPF;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

}
