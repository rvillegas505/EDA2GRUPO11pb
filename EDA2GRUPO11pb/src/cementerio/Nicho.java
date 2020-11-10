package cementerio;

import java.util.HashSet;

public class Nicho extends Parcela {
	private HashSet<Difunto> persona = new HashSet<Difunto> ();
	private Integer libres = 0;
	private Integer costoCuota=200; //Agregado para metodos de pago
	
	public Nicho(Integer codigoParcela) {
		super(codigoParcela);
	}
	@Override
		public Boolean cargarOcupante(Difunto ocupantes) {
			if(libres<=5) {
				persona.add(ocupantes);
				libres++;
				lapida = "QEPD " + ocupantes.getNombre() + " " + ocupantes.getApellido() + " nacido: "
						+ ocupantes.getFechaNacimiento() + " fallecido: " +ocupantes.getFechaFallecimiento();
				return true;
			}
				return false;
		}
}
