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

public String verLapidasDeTierra() {
		String a = "";
		for (Tierra tierra : zonasTerrestres) {
			a+="Terrestre codigo:" + tierra.getCodigoParcela() + "\n";
			a += tierra.VerLapida();
			a +="\n";
		}
			return a;
	}
public String verLapidasDeAire() {
		String a = "";
		for (Nicho nicho : zonasAerea) {
			a+="Nicho codigo:" + nicho.getCodigoParcela() +"\n";
			a += nicho.VerLapida();
			a +="\n";
		}
			return a;
	}
	
	public String verLapidaDelOsario() {
		return zonasComun.VerLapida();
	}
	
	public String getNombreDelCementerio() {
		return nombreDelCementerio;
	}

	public void setNombreDelCementerio(String nombreDelCementerio) {
		this.nombreDelCementerio = nombreDelCementerio;
	}

	public HashSet<Empleado> getPersonal() {
		return personal;
	}

	public void setPersonal(HashSet<Empleado> personal) {
		this.personal = personal;
	}

	public HashSet<Tierra> getZonasTerrestres() {
		return zonasTerrestres;
	}

	public void setZonasTerrestres(HashSet<Tierra> zonasTerrestres) {
		this.zonasTerrestres = zonasTerrestres;
	}

	public HashSet<Nicho> getZonasAerea() {
		return zonasAerea;
	}

	public void setZonasAerea(HashSet<Nicho> zonasAerea) {
		this.zonasAerea = zonasAerea;
	}

	public Osario getZonasComun() {
		return zonasComun;
	}

	public void setZonasComun(Osario zonasComun) {
		this.zonasComun = zonasComun;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public Boolean pasajeDeTierraAOsario(Difunto uno) {
		Difunto pasado;
		Boolean exito = false;
		for (Tierra tierra : zonasTerrestres) {
			if(tierra.getOcupante().getDni().equals(uno.getDni())) {
				pasado = tierra.getOcupante();
				tierra.removerOcupante();
				zonasComun.cargarOcupante(pasado);
				exito = true;
			}
		}	
				return exito;
	}
	
	public Boolean pasajeDeNichoAOsario(Difunto uno) {
		Difunto pasado = null;
		Boolean exito = false;
		for (Nicho nicho : zonasAerea) {
			pasado = nicho.buscarDifunto(uno);
			zonasComun.cargarOcupante(pasado);
			nicho.removerOcupante(uno);
			exito = true;
		}
			return exito;
	}
	
	public String verListaDeClientes() {
		String a = "";
		for (Cliente cliente : clientes) {
			a += "Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + " " + cliente.getDni();
			a +="\n";
		}
			return a;
	}
	
}
