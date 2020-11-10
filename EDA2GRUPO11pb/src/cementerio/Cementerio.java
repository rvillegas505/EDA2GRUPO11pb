package cementerio;

import java.util.ArrayList;
import java.util.HashSet;

public class Cementerio {
	private Integer tierras = 0;
	private Integer nichos = 0;
	private String nombreDelCementerio;
	private Boolean estadoDelCementerio = false;
	private HashSet<Empleado> personal;
	private HashSet<Tierra> zonasTerrestres;
	private HashSet<Nicho> zonasAerea;
	private Osario zonasComun;
	private ArrayList<Cliente> clientes;
	public Cementerio(String nombreDelCementerio) {
		super();
		this.nombreDelCementerio = nombreDelCementerio;
		personal =new HashSet<Empleado> ();
		clientes = new ArrayList<Cliente> ();
		zonasTerrestres = new HashSet<Tierra>();
		zonasAerea = new HashSet<Nicho>();
	}
}