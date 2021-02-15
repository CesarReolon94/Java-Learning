public abstract class Conta {

	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total;
	//static permite que o atributo total seja compartilhado em todas as contas criadas
	//sem ele, criariamos um atributo total para cada conta
	
	public Conta(int agencia, int numero) {
		Conta.total++;
		System.out.println("O total de contas é " + Conta.total);
		this.agencia = agencia;
		this.numero = numero;
		System.out.println("estou criando uma conta");
	}

	public abstract void deposita(double valor);
	
	public boolean saca(double valor) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean transfere(double valor, Conta destino) {
		if(this.saldo >= valor) {
			this.saca(valor);
			destino.deposita(valor);
			return true;
		} else {
			return false;
		}
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	//normalmente métodos que alteram atributos são do tipo Void, pois não retornam nada
	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("não pode numero negativo");
			return;
		}
		this.numero = numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("não é possível cadastrar agencia com numero negativo");
			return;
		}
		this.agencia = agencia;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	//notar comportamento do total, por ser static, posso invocá-lo sem referência em TestaValores
	public static int getTotal() {
		return Conta.total;
	}
	
	
}
