package cementerio;

public class Tierra extends Parcela {
	private Integer libre = 0;
	private Difunto ocupante;
	private Integer costoCuota=500; //Agregado para metodos de pago
	
	public Tierra(Integer codigoParcela) {
		super(codigoParcela);
	}
}
