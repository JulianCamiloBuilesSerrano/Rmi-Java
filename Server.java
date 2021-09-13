import java.nio.channels.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Server {
    public static final int port = 1100;
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, java.rmi.AlreadyBoundException{
        System.setProperty("java.rmi.server.hostname", "25.86.45.96");
        Remote remote =  UnicastRemoteObject.exportObject( new IOferta(){

            @Override
            public String CrearOferta() throws RemoteException {
                System.out.println("crear Oferta");
                return "crear Oferta";
                
            }

            @Override
            public String MostrarOfertas() throws RemoteException {
                System.out.println("motrar ofertas");
                return "motrar ofertas";
                
            }
            
        }, 0);
        Registry registry = LocateRegistry.createRegistry(port);
        System.out.println("Se escucha en el puerto: " + port);
        registry.bind("oferta", remote);
    }
    
}
