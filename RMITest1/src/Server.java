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

    @Override
    public int getPersonAge(Person p) {
        return p.getAge();
    }

    @Override
    public <P extends Person> P makeOlder(P p, int amount) throws RemoteException {
        // sidefx
        p.setAge(p.getAge() + amount);
        return p;

        // no sidefx
        //return new P(p.getName(), p.getSurname(), p.getAddress(), p.getAge() + amount);
    }

    private int cnt;

    @Override
    public Function<Integer, Integer> getFunction(int y) throws RemoteException {
        return (x) -> {
            Server.this.cnt++;
            return x + y;
        };
    }

    public static void main(String[] args) {
        try {
            MyRemote server = new NegServer();

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





















