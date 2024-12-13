package actividad3_1;

public class SubMenuConsultasFacturas {

	public static void menuListarFacturas() {
		
		System.out.println(" --------------");
		System.out.println("|   Facturas   |");
		System.out.println(" --------------");
		System.out.println("1. Listar Todo");
		System.out.println("2. Listar por ID");
		System.out.println("3. Listar por ID de Mesa");
		System.out.println("4. Listar por Tipo de Pago");
		System.out.println("5. Listar por Importe");
		System.out.println("0. Salir");
		
	}

	public static void listarTablaFacturas() {
		
		int opc = 0;
		int id = 0;
		double importe = 0;
		String tipoPago = "";
		
		do {
			
			menuListarFacturas();
			System.out.println("Elija una opción: ");
			opc = CRUD.sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					
					ConsultasFacturas.listadoFacturas(CRUD.conn);
				}
				
				case 2 ->{
					
					System.out.println("¿Por qué ID quieres buscar?");
					id = CRUD.sc.nextInt();
					ConsultasFacturas.listadoFacturasPorId(CRUD.conn, id);
				}
				
				case 3 ->{
					
					System.out.println("¿Por qué ID de Mesa asociado quieres buscar?");
					id = CRUD.sc.nextInt();
					ConsultasFacturas.listadoFacturasPorIdMesa(CRUD.conn, id);
				}
				
				case 4 ->{
					
					CRUD.sc.nextLine();
					System.out.println("¿Por qué tipo de pago quieres listar?");
					tipoPago = CRUD.sc.nextLine();
					ConsultasFacturas.listadoFacturasPorTipoPago(CRUD.conn, tipoPago);
				}
				case 5 ->{
					
					System.out.println("¿Por qué importe (dinero) quiere listar?");
					importe = CRUD.sc.nextDouble();
					ConsultasFacturas.listadoFacturasPorImporte(null, importe);
				}
				case 0 ->{
					System.out.println("Saliendo del menú de listado de Facturas");
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
	}
	
}
