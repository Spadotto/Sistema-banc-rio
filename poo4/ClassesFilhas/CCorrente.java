package poo4.ClassesFilhas;

import poo4.ClassesMaes.Conta;

public class CCorrente extends Conta{
	
	protected String NumCorrente;
	
	public CCorrente(String NumCorrente, String numConta, double saldo) {
		super(numConta, saldo);
		this.NumCorrente = NumCorrente;
	}
	
	public CCorrente(String NumCorrente, String numConta) {
		super(numConta);
		this.NumCorrente = NumCorrente;
	}
	
	public CCorrente(String NumCorrente, double saldo) {
		super(saldo);
		this.NumCorrente = NumCorrente;
	}

	public String getNumCorrente() {
		return NumCorrente;
	}

	public void setNumCorrente(String numCorrente) {
		NumCorrente = numCorrente;
	}

	@Override
	public String toString() {
		return "\n[Nº Conta Corrente]: "+ NumCorrente +"\n[Saldo]: "+ saldo + "\n";
	}

}
