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
	
	public Boolean cargarEmpleado(Empleado nuevo) {
		if(nuevo.ingresarCodigoEnElCementerio()!=0) {
			personal.add(nuevo);
			return true;
		}else
			return false;
	}
	
	public Boolean abrirElCementerio() {
		if(personal.size()>=1) {
			estadoDelCementerio = true;
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean cargarNuevoCliente(Cliente nuevo) {
		if(estadoDelCementerio.equals(true)) {
			clientes.add(nuevo);
			return true;
		}else {
			return false;
		}	
	
	}
	public Boolean enterrarDifunto(Cliente nuevo) {
		Tierra nueva = new Tierra(tierras);
		Boolean a = false;
		if(nueva.cargarOcupante(nuevo.entregarDifunto())) {
			a = true;
			tierras++;
		}
		if(a.equals(true)) {
			zonasTerrestres.add(nueva);
			return true;
		}
			return false;
	}

public Boolean depositarEnNichoUnDifunto(Cliente nuevo) {
		Nicho nueva = new Nicho(nichos);
		Boolean a = false;
		if(nueva.cargarOcupante(nuevo.entregarDifunto())) {
			a = true;
			nichos++;
		}
		if(a.equals(true)) {
			zonasAerea.add(nueva);
			return true;
		}
			return false;
	}
	
	public Boolean depositarEnOsario(Cliente nuevo) {
		Osario nueva = new Osario(1);
		Boolean a = false;
		if(nueva.cargarOcupante(nuevo.entregarDifunto())) {
			a = true;
		}
		if(a.equals(true)) {
			zonasComun = (nueva);
			return true;
		}
			return false;
	}
}