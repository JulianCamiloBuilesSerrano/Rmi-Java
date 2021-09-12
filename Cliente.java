import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static final String ip = "25.86.45.96";
    public static final int port = 1100;
    public static void main(String[] scr) throws RemoteException, NotBoundException{
        Registry registry = LocateRegistry.getRegistry(ip,port);
        IOferta oferta = (IOferta) registry.lookup("oferta");
        oferta.CrearOferta();



    }
}
