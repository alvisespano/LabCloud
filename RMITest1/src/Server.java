import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;

public class Server extends UnicastRemoteObject implements MyRemote {

    public Server() throws RemoteException {
    }

    @Override
    public double calculateSquareRoot(double x) {
        double r = Math.sqrt(x);
        System.out.printf("calculateSquareRoot(%g) = %g\n", x, r);
        return r;
    }

    @Override
    public double calculatePythagorean(double a, double b) throws RemoteException {
        return Math.sqrt(a * a + b * b);
    }

    public static void main(String[] args) {
        try {
            Server server = new NegativeServer();

            // mode 1: create registry and register the service name
            Registry reg = LocateRegistry.createRegistry(5000);
            reg.rebind("sqrt", server);

            // mode 2: use the global registry
            // 'rmiregistry' program must be running in the background on your machine
            //Naming.rebind(MyRemoteService.rmiURI, server);

            System.out.printf("server is up...\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}





















