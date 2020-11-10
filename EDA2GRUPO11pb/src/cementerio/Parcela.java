package cementerio;

public abstract class Parcela {
	protected Double precioPorMes;
	protected Integer codigoParcela;
	protected String lapida;
	
	public Parcela(Integer codigoParcela) {
		super();
		this.codigoParcela = codigoParcela;
	}
}
