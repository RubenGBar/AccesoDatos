package actividad3_1;

public class SubMenuConsultasPedidos {
	
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
					
					ConsultasPedidos.listadoPedidos(CRUD.conn);
				}
				
				case 2 ->{
					
					System.out.println("¿Por qué ID quieres buscar?");
					id = CRUD.sc.nextInt();
					ConsultasPedidos.listadoPedidosPorId(CRUD.conn, id);
				}
				
				case 3 ->{
					
					System.out.println("¿Por qué ID de Factura asociado quieres buscar?");
					id = CRUD.sc.nextInt();
					ConsultasPedidos.listadoPedidosPorIdFactura(CRUD.conn, id);
				}
				
				case 4 ->{
					
					System.out.println("¿Por qué ID de Producto asociado quieres buscar?");
					id = CRUD.sc.nextInt();
					ConsultasPedidos.listadoPedidosPorIdProducto(CRUD.conn, id);
				}
				case 5 ->{
					
					System.out.println("¿Por qué cantidad del pedido quiere listar?");
					cantidad = CRUD.sc.nextInt();
					ConsultasPedidos.listadoPedidosPorCantidad(CRUD.conn, cantidad);
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

}
