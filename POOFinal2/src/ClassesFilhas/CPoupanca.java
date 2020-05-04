package ClassesFilhas;

import java.util.Random;

import ClassesMaes.Conta;

public class CPoupanca extends Conta{
	
	private String titular;
	private boolean cartaocredito;
	
	@Override
	public int getnumConta(){ 
		Random random = new Random();
		numConta = random.nextInt(99999);
		return this.numConta;
	}
	
	public CPoupanca(int numConta, String numAgencia, double saldo, String titular, boolean cartaocredito) {
		super(numAgencia, saldo);
		this.titular = titular;
		this.cartaocredito = true;
		numConta = getnumConta();
	}
	
	public CPoupanca(int numConta, String numAgencia, String titular, boolean cartaocredito) {
		super(numAgencia);
		this.saldo = 0.0;
		this.titular = titular;
		this.cartaocredito = true;
		numConta = getnumConta();
	}
	
	public CPoupanca(int numConta, String numAgencia, double saldo, String titular) {
		super(numAgencia, saldo);
		this.titular = titular;
		this.cartaocredito = false;
		numConta = getnumConta();
	}
	
	public CPoupanca(int numConta, String numAgencia, String titular) {
		super(numAgencia, numConta);
		this.saldo = 0.0;
		this.titular = titular;
		this.cartaocredito = false;
		numConta = getnumConta();
	}
	
	public CPoupanca(String titular) {
		super(titular);
		this.titular = "não possui";
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public boolean isCartaocredito() {
		return cartaocredito;
	}

	public void setCartaocredito(boolean cartaocredito) {
		this.cartaocredito = cartaocredito;
	}
	
	@Override
	public String toString() {
		return "\n[Agencia]: "+ numAgencia + "\n[Nº Conta Poupança]: "+ numConta + "\n[Saldo]: "+ saldo + "\n[Possui catão]: "+ cartaocredito +"\n[Titular]: "+ titular;
	}

}
