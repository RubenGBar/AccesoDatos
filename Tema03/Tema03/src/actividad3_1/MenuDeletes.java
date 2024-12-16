package actividad3_1;

public class MenuDeletes {
	
	public static void menuBorrarFacturas() {
		
		System.out.println(" --------------");
		System.out.println("|   Facturas   |");
		System.out.println(" --------------");
		System.out.println("1. Borrar Todo");
		System.out.println("2. Borrar por ID");
		System.out.println("3. Borrar por ID de Mesa");
		System.out.println("4. Borrar por Tipo de Pago");
		System.out.println("5. Borrar por Importe");
		System.out.println("0. Salir");
		
	}

	public static void borrarTablaFacturas() {
		
		int opc = 0;
		int id = 0;
		double importe = 0;
		String tipoPago = "";
		
		do {
			
			menuBorrarFacturas();
			System.out.println("Elija una opción: ");
			opc = CRUD.sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					
					Consultas.listadoFacturas(CRUD.conn);
					CRUD.sc.nextLine();
					Deletes.borradoFacturas(CRUD.conn);
				}
				
				case 2 ->{
					
					Consultas.listadoFacturas(CRUD.conn);
					System.out.println("¿Por qué ID quieres borrar?");
					id = CRUD.sc.nextInt();
					CRUD.sc.nextLine();
					Deletes.borradoFacturasPorId(CRUD.conn, id);
				}
				
				case 3 ->{
					
					Consultas.listadoFacturas(CRUD.conn);
					System.out.println("¿Por qué ID de Mesa asociado quieres borrar?");
					id = CRUD.sc.nextInt();
					CRUD.sc.nextLine();
					Deletes.borradoFacturasPorIdMesa(CRUD.conn, id);
				}
				
				case 4 ->{
					
					Consultas.listadoFacturas(CRUD.conn);
					CRUD.sc.nextLine();
					System.out.println("¿Por qué tipo de pago quiere borrar?");
					tipoPago = CRUD.sc.nextLine();
					Deletes.borradoFacturasPorTipoPago(CRUD.conn, tipoPago);
				}
				case 5 ->{
					
					Consultas.listadoFacturas(CRUD.conn);
					System.out.println("¿Por qué importe (dinero) quiere borrar?");
					importe = CRUD.sc.nextDouble();
					CRUD.sc.nextLine();
					Deletes.borradoFacturasPorImporte(CRUD.conn, importe);
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

	public static void menuBorrarMesas() {
		
		System.out.println(" --------------");
		System.out.println("|     Mesas    |");
		System.out.println(" --------------");
		System.out.println("1. Borrar Todo");
		System.out.println("2. Borrar por ID");
		System.out.println("3. Borrar por Comensales");
		System.out.println("4. Borrar por Reserva");
		System.out.println("0. Salir");
		
	}

	public static void borrarTablaMesas() {
		
		int opc = 0;
		int dato = 0;
		String reserva = "";
		
		do {
			
			menuBorrarMesas();
			System.out.println("Elija una opción: ");
			opc = CRUD.sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					
					Consultas.listadoMesas(CRUD.conn);
					CRUD.sc.nextLine();
					Deletes.borradoMesas(CRUD.conn);
				}
				
				case 2 ->{
					
					Consultas.listadoMesas(CRUD.conn);
					System.out.println("¿Por qué ID quieres borrar?");
					dato = CRUD.sc.nextInt();
					CRUD.sc.nextLine();
					Deletes.borradoMesasPorId(CRUD.conn, dato);
				}
				
				case 3 ->{
					
					Consultas.listadoMesas(CRUD.conn);
					System.out.println("¿Por qué cantidad de comensales quieres borrar?");
					dato = CRUD.sc.nextInt();
					CRUD.sc.nextLine();
					Deletes.borradoMesasPorComensales(CRUD.conn, dato);
				}
				
				case 4 ->{
					
					Consultas.listadoMesas(CRUD.conn);
					CRUD.sc.nextLine();
					System.out.println("Si quieres borrar por los que han hecho reserva o no introduce: Si/No");
					reserva = CRUD.sc.nextLine();
					Deletes.borradoMesasPorReserva(CRUD.conn, reserva);
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

	public static void menuBorrarPedidos() {
		
		System.out.println(" --------------");
		System.out.println("|   Pedidos    |");
		System.out.println(" --------------");
		System.out.println("1. Borrar Todo");
		System.out.println("2. Borrar por ID");
		System.out.println("3. Borrar por ID de Factura");
		System.out.println("4. Borrar por ID de Producto");
		System.out.println("5. Borrar por Cantidad");
		System.out.println("0. Salir");
		
	}

	public static void borrarTablaPedidos() {
		
		int opc = 0;
		int id = 0;
		int cantidad = 0;
		
		do {
			
			menuBorrarPedidos();
			System.out.println("Elija una opción: ");
			opc = CRUD.sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					
					Consultas.listadoPedidos(CRUD.conn);
					CRUD.sc.nextLine();
					Deletes.borradoPedidos(CRUD.conn);
				}
				
				case 2 ->{
					
					Consultas.listadoPedidos(CRUD.conn);
					System.out.println("¿Por qué ID quieres borrar?");
					id = CRUD.sc.nextInt();
					CRUD.sc.nextLine();
					Deletes.borradoPedidosPorId(CRUD.conn, id);
				}
				
				case 3 ->{
					
					Consultas.listadoPedidos(CRUD.conn);
					System.out.println("¿Por qué ID de Factura asociado quieres borrar?");
					id = CRUD.sc.nextInt();
					CRUD.sc.nextLine();
					Deletes.borradoPedidosPorIdFactura(CRUD.conn, id);
				}
				
				case 4 ->{
					
					Consultas.listadoPedidos(CRUD.conn);
					System.out.println("¿Por qué ID de Producto asociado quieres borrar?");
					id = CRUD.sc.nextInt();
					CRUD.sc.nextLine();
					Deletes.borradoPedidosPorIdProducto(CRUD.conn, id);
				}
				case 5 ->{
					
					Consultas.listadoPedidos(CRUD.conn);
					System.out.println("¿Por qué cantidad del pedido quiere borrar?");
					cantidad = CRUD.sc.nextInt();
					CRUD.sc.nextLine();
					Deletes.borradoPedidosPorCantidad(CRUD.conn, cantidad);
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

	public static void menuBorrarProductos() {
		
		System.out.println(" --------------");
		System.out.println("|   Productos  |");
		System.out.println(" --------------");
		System.out.println("1. Borrar Todo");
		System.out.println("2. Borrar por ID");
		System.out.println("3. Borrar por Denominacion");
		System.out.println("4. Borrar por Precio");
		System.out.println("0. Salir");
		
	}

	public static void borrarTablaProductos() {
		
		int opc = 0;
		int id = 0;
		double precio = 0;		
		String denominacion = "";
		
		do {
			
			menuBorrarProductos();
			System.out.println("Elija una opción: ");
			opc = CRUD.sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					
					Consultas.listadoProductos(CRUD.conn);
					CRUD.sc.nextLine();
					Deletes.borradoProductos(CRUD.conn);
				}
				
				case 2 ->{
					
					Consultas.listadoProductos(CRUD.conn);
					System.out.println("¿Por qué ID quieres borrar?");
					id = CRUD.sc.nextInt();
					CRUD.sc.nextLine();
					Deletes.borradoProductosPorId(CRUD.conn, id);
				}
				
				case 3 ->{
					
					Consultas.listadoProductos(CRUD.conn);
					CRUD.sc.nextLine();
					System.out.println("¿Por qué denominación de producto quieres borrar?");
					denominacion = CRUD.sc.nextLine();
					Deletes.borradoProductosPorDenominacion(CRUD.conn, denominacion);
				}
				
				case 4 ->{
					
					Consultas.listadoProductos(CRUD.conn);
					System.out.println("¿Por qué precio quieres borrar?");
					precio = CRUD.sc.nextDouble();
					CRUD.sc.nextLine();
					Deletes.borradoProductosPorPrecio(CRUD.conn, precio);
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
