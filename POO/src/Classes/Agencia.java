package Classes;

public class Agencia extends Funcionario {
	private String Cidade;
	private String NumAgencia;
	private String Telefone;
	
	public Agencia(String NumAgencia, String Cidade, String Telefone, double Salario, String CPF, String Nome) {
		super(Salario, CPF, Nome);
		this.Cidade = Cidade;
		this.NumAgencia = NumAgencia;
		this.Telefone = Telefone;
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
		return "\nNumero da agencia: "+NumAgencia+"\nCidade: "+Cidade+"\n\n\n";
	}

}
