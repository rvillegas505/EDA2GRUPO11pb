package cementerio;

public abstract class Parcela {
	protected Double precioPorMes;
	protected Integer codigoParcela;
	protected String lapida;
	
	public Parcela(Integer codigoParcela) {
		super();
		this.codigoParcela = codigoParcela;
	}
	public abstract Boolean cargarOcupante(Difunto ocupante);

	public Double getPrecioPorMes() {
		return precioPorMes;
	}

	public void setPrecioPorMes(Double precioPorMes) {
		this.precioPorMes = precioPorMes;
	}

	public Integer getCodigoParcela() {
		return codigoParcela;
	}

	public void setCodigoParcela(Integer codigoParcela) {
		this.codigoParcela = codigoParcela;
	}

	public String VerLapida() {
		return lapida;
	}
	
}
