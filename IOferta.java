import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOferta extends Remote{

    public String CrearOferta() throws RemoteException;

    public String MostrarOfertas() throws RemoteException;

}