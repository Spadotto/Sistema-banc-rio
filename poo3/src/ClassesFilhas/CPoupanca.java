package ClassesFilhas;

import ClassesMaes.Conta;

public class CPoupanca extends Conta{
	
	protected int NumPoupanca;
	
	public CPoupanca(int NumPoupanca, int numConta, double saldo) {
		super(numConta, saldo);
		this.NumPoupanca = NumPoupanca;
	}
	
	public CPoupanca(int NumPoupanca, int numConta) {
		super(numConta);
		this.saldo = 0.0;
		this.NumPoupanca = NumPoupanca;
	}
	
	public CPoupanca(int NumPoupanca, double saldo) {
		super(saldo);
		this.NumPoupanca = NumPoupanca;
	}
	
	public int getNumPoupanca() {
		return NumPoupanca;
	}

	public void setNumPoupanca(int NumPoupanca) {
		this.NumPoupanca = NumPoupanca;
	}

	@Override
	public String toString() {
		return "\n[Nº Conta Poupança]: "+ NumPoupanca + "\n[Saldo]: "+ saldo + "\n";
	}

}
