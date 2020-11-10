package cementerio;

import java.util.HashSet;

public class Osario extends Parcela {
	
	private HashSet<Difunto> persona;
	
	public Osario(Integer codigoParcela) {
		super(codigoParcela);
		persona =new HashSet<Difunto> ();
	}
}
