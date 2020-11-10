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
}
