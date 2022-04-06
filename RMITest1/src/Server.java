import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.function.Function;

public class Server extends UnicastRemoteObject implements MyRemote {

    public Server() throws RemoteException {
        System.out.println("constructor: Server");
    }

    @Override
    public double calculateSquareRoot(double x) {
        return Math.sqrt(x);
    }

    public static void main(String[] args) {
        try {
            MyRemote server = new Server();

            // mode 1: create registry and register the service name
            Registry reg = LocateRegistry.createRegistry(MyRemote.port);
            reg.rebind(MyRemote.serviceName, server);

            // mode 2: use the global registry
            // 'rmiregistry' program must be running in the background on your machine
            //Naming.rebind(MyRemoteService.rmiURI, server);

            System.out.printf("server is up:\n%s\n", reg.lookup(MyRemote.serviceName)); // MyRemoteService.rmiURI);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}





















