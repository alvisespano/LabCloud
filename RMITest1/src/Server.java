import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RemoteService {

    public Server() throws RemoteException {
        System.out.println("constructor: Server");
    }

    @Override
    public double calculateSquareRoot(double x) {
        return Math.sqrt(x);
    }

    @Override
    public int getPersonAge(Person p) {
        return p.getAge();
    }

    @Override
    public <P extends Person> P makeOlder(P p, int amount) throws RemoteException {
        // side effect
        p.setAge(p.getAge() + amount);
        return p;

        // create a new object
        //return new Person(p.getName(), p.getSurname(), p.getAddress(), p.getAge() + amount);
    }

    public static void main(String[] args) {
        try {
            RemoteService server = new Server();
            Registry reg = LocateRegistry.createRegistry(RemoteService.port);
            // register the service name
            reg.rebind(RemoteService.serviceName, server);
            // or globally
//            Naming.rebind(RemoteService.rmiURI, server);
            System.out.println("server up @ " + RemoteService.rmiURI);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }



    /*public static class NegServer extends Server {
        public NegServer() throws RemoteException {
            System.out.println("constructor: NegServer");
        }

        @Override
        public double calculateSquareRoot(double x) {
            return -Math.sqrt(x);
        }

    }*/
}





















