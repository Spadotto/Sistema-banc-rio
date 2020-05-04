package ClassesMaes;

public abstract class Conta {
	
	protected double saldo;
	protected int numConta;
	protected String numAgencia;
	
	public Conta(String numAgencia) {
		this.numAgencia = numAgencia;
		this.saldo = 0.0;
	}
	
	public Conta(String numAgencia, double saldo) {
		this.numAgencia = numAgencia;
		this.saldo = saldo;
	}

	public abstract int getnumConta();

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public String getNumAgencia() {
		return numAgencia;
	}

	public void setNumAgencia(String numAgencia) {
		this.numAgencia = numAgencia;
	}

}
