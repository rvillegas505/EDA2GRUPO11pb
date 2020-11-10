package cementerio;

public class Tierra extends Parcela {
	private Integer libre = 0;
	private Difunto ocupante;
	private Integer costoCuota=500; //Agregado para metodos de pago
	
	public Tierra(Integer codigoParcela) {
		super(codigoParcela);
	}
	@Override
	public Boolean cargarOcupante(Difunto ocupantes) {
		if(libre==0) {
			ocupante = ocupantes;
			libre++;
			lapida = "QEPD " + ocupantes.getNombre() + " " + ocupantes.getApellido() + " nacido: "
					+ ocupantes.getFechaNacimiento() + " fallecido: " +ocupantes.getFechaFallecimiento();
			return true;
		}
			return false;
	}
	
//Agregado para metodos de pago
			public Integer getCuota(){
				return costoCuota;
			}
}
