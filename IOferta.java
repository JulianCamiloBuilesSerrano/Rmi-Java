import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IOferta extends Remote{

    public String CrearOferta(Oferta o, String ip) throws RemoteException;

    public ArrayList<Oferta> MostrarOfertas(String ip) throws RemoteException;

}