import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.util.function.Function;

public class Client {

    public static void main(String[] args) {
        try {
            MyRemote srv = (MyRemote) Naming.lookup(MyRemote.rmiURI);

            if (args.length != 1) {
                usage();
            }
            else {
                double x = Double.parseDouble(args[0]);
                System.out.printf("sqrt(%g) = %g\n", x, srv.calculateSquareRoot(x));
            }
        } catch (NotBoundException | RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void usage() {
        System.out.printf("USAGE: java %s <FLOAT>\n\n", Client.class.getName());
    }
}
