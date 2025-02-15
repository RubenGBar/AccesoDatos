package clasesManipulacion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Accesobd {

    public SessionFactory sf;
    public static Session sesion;
    public static Transaction transaction;

    protected void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // por defecto: hibernate.cfg.xml
                .build();
        try {
            sf = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public void abrir() throws Exception {
        setUp();
        sesion=sf.openSession();
        transaction = sesion.beginTransaction();
    }

    public void cerrar(){
        try {
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }
        sf.close();
    }

    public void guardar(Object cosa) {
        sesion.persist(cosa);
    }

}
