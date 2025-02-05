package clasesManipulacion;

import Colores.Colores;

import java.util.Scanner;

public class Principal {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int opc = -1;

        do {

            menu();
            System.out.println("Elija una opción");
            opc = sc.nextInt();

            switch(opc) {

                case 1 :{



                    break;
                }

                case 2 :{



                    break;
                }

                case 3 :{



                    break;
                }

                case 4 :{



                    break;
                }

                case 0 :{

                    System.out.println("Saliendo del programa");

                    break;
                }

                default :{

                    System.out.println("Opción no válida");

                    break;
                }

            }

        }while (opc != 0);

        sc.close();

    }

    public static void menu() {
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|     Menú     |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1." + Colores.blanco + "Crear Tablas");
        System.out.println(Colores.amarillo + "2." + Colores.blanco + "Insertar Datos");
        System.out.println(Colores.amarillo + "3." + Colores.blanco + "Listar Datos");
        System.out.println(Colores.amarillo + "4." + Colores.blanco + "Modificar Datos");
        System.out.println(Colores.amarillo + "5." + Colores.blanco + "Borrar Datos");
        System.out.println(Colores.amarillo + "6." + Colores.blanco + "Eliminar Tablas");
        System.out.println(Colores.rojo + "0." + Colores.blanco + "Salir");
    }

}
