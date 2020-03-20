package Classes;

public class Funcionario extends PFisica {
	private double Salario;
	
	public Funcionario(double Salario, String Nome, String CPF) {
		super(CPF, Nome);
		this.Salario = Salario;
	}
	
	public double getSalario() {
		return Salario;
	}
	
	public void setSalario(double Salario) {
		this.Salario = Salario;
	}

}
