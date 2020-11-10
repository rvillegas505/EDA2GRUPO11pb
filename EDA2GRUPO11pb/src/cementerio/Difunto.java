package cementerio;

public class Difunto extends Persona {
	private String fechaNacimiento;
	private String fechaFallecimiento;
	
	public Difunto(String nombre, String apellido, Integer dni, String fechaNacimiento, String fechaFallecimiento) {
		super(nombre, apellido, dni);
		this.fechaNacimiento = fechaNacimiento;
		this.fechaFallecimiento = fechaFallecimiento;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaFallecimiento() {
		return fechaFallecimiento;
	}

	public void setFechaFallecimiento(String fechaFallecimiento) {
		this.fechaFallecimiento = fechaFallecimiento;
	}
}
