package poo4.ClassesMaes;


public abstract class Conta {
	
	protected double saldo;
	protected String NumConta;
	
	public Conta(String NumConta, double saldo) {
		this.NumConta = NumConta;
		this.saldo = saldo;
	}
	
	public Conta(String NumConta) {
		this.NumConta = NumConta;
	}
	
	public Conta(double saldo) {
		this.saldo = saldo;
	}
	
	public abstract String toString();

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNumConta() {
		return NumConta;
	}

	public void setNumConta(String NumConta) {
		this.NumConta = NumConta;
	}

}
