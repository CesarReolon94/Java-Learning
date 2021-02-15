
public class TesteTributaveis {

	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(222, 333);
		cc.deposita(100.0);
		
		SeguroDeVida seguro = new SeguroDeVida();

		CalculadorImposto calc = new CalculadorImposto();
		calc.calculaImposto(cc);
		calc.calculaImposto(seguro);
		
		System.out.println(calc.getTotalImposto());
	}

}
