package cementerio;

public abstract class Persona {
	
	protected String nombre;
	protected String apellido;
	protected Integer dni;
	
	public Persona(String nombre, String apellido, Integer dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
}