package banco2;

public class Conta {
	
	private int numero;
	private String cliente;
	private float saldo;
	private static int numeroGeral =0;
	
	public Conta(String nomeCliente) {
		this.cliente = nomeCliente;
		this.saldo = 0;
		numeroGeral++;
		this.numero = numeroGeral;
	}
	
	public String getCliente() {
		return this.cliente;
	}
	public int getNumero() {
		return this.numero;
	}
	public float getSaldo() {
		return saldo;
	}
	
	public void depositar(float valor) {
		if(valor >=0) {
			this.saldo += valor;
		}
		
	}
	public boolean sacar(float valor) {
		if(valor >= 0 && this.saldo >= (valor + 0.02)) {
			this.saldo -= 0.02;
			this.saldo -= valor;
			return true;
		}
		return false;
		
	}
	
	public boolean transferir(float valor, Conta destino) {
		if(this.sacar(valor)) {
			destino.depositar(valor);
			return true;
		}
		return false;
	}
	
	public static boolean transferir(Conta origem, float valor, Conta destino) {
		return origem.transferir(valor, destino);
	}

}
