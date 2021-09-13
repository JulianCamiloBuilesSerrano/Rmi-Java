
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server {
    private static final int port = 1100;

    public static void main(String[] args)
            throws RemoteException, AlreadyBoundException, java.rmi.AlreadyBoundException {
        System.setProperty("java.rmi.server.hostname", "25.5.97.125");
        Remote remote = UnicastRemoteObject.exportObject(new IOferta() {

            @Override
            public String CrearOferta(Oferta o, String ip) throws RemoteException {
                System.out.println("la ip "+ ip +" creo una oferta");
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("bd.dat"));
                    oos.writeObject(o);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return "crear Oferta";

            }

            @Override
            public ArrayList<Oferta> MostrarOfertas(String ip) throws RemoteException {
                System.out.println("la ip "+ ip +" solicito lista de ofertas");
                ArrayList<Oferta> lista = new ArrayList<Oferta>();
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bd.dat"));
                    Object aux = ois.readObject();
                    while (aux != null) {
                        if (aux instanceof Oferta)
                            lista.add((Oferta) aux);
                        aux = ois.readObject();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return lista;
            }

            @Override
            public void xd() throws RemoteException {
               System.out.println("entra");
                
            }

        }, 0);
        Registry registry = LocateRegistry.createRegistry(port);
        System.out.println("Se escucha en el puerto: " + port);
        registry.bind("oferta", remote);
    }

}
