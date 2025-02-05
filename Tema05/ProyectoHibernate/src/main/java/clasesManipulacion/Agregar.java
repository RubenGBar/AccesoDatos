package clasesManipulacion;

import Entidades.ENTMesa;

public class Agregar {

    public static Accesobd instancia = new Accesobd();

    public static void guardarMesa(ENTMesa mesa) throws Exception {
        instancia.abrir();
        Accesobd.sesion.persist(mesa);
        Accesobd.sesion.close();
    }

}
