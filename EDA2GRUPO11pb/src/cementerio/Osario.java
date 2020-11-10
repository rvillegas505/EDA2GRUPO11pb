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
}
