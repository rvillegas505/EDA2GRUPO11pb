package test;

import static org.junit.Assert.*;

import org.junit.Test;



	import cementerio.Cementerio;
	import cementerio.Cliente;
	import cementerio.Difunto;
	import cementerio.Empleado;
	import cementerio.Nicho;
	import cementerio.Tierra;
        import cementerio.Osario;

	public class TestCementerio {
		
        @Test
	public void testQueSeCargeUnEmpleadoAlCementerio() {
	// Se carga un empleado al cementerio, el empleado no deberia ser cargado sin codigo de personal.
		Empleado nuevo = new Empleado("Marcos", "Paz", 27654123);
		Cementerio chacarita = new Cementerio("Chacarita");
		
		nuevo.setCodigoPersonal(1);
		
		Boolean cargado = chacarita.cargarEmpleado(nuevo);
		
		assertTrue(cargado);
		
	}
	@Test
	public void testQueSeAbraElCementerio() {
		//Abrir el cementerio, no se deberia abrir sin un empleado
		Empleado nuevo = new Empleado("Marcos", "Paz", 27654123);
		Cementerio chacarita = new Cementerio("Chacarita");
		
		nuevo.setCodigoPersonal(1);
		chacarita.cargarEmpleado(nuevo);
		
		Boolean abrir = chacarita.abrirElCementerio();
		
		assertTrue(abrir);
	}
		
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
	public void testQueUnNuevoClienteTengaUnDifunto() {
		Empleado nuevo = new Empleado("Marcos", "Paz", 27654123);
		Cementerio chacarita = new Cementerio("Chacarita");
		
		nuevo.setCodigoPersonal(1);
		chacarita.cargarEmpleado(nuevo);
		chacarita.abrirElCementerio();
		
		Cliente hugo = new Cliente("Hugo", "Jimenez", 37987562);
		Difunto familiar = new Difunto("Pablo", "Jimenez", 10876345, "12/08/1920", "06/11/2020");
		hugo.setDifunto(familiar);
		
		Difunto a1 = hugo.entregarDifunto();
		
		assertNotNull(a1);
	}
	
	@Test
	public void testQueSeEntierreUnDifunto() {
		//el cementerio se encarga de enterrar al difunto, segun la eleccion de la parcela
		Empleado nuevo = new Empleado("Marcos", "Paz", 27654123);
		Cementerio chacarita = new Cementerio("Chacarita");
		nuevo.setCodigoPersonal(1);
		chacarita.cargarEmpleado(nuevo);
		chacarita.abrirElCementerio();
		
		Cliente hugo = new Cliente("Hugo", "Jimenez", 37987562);
		
		Difunto familiar = new Difunto("Pablo", "Jimenez", 10876345, "12/08/1920", "06/11/2020");
		hugo.setDifunto(familiar);
		
		Boolean enterro = chacarita.enterrarDifunto(hugo);
		
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
		
		@Test
		public void testQueBusqueUnDifuntoEnNicho() {
		Empleado nuevo = new Empleado("Marcos", "Paz", 27654123);
		Cementerio chacarita = new Cementerio("Chacarita");
		nuevo.setCodigoPersonal(1);
		chacarita.cargarEmpleado(nuevo);
		chacarita.abrirElCementerio();
		
		Cliente miCliente = new Cliente("Jose", "Lopez", 32456765);
		
		Difunto miDifunto = new Difunto("Carlos", "Gardel", 23423456, "06/05/1900", "05/09/1965");
		miCliente.setDifunto(miDifunto);
	
		
		Nicho nicho = new Nicho(20);
		
		nicho.cargarOcupante(miDifunto);
		
		
		Integer dni = 23423456;
		Difunto buscar = nicho.buscarDifunto(miDifunto);
		assertEquals(dni, buscar.getDni());
	}
	
		@Test
		public void testQueMuestreLaCantidadDeDifuntosQueSeEncuentrenEnNicho() {
		Empleado nuevo = new Empleado("Roberto", "Lopez", 23543224);
		Cementerio chacarita = new Cementerio("Chacarita");
		nuevo.setCodigoPersonal(1);
		chacarita.cargarEmpleado(nuevo);
		chacarita.abrirElCementerio();
		
		Cliente miCliente = new Cliente("Marcos", "Diaz", 12446765);
		
		Difunto miDifunto = new Difunto("Jose", "San Martin", 3423456, "06/05/1800", "05/09/1859");
		miCliente.setDifunto(miDifunto);
		
		Cliente miCliente2 = new Cliente("Antonio", "Gonzalez", 24678999);
		
		Difunto miDifunto2 = new Difunto("Pablo", "Fernandez", 13423456, "06/05/1900", "05/09/1965");
		miCliente2.setDifunto(miDifunto2);
		
		Nicho nicho = new Nicho(23);
		nicho.cargarOcupante(miDifunto);
		nicho.cargarOcupante(miDifunto2);
		
		Integer valorEsperado = 2;
		Integer valorObtenido = nicho.contarCantidadDifuntosEnNicho();
		assertEquals(valorEsperado, valorObtenido);
	}
		
		@Test
	public void testQueBusqueUnDifuntoEnOsario() {
		Empleado nuevo = new Empleado("Marcos", "Paz", 27654123);
		Cementerio chacarita = new Cementerio("Chacarita");
		nuevo.setCodigoPersonal(1);
		chacarita.cargarEmpleado(nuevo);
		chacarita.abrirElCementerio();
		
		Cliente miCliente = new Cliente("Jose", "Lopez", 32456765);
		
		Difunto miDifunto = new Difunto("Carlos", "Gardel", 23423456, "06/05/1900", "05/09/1965");
		miCliente.setDifunto(miDifunto);
	
		
		Osario osario = new Osario(20);
		
		osario.cargarOcupante(miDifunto);
		
		
		Integer dni = 23423456;
		Difunto buscar = osario.buscarDifunto(miDifunto);
		assertEquals(dni, buscar.getDni());
	}
	
	@Test
	public void testQueMuestreLaCantidadDeDifuntosQueSeEncuentrenEnOsario() {
		Empleado nuevo = new Empleado("Roberto", "Lopez", 23543224);
		Cementerio chacarita = new Cementerio("Chacarita");
		nuevo.setCodigoPersonal(1);
		chacarita.cargarEmpleado(nuevo);
		chacarita.abrirElCementerio();
		
		Cliente miCliente = new Cliente("Marcos", "Diaz", 12446765);
		
		Difunto miDifunto = new Difunto("Jose", "San Martin", 3423456, "06/05/1800", "05/09/1859");
		miCliente.setDifunto(miDifunto);
		
		Cliente miCliente2 = new Cliente("Antonio", "Gonzalez", 24678999);
		
		Difunto miDifunto2 = new Difunto("Pablo", "Fernandez", 13423456, "06/05/1900", "05/09/1965");
		miCliente2.setDifunto(miDifunto2);
		
		Osario osario = new Osario(23);
		osario.cargarOcupante(miDifunto);
		osario.cargarOcupante(miDifunto2);
		
		Integer valorEsperado = 2;
		Integer valorObtenido = osario.contarCantidadDifuntosEnOsario();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void testQueSePuedaPasarDeTierraAOsario() {  
		//el cementerio se encarga de pasar los difuntos, de tierra a osario
		Empleado nuevo = new Empleado("Marcos", "Paz", 27654123);
		Cementerio chacarita = new Cementerio("Chacarita");
		nuevo.setCodigoPersonal(1);
		chacarita.cargarEmpleado(nuevo);
		chacarita.abrirElCementerio();
		
		Cliente hugo = new Cliente("Hugo", "Jimenez", 37987562);
		
		Cliente pedro = new Cliente("Pedro", "Porcel", 37987512);
		
		Difunto familiar2 = new Difunto("Carlos", "Porcel", 10476345, "18/05/1924", "06/11/2020");
		pedro.setDifunto(familiar2);
		
		Difunto familiar = new Difunto("Pablo", "Jimenez", 10876345, "12/08/1920", "18/02/2018");
		hugo.setDifunto(familiar);
		
		Cliente marcos = new Cliente("Marcos", "Gomez", 37987589);
		Cliente jose = new Cliente("Jose", "Gomez", 37957589);
		Difunto familiar4 = new Difunto("Raul", "Gomez", 20834345, "01/01/1929", "01/01/2020");
		Difunto familiar3 = new Difunto("Ximena", "Estevez", 10834345, "06/09/1926", "04/12/2019");
		marcos.setDifunto(familiar3);
		jose.setDifunto(familiar4);
		
		chacarita.depositarEnOsario(marcos);
		chacarita.depositarEnNichoUnDifunto(jose);
		chacarita.enterrarDifunto(hugo);
		chacarita.enterrarDifunto(pedro);
		
		Boolean exito = chacarita.pasajeDeTierraAOsario(familiar);
		
		
		
		assertTrue(exito);
		
	}
	@Test
	public void testQueSePuedaPasarDeNichoAOsario() {  
		//el cementerio se encarga de pasar los difuntos, de nicho a osario
		Empleado nuevo = new Empleado("Marcos", "Paz", 27654123);
		Cementerio chacarita = new Cementerio("Chacarita");
		nuevo.setCodigoPersonal(1);
		chacarita.cargarEmpleado(nuevo);
		chacarita.abrirElCementerio();
		
		Cliente hugo = new Cliente("Hugo", "Jimenez", 37987562);
		
		Cliente pedro = new Cliente("Pedro", "Porcel", 37987512);
		
		Difunto familiar2 = new Difunto("Carlos", "Porcel", 10476345, "18/05/1924", "06/11/2020");
		pedro.setDifunto(familiar2);
		
		Difunto familiar = new Difunto("Pablo", "Jimenez", 10876345, "12/08/1920", "18/02/2018");
		hugo.setDifunto(familiar);
		
		Cliente marcos = new Cliente("Marcos", "Gomez", 37987589);
		Cliente jose = new Cliente("Jose", "Gomez", 37957589);
		Difunto familiar4 = new Difunto("Raul", "Gomez", 20834345, "01/01/1929", "01/01/2020");
		Difunto familiar3 = new Difunto("Ximena", "Estevez", 10834345, "06/09/1926", "04/12/2019");
		marcos.setDifunto(familiar3);
		jose.setDifunto(familiar4);
		
		chacarita.depositarEnOsario(marcos);
		chacarita.depositarEnNichoUnDifunto(jose);
		chacarita.enterrarDifunto(hugo);
		chacarita.enterrarDifunto(pedro);
		
		Boolean a = chacarita.pasajeDeNichoAOsario(familiar4);
		
		assertTrue(a);
		
		
	}
	
	@Test
	public void testQueSeVeaLaListaDeClientes() { 
				Empleado nuevo = new Empleado("Marcos", "Paz", 27654123);
				Cementerio chacarita = new Cementerio("Chacarita");
				nuevo.setCodigoPersonal(1);
				chacarita.cargarEmpleado(nuevo);
				chacarita.abrirElCementerio();
				
				Cliente hugo = new Cliente("Hugo", "Jimenez", 37987562);
				
				Cliente pedro = new Cliente("Pedro", "Porcel", 37987512);
				
				Difunto familiar2 = new Difunto("Carlos", "Porcel", 10476345, "18/05/1924", "06/11/2020");
				pedro.setDifunto(familiar2);
				
				Difunto familiar = new Difunto("Pablo", "Jimenez", 10876345, "12/08/1920", "18/02/2018");
				hugo.setDifunto(familiar);
				
				Cliente marcos = new Cliente("Marcos", "Gomez", 37987589);
				Cliente jose = new Cliente("Jose", "Gomez", 37957589);
				Difunto familiar4 = new Difunto("Raul", "Gomez", 20834345, "01/01/1929", "01/01/2020");
				Difunto familiar3 = new Difunto("Ximena", "Estevez", 10834345, "06/09/1926", "04/12/2019");
				marcos.setDifunto(familiar3);
				jose.setDifunto(familiar4);
				
				chacarita.cargarNuevoCliente(jose);
				chacarita.cargarNuevoCliente(marcos);
				chacarita.cargarNuevoCliente(pedro);
				chacarita.cargarNuevoCliente(hugo);
				
				chacarita.depositarEnOsario(marcos);
				chacarita.depositarEnNichoUnDifunto(jose);
				chacarita.enterrarDifunto(hugo);
				chacarita.enterrarDifunto(pedro);
				
				System.out.println(chacarita.verListaDeClientes());
	}
		
		

	}
