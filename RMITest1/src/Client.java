import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

public class Client {
    public static void main(String[] args) {
        if (args.length >= 1) {
            double x = Double.parseDouble(args[0]);

            try {
                SquareRoot squareServer = (SquareRoot) Naming.lookup(String.format("%s", SquareRoot.name));

                double result = squareServer.calculateSquareRoot(x);
                System.out.println(result);
            } catch (NotBoundException | RemoteException | MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            usage();
        }
    }

    private static void usage() {
        System.out.println(String.format("USAGE: java %s <FLOAT>", Client.class.getName()));
    }
}
