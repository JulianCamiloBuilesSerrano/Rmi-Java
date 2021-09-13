import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private static final String IP = "25.5.97.125";
    private static final int PUERTO = 1100;
    public static void main(String[] scr) throws RemoteException, NotBoundException{
        Registry registry = LocateRegistry.getRegistry(IP,PUERTO);
        System.out.println("pasa el ger registry"+ registry.getClass());
        IOferta oferta = (IOferta)registry.lookup("oferta");

        oferta.xd();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Registrar Oferta");
        System.out.println("2. ver ofertas");
        System.out.println("Digite la ocpion");
        int op =Integer.parseInt(sc.nextLine());
        if (op == 1){
            // se pregunta la informacion para crear el objeto de oferta
            Oferta of =  new Oferta();
            System.out.println("Digite el nombre  de la empresa");
            of.setEmpresa(sc.nextLine()); 
            System.out.println("Digite el titulo de la oferta");
            of.setTitulo(sc.nextLine());
            System.out.println("Digite el Salario de la oferta");
            of.setSalario(sc.nextLine());
            System.out.println("Digite la descripcion de la oferta");
            of.setDescription(sc.nextLine());
            System.out.println("Digite tipo de contrato de la oferta");
            of.setContrato(sc.nextLine());
            // hacemos uso de el objeto remoto para llamar 
            oferta.CrearOferta(of,"152.2.8.22");

        }else if (op == 2){
            ArrayList<Oferta> listaOfertas = new ArrayList<Oferta>();
            listaOfertas = oferta.MostrarOfertas("152.2.8.22");

            for (Oferta o : listaOfertas) {
                System.out.println("---------------");
                System.out.println(o.toString());
            }

        }
        
        
    }
}
