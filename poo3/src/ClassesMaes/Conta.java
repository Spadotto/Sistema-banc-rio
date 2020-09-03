package ClassesMaes;


public abstract class Conta {
	
	protected double saldo;
	protected int NumConta;
	
	public Conta(int NumConta, double saldo) {
		this.NumConta = NumConta;
		this.saldo = saldo;
	}
	
	public Conta(int NumConta) {
		this.NumConta = NumConta;
		this.saldo = 0.0;
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

	public int getNumConta() {
		return NumConta;
	}

	public void setNumConta(int NumConta) {
		this.NumConta = NumConta;
	}

}
