package Classes;

public abstract class PJuridica extends Pessoa {
	String CNPJ;
	
	public PJuridica(String CNPJ, String Nome) {
		super(Nome);
		this.CNPJ = CNPJ;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}

}
