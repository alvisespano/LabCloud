import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyRemote {

    private String storage;

    public Server() throws RemoteException {
        super();
    }

    @Override
    public double calculateSquareRoot(double x) throws RemoteException {
        double r = Math.sqrt(x);
        System.out.printf("calculateSquareRoot(%g) = %g\n", x, r);
        return r;
    }

    @Override
    public void store(String s) throws RemoteException {
        storage = s;
    }

    @Override
    public String retrieve() throws RemoteException {
        return storage;
    }


    public static void main(String[] args) {
        try {
            Server server = new Server();

            // mode 1: use the global registry
            // 'rmiregistry' program must be running in the background on your machine
            //Naming.rebind("rmi://localhost:5000/sqrt", server);

            // mode 2: create registry and register the service name
            Registry reg = LocateRegistry.createRegistry(5000);
            reg.rebind("sqrt", server);

            System.out.printf("server is up...\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}





















