import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements SquareRoot {

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
    public Person makeOlder(Person p, int amount) throws RemoteException {
        // side effect
        //p.setAge(p.getAge() + amount);
        //return p;

        // create a new object
        return new Person(p.getName(), p.getSurname(), p.getAddress(), p.getAge() + amount);
    }

    public static void main(String[] args) {
        try {
            SquareRoot server = new Server();
            Naming.rebind(SquareRoot.name, server);
            System.out.println("server up");

        } catch (RemoteException | MalformedURLException e) {
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





















