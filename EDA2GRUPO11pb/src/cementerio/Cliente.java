package cementerio;


public class Cliente extends Persona {
	private Difunto difunto;
	private Integer dinero=0; //Agregado para metodos de pagar
	public Cliente(String nombre, String apellido, Integer dni) {
		super(nombre,apellido,dni);
	}
	
	public Difunto entregarDifunto() {
		return difunto;
	}
	public Difunto entregarDifunto() {
		return difunto;
	}
	public void setDifunto(Difunto difunto) {
		this.difunto = difunto;
	}	
	
	public void setDinero (Integer dinero) {
		this.dinero=dinero;
	}

//Agregado para metodos de pagar
	
	public Boolean pagarCuotaNicho(Nicho nicho) {
		Boolean pago = false;
		
		if (this.dinero>=nicho.getCuota()) {
			this.dinero= this.dinero- nicho.getCuota();
			pago= true;
		}
		
		return pago;
		
	}
	
	public Boolean pagarCuotaTierra(Tierra tierra) {
		Boolean pago = false;
		
		if (this.dinero>=tierra.getCuota()) {
			this.dinero= this.dinero- tierra.getCuota();
			pago= true;
		}
		
		return pago;
		
	}
	
	
}
