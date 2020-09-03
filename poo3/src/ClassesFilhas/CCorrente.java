package ClassesFilhas;

import ClassesMaes.Conta;

public class CCorrente extends Conta{
	
	protected int NumCorrente;
	
	public CCorrente(int NumCorrente, int numConta, double saldo) {
		super(numConta, saldo);
		this.NumCorrente = NumCorrente;
	}
	
	public CCorrente(int NumCorrente, int numConta) {
		super(numConta);
		this.NumCorrente = NumCorrente;
	}
	
	public CCorrente(int NumCorrente, double saldo) {
		super(saldo);
		this.NumCorrente = NumCorrente;
	}

	public int getNumCorrente() {
		return NumCorrente;
	}

	public void setNumCorrente(int numCorrente) {
		NumCorrente = numCorrente;
	}

	@Override
	public String toString() {
		return "\n[Nº Conta Corrente]: "+ NumCorrente +"\n[Saldo]: "+ saldo + "\n";
	}

}
