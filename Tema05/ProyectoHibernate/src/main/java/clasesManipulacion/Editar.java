package clasesManipulacion;

import Entidades.ENTMesa;

public class Editar {

    public static Accesobd instancia = new Accesobd();

    public static void actualizarMesa(int id, ENTMesa mesa) throws Exception {
        instancia.abrir();
        ENTMesa mes = Accesobd.sesion.get(ENTMesa.class, id);
        mes.setReserva(mesa.getReserva());
        mes.setNumComensales(mesa.getNumComensales());
        //Accesobd.sesion.update(mes);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

}
