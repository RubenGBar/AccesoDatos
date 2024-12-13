package actividad3_1;

public class SubMenuConsultasProductos {

	public static void menuListarProductos() {
		
		System.out.println(" --------------");
		System.out.println("|   Productos  |");
		System.out.println(" --------------");
		System.out.println("1. Listar Todo");
		System.out.println("2. Listar por ID");
		System.out.println("3. Listar por Denominacion");
		System.out.println("4. Listar por Precio");
		System.out.println("0. Salir");
		
	}

	public static void listarTablaProductos() {
		
		int opc = 0;
		int id = 0;
		double precio = 0;		
		String denominacion = "";
		
		do {
			
			menuListarProductos();
			System.out.println("Elija una opción: ");
			opc = CRUD.sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					
					ConsultasProductos.listadoProductos(CRUD.conn);
				}
				
				case 2 ->{
					
					System.out.println("¿Por qué ID quieres buscar?");
					id = CRUD.sc.nextInt();
					ConsultasProductos.listadoProductosPorId(CRUD.conn, id);
				}
				
				case 3 ->{
					
					CRUD.sc.nextLine();
					System.out.println("¿Por qué denominación de producto quieres buscar?");
					denominacion = CRUD.sc.nextLine();
					ConsultasProductos.listadoProductosPorDenominacion(CRUD.conn, denominacion);
				}
				
				case 4 ->{
					
					System.out.println("¿Por qué precio quieres buscar?");
					precio = CRUD.sc.nextDouble();
					ConsultasProductos.listadoProductosPorPrecio(CRUD.conn, precio);
				}
				case 0 ->{
					System.out.println("Saliendo del menú de listado de Productos");
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
	}

}
