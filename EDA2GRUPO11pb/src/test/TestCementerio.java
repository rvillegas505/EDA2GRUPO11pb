package test;

import static org.junit.Assert.*;

import org.junit.Test;



	import cementerio.Cementerio;
	import cementerio.Cliente;
	import cementerio.Difunto;
	import cementerio.Empleado;
	import cementerio.Nicho;
	import cementerio.Tierra;


	public class TestCementerio {

		
		@Test
		public void testQueSeDepositeElDifuntoEnNicho() {
			//el cementerio se encarga de depositar al difunto, segun la eleccion de la parcela
			Empleado nuevo = new Empleado("Marcos", "Paz", 27654123);
			Cementerio chacarita = new Cementerio("Chacarita");
			nuevo.setCodigoPersonal(1);
			chacarita.cargarEmpleado(nuevo);
			chacarita.abrirElCementerio();
			
			Cliente pablo = new Cliente("Pablo", "Gomez", 37987589);
			
			Difunto familiar = new Difunto("Ximena", "Estevez", 10834345, "06/09/1926", "06/11/2020");
			pablo.setDifunto(familiar);
			
			Boolean enterro = chacarita.depositarEnNichoUnDifunto(pablo);
			
			assertTrue(enterro);
		}
		
		@Test
		public void testQueSeDepositeElDifuntoEnOsario() {
			//el cementerio se encarga de depositar al difunto, en el osario.
			Empleado nuevo = new Empleado("Marcos", "Paz", 27654123);
			Cementerio chacarita = new Cementerio("Chacarita");
			nuevo.setCodigoPersonal(1);
			chacarita.cargarEmpleado(nuevo);
			chacarita.abrirElCementerio();
			
			Cliente pablo = new Cliente("Pablo", "Gomez", 37987589);
			
			Difunto familiar = new Difunto("Ximena", "Estevez", 10834345, "06/09/1926", "06/11/2020");
			pablo.setDifunto(familiar);
			
			Boolean enterro = chacarita.depositarEnOsario(pablo);
			
			assertTrue(enterro);
		}
		
		@Test
		public void testQueSePuedaPagarCuotaNicho() {  
			//el cementerio se encarga de depositar al difunto, segun la eleccion de la parcela
			//Si no se paga la cuota ese difunto se removerá de nicho a osario.
			Empleado nuevo = new Empleado("Marcos", "Paz", 27654123);
			Cementerio chacarita = new Cementerio("Chacarita");
			nuevo.setCodigoPersonal(1);
			chacarita.cargarEmpleado(nuevo);
			chacarita.abrirElCementerio();
			
			Cliente pablo = new Cliente("Pablo", "Gomez", 37987589);
			
			Difunto familiar = new Difunto("Ximena", "Estevez", 10834345, "06/09/1926", "06/11/2020");
			pablo.setDifunto(familiar);
			
			Boolean enterro = chacarita.depositarEnNichoUnDifunto(pablo);
			
			//Comienza Verificación de Pago de Cuota
			
			Nicho nicho1 = new Nicho(1);
			
			nicho1.cargarOcupante(familiar);
			
			pablo.setDinero(200);
			
			Boolean pagar = pablo.pagarCuotaNicho(nicho1);
			
			assertTrue(pagar);
		}
		
		@Test
		public void testQueSePuedaPagarCuotaTierra() {  
			//el cementerio se encarga de depositar al difunto, segun la eleccion de la parcela
			//Si no se paga la cuota ese difunto se removerá de nicho a osario.
			Empleado nuevo = new Empleado("Marcos", "Paz", 27654123);
			Cementerio chacarita = new Cementerio("Chacarita");
			nuevo.setCodigoPersonal(1);
			chacarita.cargarEmpleado(nuevo);
			chacarita.abrirElCementerio();
			
			Cliente hugo = new Cliente("Hugo", "Jimenez", 37987562);
			
			Difunto familiar = new Difunto("Pablo", "Jimenez", 10876345, "12/08/1920", "06/11/2020");
			hugo.setDifunto(familiar);
			
			Boolean enterro = chacarita.enterrarDifunto(hugo);
			
			//Comienza Verificación de Pago de Cuota
			
			Tierra tierraN = new Tierra(1);
			
			tierraN.cargarOcupante(familiar);
			
			hugo.setDinero(1000); 
			
			hugo.pagarCuotaTierra(tierraN); //Hacemos otro pago anterior para verificar que funcione bien
											//El Costo de cada pago de Tierra es 500
											//agregadoparatestear
			Boolean pagar = hugo.pagarCuotaTierra(tierraN);
			
			assertTrue(pagar);
		}
		
		
		
		
		

	}
