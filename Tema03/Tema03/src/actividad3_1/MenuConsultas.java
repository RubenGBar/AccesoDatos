package actividad3_1;

public class MenuConsultas {

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
					
					Consultas.listadoFacturas(CRUD.conn);
				}
				
				case 2 ->{
					
					System.out.println("¿Por qué ID quieres buscar?");
					id = CRUD.sc.nextInt();
					Consultas.listadoFacturasPorId(CRUD.conn, id);
				}
				
				case 3 ->{
					
					System.out.println("¿Por qué ID de Mesa asociado quieres buscar?");
					id = CRUD.sc.nextInt();
					Consultas.listadoFacturasPorIdMesa(CRUD.conn, id);
				}
				
				case 4 ->{
					
					CRUD.sc.nextLine();
					System.out.println("¿Por qué tipo de pago quiere listar?");
					tipoPago = CRUD.sc.nextLine();
					Consultas.listadoFacturasPorTipoPago(CRUD.conn, tipoPago);
				}
				case 5 ->{
					
					System.out.println("¿Por qué importe (dinero) quiere listar?");
					importe = CRUD.sc.nextDouble();
					Consultas.listadoFacturasPorImporte(CRUD.conn, importe);
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

	public static void menuListarMesas() {
		
		System.out.println(" --------------");
		System.out.println("|     Mesas    |");
		System.out.println(" --------------");
		System.out.println("1. Listar Todo");
		System.out.println("2. Listar por ID");
		System.out.println("3. Listar por Comensales");
		System.out.println("4. Listar por Reserva");
		System.out.println("0. Salir");
		
	}

	public static void listarTablaMesas() {
		
		int opc = 0;
		int dato = 0;
		String reserva = "";
		
		do {
			
			menuListarMesas();
			System.out.println("Elija una opción: ");
			opc = CRUD.sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					
					Consultas.listadoMesas(CRUD.conn);
				}
				
				case 2 ->{
					
					System.out.println("¿Por qué ID quieres buscar?");
					dato = CRUD.sc.nextInt();
					Consultas.listadoMesasPorId(CRUD.conn, dato);
				}
				
				case 3 ->{
					
					System.out.println("¿Por qué cantidad de comensales quieres buscar?");
					dato = CRUD.sc.nextInt();
					Consultas.listadoMesasPorComensales(CRUD.conn, dato);
				}
				
				case 4 ->{
					
					CRUD.sc.nextLine();
					System.out.println("Si quieres listar por los que han hecho reserva o no introduce: Si/No");
					reserva = CRUD.sc.nextLine();
					Consultas.listadoMesasPorReserva(CRUD.conn, reserva);
				}
				case 0 ->{
					System.out.println("Saliendo del menú de listado de Mesas");
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
	}

	public static void menuListarPedidos() {
		
		System.out.println(" --------------");
		System.out.println("|   Pedidos    |");
		System.out.println(" --------------");
		System.out.println("1. Listar Todo");
		System.out.println("2. Listar por ID");
		System.out.println("3. Listar por ID de Factura");
		System.out.println("4. Listar por ID de Producto");
		System.out.println("5. Listar por Cantidad");
		System.out.println("0. Salir");
		
	}

	public static void listarTablaPedidos() {
		
		int opc = 0;
		int id = 0;
		int cantidad = 0;
		
		do {
			
			menuListarPedidos();
			System.out.println("Elija una opción: ");
			opc = CRUD.sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					
					Consultas.listadoPedidos(CRUD.conn);
				}
				
				case 2 ->{
					
					System.out.println("¿Por qué ID quieres buscar?");
					id = CRUD.sc.nextInt();
					Consultas.listadoPedidosPorId(CRUD.conn, id);
				}
				
				case 3 ->{
					
					System.out.println("¿Por qué ID de Factura asociado quieres buscar?");
					id = CRUD.sc.nextInt();
					Consultas.listadoPedidosPorIdFactura(CRUD.conn, id);
				}
				
				case 4 ->{
					
					System.out.println("¿Por qué ID de Producto asociado quieres buscar?");
					id = CRUD.sc.nextInt();
					Consultas.listadoPedidosPorIdProducto(CRUD.conn, id);
				}
				case 5 ->{
					
					System.out.println("¿Por qué cantidad del pedido quiere listar?");
					cantidad = CRUD.sc.nextInt();
					Consultas.listadoPedidosPorCantidad(CRUD.conn, cantidad);
				}
				case 0 ->{
					System.out.println("Saliendo del menú de listado de Pedidos");
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
	}

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
					
					Consultas.listadoProductos(CRUD.conn);
				}
				
				case 2 ->{
					
					System.out.println("¿Por qué ID quieres buscar?");
					id = CRUD.sc.nextInt();
					Consultas.listadoProductosPorId(CRUD.conn, id);
				}
				
				case 3 ->{
					
					CRUD.sc.nextLine();
					System.out.println("¿Por qué denominación de producto quieres buscar?");
					denominacion = CRUD.sc.nextLine();
					Consultas.listadoProductosPorDenominacion(CRUD.conn, denominacion);
				}
				
				case 4 ->{
					
					System.out.println("¿Por qué precio quieres buscar?");
					precio = CRUD.sc.nextDouble();
					Consultas.listadoProductosPorPrecio(CRUD.conn, precio);
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
