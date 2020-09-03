package ClassesFilhas;

public class Agencia {
	
	private String Cidade;
	private String NumAgencia;
	private String Telefone;
	private String app;
	
	public Agencia(String NumAgencia, String Cidade, String Telefone) {
		this.Cidade = Cidade;
		this.NumAgencia = NumAgencia;
		this.Telefone = Telefone;
		this.app = "não possui";
	}
	
	public Agencia(String NumAgencia, String Cidade, String Telefone, String app) {
		this.Cidade = Cidade;
		this.NumAgencia = NumAgencia;
		this.Telefone = Telefone;
		this.app = app;
	}
	
	public Agencia(String numAgencia) {
		this.NumAgencia = numAgencia;
	}
	
	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getCidade() {
		return Cidade;
	}
	
	public void setCidade(String Cidade) {
		this.Cidade = Cidade;
	}
	
	public String getNumAgencia() {
		return NumAgencia;
	}
	
	public void setNumAgencia(String NumAgencia) {
		this.NumAgencia = NumAgencia;
	}
	
	public String getTelefone() {
		return Telefone;
	}
	
	public void setTelefone(String Telefone) {
		this.Telefone = Telefone;
	}
	
	@Override
	public String toString() {
		return "\n[Numero da agencia]: "+NumAgencia+"\n[Cidade]: "+Cidade+"\n[Telefone]: "+ Telefone+"\n[App link]: "+app+"\n\n\n";
	}

}
