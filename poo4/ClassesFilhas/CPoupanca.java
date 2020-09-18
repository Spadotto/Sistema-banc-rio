package poo4.ClassesFilhas;

import poo4.ClassesMaes.Conta;

public class CPoupanca extends Conta{
	
	protected String NumPoupanca;
	
	public CPoupanca(String NumPoupanca, String numConta, double saldo) {
		super(numConta, saldo);
		this.NumPoupanca = NumPoupanca;
	}
	
	public CPoupanca(String NumPoupanca, String numConta) {
		super(numConta);
		this.NumPoupanca = NumPoupanca;
	}
	
	public CPoupanca(String NumPoupanca,double saldo) {
		super(saldo);
		this.NumPoupanca = NumPoupanca;
	}
	
	public String getNumPoupanca() {
		return NumPoupanca;
	}

	public void setNumPoupanca(String NumPoupanca) {
		this.NumPoupanca = NumPoupanca;
	}

	@Override
	public String toString() {
		return "\n[Nº Conta Poupança]: "+ NumPoupanca + "\n[Saldo]: "+ saldo + "\n";
	}

}
