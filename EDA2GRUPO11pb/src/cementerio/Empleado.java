package cementerio;

public class Empleado extends Persona {
	private Integer codigoPersonal = 0;

	public Empleado(String nombre, String apellido, Integer dni) {
		super(nombre,apellido,dni);
	}
	public void setCodigoPersonal(Integer codigoPersonal) {
		if(codigoPersonal>=1 && codigoPersonal<=100) {
			this.codigoPersonal = codigoPersonal;
		}
	}
	public Integer ingresarCodigoEnElCementerio() {
		return codigoPersonal;
	}
}
