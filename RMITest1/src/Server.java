import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyRemoteService {

    public Server() throws RemoteException {
        System.out.println("constructor: Server");
    }

    public void foo() {}

    @Override
    public double calculateSquareRoot(double x) {
        return Math.sqrt(x);
    }

//    @Override
//    public int getPersonAge(Person p) {
//        return p.getAge();
//    }
//
//    @Override
//    public <P extends Person> P makeOlder(P p, int amount) throws RemoteException {
//        // side effect
//        p.setAge(p.getAge() + amount);
//        return p;
//
//        // create a new object
//        //return new Person(p.getName(), p.getSurname(), p.getAddress(), p.getAge() + amount);
//    }

    public static void main(String[] args) {
        try {
            MyRemoteService server = new Server();

            // create registry and register the service name
            //Registry reg = LocateRegistry.createRegistry(MyRemoteService.port);
            //reg.rebind(MyRemoteService.serviceName, server);

            // or globally
            Naming.rebind(MyRemoteService.rmiURI, server);

            System.out.println("server up @ " + MyRemoteService.rmiURI);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // example 1: NegServer specialization
    public static class NegServer extends Server {
        public NegServer() throws RemoteException {
            System.out.println("constructor: NegServer");
        }

        @Override
        public double calculateSquareRoot(double x) {
            return -Math.sqrt(x);
        }

    }
}





















