import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteService extends Remote {
    String serviceName = "sqrt";
    String address = "localhost";
    int port = 5000;
    String rmiURI = String.format("rmi://%s:%d/%s", address, port, serviceName);

    double calculateSquareRoot(double x) throws RemoteException;

    int getPersonAge(Person p) throws RemoteException;

    //Person makeOlder(Person p, int amount) throws RemoteException;

    <P extends Person> P makeOlder(P p, int amount) throws RemoteException;

}