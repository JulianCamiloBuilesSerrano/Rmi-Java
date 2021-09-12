import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOferta extends Remote{
    public void CrearOferta() throws RemoteException;

    public void MostrarOfertas() throws RemoteException;

}