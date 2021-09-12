import java.nio.channels.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Server {
    public static final int port = 1100;
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, java.rmi.AlreadyBoundException{
        Remote remote =  UnicastRemoteObject.exportObject( new IOferta(){

            @Override
            public void CrearOferta() throws RemoteException {
                System.out.println("crear Oferta");
                
            }

            @Override
            public void MostrarOfertas() throws RemoteException {
                System.out.println("motrar ofertas");
                
            }
            
        }, 0);
        Registry registry = LocateRegistry.createRegistry(port);
        System.out.println("Se escucha en el puerto: " + port);
        registry.bind("oferta", remote);
    }
    
}
