import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemoteService extends Remote {
    // static nested constants
    String serviceName = "sqrt";
    String address = "localhost";
    int port = 5000;
    String rmiURI = String.format("rmi://%s:%d/%s", address, port, serviceName);

    // example 1
    double calculateSquareRoot(double x) throws RemoteException;

    // example 2
    int getPersonAge(Person p) throws RemoteException;
    <P extends Person> P makeOlder(P p, int amount) throws RemoteException;

}