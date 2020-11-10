package cementerio;

import java.util.HashSet;

public class Osario extends Parcela {
	
	private HashSet<Difunto> persona;
	
	public Osario(Integer codigoParcela) {
		super(codigoParcela);
		persona =new HashSet<Difunto> ();
	}
	@Override
	public Boolean cargarOcupante(Difunto ocupante) {
		if(persona.add(ocupante)) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String VerLapida() {
		String a = "";
		for (Difunto difunto : persona) {
			a+= "Osario\n";
			a+= "QEPD " + difunto.getNombre() + " " + difunto.getApellido() + " nacido: "
					+ difunto.getFechaNacimiento() + " fallecido: " +difunto.getFechaFallecimiento();
			a +="\n";
		}
			return a;
	}
	
	public Difunto buscarDifunto(Difunto uno) {
		for (Difunto difunto : persona) {
			if(uno.getDni().equals(difunto.getDni())) {
				return difunto;
			}
		}
			    return null;
	}
}
