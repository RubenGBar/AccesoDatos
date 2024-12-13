package actividad3_1;

public class SubMenuConsultasMesas {

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
					
					ConsultasMesa.listadoMesas(CRUD.conn);
				}
				
				case 2 ->{
					
					System.out.println("¿Por qué ID quieres buscar?");
					dato = CRUD.sc.nextInt();
					ConsultasMesa.listadoMesasPorId(CRUD.conn, dato);
				}
				
				case 3 ->{
					
					System.out.println("¿Por qué cantidad de comensales quieres buscar?");
					dato = CRUD.sc.nextInt();
					ConsultasMesa.listadoMesasPorId(CRUD.conn, dato);
				}
				
				case 4 ->{
					
					CRUD.sc.nextLine();
					System.out.println("Si quieres listar por los que han hecho reserva o no introduce: Si/No");
					reserva = CRUD.sc.nextLine();
					ConsultasMesa.listadoMesasPorReserva(CRUD.conn, reserva);
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

}
